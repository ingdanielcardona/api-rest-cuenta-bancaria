package edu.eam.ingesoft.ejemploback.services;

import edu.eam.ingesoft.ejemploback.model.Cliente;
import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.DatosTransaccion;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import edu.eam.ingesoft.ejemploback.repositories.ClienteRepository;
import edu.eam.ingesoft.ejemploback.repositories.CuentaRepository;
import edu.eam.ingesoft.ejemploback.repositories.TransaccionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionRespository transaccionRespository;

    //declaramos el objeto "cuentaBD".
    Cuenta cuentaBD = new Cuenta();

    public Cuenta existenciaCuenta(Cuenta cuenta){

        cuentaBD = cuentaRepository.findById(cuenta.getId()).orElse(null);
        if (cuentaBD == null) {
            throw new RuntimeException("La cuenta no existe");
        }
        return cuenta;
    }

    public Cuenta saldoCuenta(Cuenta cuenta){
        cuentaBD.getAmount();
        if (cuentaBD == null) {
            throw new RuntimeException("no hay ");
        }
        return cuenta;
    }

    public  Cuenta crearCuenta(Cuenta cuenta) {
        Cliente cliente = clienteRepository.findById(cuenta.getCedulaCliente()).orElse(null);

        if (cliente == null) {
            throw new RuntimeException("no existe el cliente");
        }

        List<Cuenta> cuentasCliente = cuentaRepository.buscarCuentasCliente(cuenta.getCedulaCliente());

        if (cuentasCliente.size() == 3) {
            throw new RuntimeException("supero el limite de cuentas");
        }

        cuentaRepository.save(cuenta);

        return cuenta;
    }

    //consignar en cuenta
    public Cuenta consignarCuenta(Cuenta cuenta){

        Cuenta cuentaBD = cuentaRepository.findById(cuenta.getId()).orElse(null);

        if (cuentaBD == null) {
            throw new RuntimeException("no existe la cuenta");
        }

        double mTotal = cuentaBD.getAmount() + cuenta.getAmount();

        cuenta.setAmount(mTotal);
        cuenta.setCedulaCliente(cuentaBD.getCedulaCliente());
        cuenta.setFechaApertura(cuentaBD.getFechaApertura());

        //guardar consigna
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion();

        transaccion.setNumero(Math.random()*10+"");
        transaccion.setNumeroCuenta(cuentaBD.getId());
        transaccion.setTipo("consignacion");
        transaccion.setMonto(cuenta.getAmount());

        transaccionRespository.save(transaccion);


        return cuenta;
    }

    //retirar en cuenta
    public Cuenta retirarCuenta(Cuenta cuenta){

        Cuenta cuentaBD = cuentaRepository.findById(cuenta.getId()).orElse(null);

        if (cuentaBD == null) {
            throw new RuntimeException("no existe la cuenta");
        }

        double mTotal = cuentaBD.getAmount() - cuenta.getAmount();

        cuenta.setAmount(mTotal);
        cuenta.setCedulaCliente(cuentaBD.getCedulaCliente());
        cuenta.setFechaApertura(cuentaBD.getFechaApertura());

        //guardar retiro
        cuentaRepository.save(cuenta);

        Transaccion transaccion = new Transaccion();
        transaccion.setNumero(Math.random()*10+"");
        transaccion.setNumeroCuenta(cuentaBD.getId());
        transaccion.setTipo("retiro");
        transaccion.setMonto(cuenta.getAmount());

        transaccionRespository.save(transaccion);


        return cuenta;
    }

    //transferir dinero de una cuenta a otra
    public Cuenta transferirDinero(Cuenta cuenta){

        Cuenta cuentaBD = cuentaRepository.findById(cuenta.getId()).orElse(null);
        double montoTotal = cuentaBD.getAmount();

        if (cuentaBD == null) {
            throw new RuntimeException("no existe la cuenta");
        } else if (montoTotal == 0){
            throw new RuntimeException("fondos insuficientes");
        }

        double debitarMontoTotal = montoTotal - cuenta.getAmount();

        cuenta.setAmount(debitarMontoTotal);
        cuenta.setCedulaCliente(cuentaBD.getCedulaCliente());
        cuenta.setFechaApertura(cuentaBD.getFechaApertura());

        cuentaRepository.save(cuenta);

        return cuenta;
    }

    //cancelar cuenta solo si el saldo es cero
    public String cancelarCuenta(String cuenta){

        Cuenta cuentaBD = cuentaRepository.getOne(cuenta);
        System.out.println(cuentaBD);
        double montoTotal = cuentaBD.getAmount();
        String msg = "";

        if (cuentaBD == null) {
            msg = "No existe la cuenta";
            throw new RuntimeException("no existe la cuenta");
        }
        if (montoTotal == 0) {
            cuentaRepository.deleteById(cuenta);
            msg = "Cuenta eliminada";
            //throw new RuntimeException("cuenta eliminada");
        }
        if (montoTotal != 0) {
            msg = "Cuenta con fondos";
            //throw new RuntimeException("Cuenta con fondos");
        }
            return msg;
    }

    //transferir de una cuenta a otra
    public String transferenciaCuentas (DatosTransaccion datosTransaccion){
        Cuenta cuentaDebitar = cuentaRepository.findById(datosTransaccion.getCuentaDebitar()).orElse(null);
        Cuenta cuentaConsignar = cuentaRepository.findById(datosTransaccion.getCuentaConsignar()).orElse(null);
        String msg = "";

        if (cuentaDebitar == null) {
            msg = "La cuenta origen no existe";
            throw new RuntimeException("La cuenta origen no existe");

        }else if (cuentaConsignar == null) {
            msg = "La cuenta destino no existe";
            throw new RuntimeException("La cuenta destino no existe");
        }

        if (cuentaDebitar.getAmount() < datosTransaccion.getMonto()) {
            msg = "No cuenta con fondos suficientes para hacer la transferencia";
            throw new RuntimeException("No cuenta con fondos suficientes para hacer la transferencia");
        }

        Transaccion transaccionOrigen = new Transaccion();

        transaccionOrigen.setNumero(Math.random()*10+"");
        transaccionOrigen.setNumeroCuenta(datosTransaccion.getCuentaDebitar());
        transaccionOrigen.setTipo("Transferencia");
        transaccionOrigen.setMonto(datosTransaccion.getMonto());

        Transaccion transaccionDestino = new Transaccion();

        transaccionDestino.setNumero(Math.random()*10+"");
        transaccionDestino.setNumeroCuenta(datosTransaccion.getCuentaConsignar());
        transaccionDestino.setTipo("Consignacion");
        transaccionDestino.setMonto(datosTransaccion.getMonto());

        transaccionRespository.save(transaccionOrigen);
        transaccionRespository.save(transaccionDestino);

        double saldoOrigen = cuentaDebitar.getAmount() - datosTransaccion.getMonto();
        double saldoDestino = cuentaConsignar.getAmount() + datosTransaccion.getMonto();

        cuentaDebitar.setId(cuentaDebitar.getId());
        cuentaDebitar.setFechaApertura(cuentaDebitar.getFechaApertura());
        cuentaDebitar.setCedulaCliente(cuentaDebitar.getCedulaCliente());
        cuentaDebitar.setAmount(saldoOrigen);

        cuentaConsignar.setId(cuentaConsignar.getId());
        cuentaConsignar.setFechaApertura(cuentaConsignar.getFechaApertura());
        cuentaConsignar.setCedulaCliente(cuentaConsignar.getCedulaCliente());
        cuentaConsignar.setAmount(saldoDestino);

        cuentaRepository.save(cuentaDebitar);
        cuentaRepository.save(cuentaConsignar);

        msg= "Saldo: " + saldoOrigen;
        return msg;
    }

    public List<Cuenta> listarCuentasCliente(String cedula) {
        return cuentaRepository.buscarCuentasCliente(cedula);
    }

}
