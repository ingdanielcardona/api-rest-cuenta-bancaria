package edu.eam.ingesoft.ejemploback.controllers;

import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.DatosTransaccion;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import edu.eam.ingesoft.ejemploback.services.CuentaService;
import edu.eam.ingesoft.ejemploback.services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private TransaccionService transaccionService;


    @PostMapping("/accounts")
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta){
        return cuentaService.crearCuenta(cuenta);
    }

    @GetMapping("/customers/{cedula}/accounts")
    public List<Cuenta> listarCuentasCliente(@PathVariable String cedula) {
        return cuentaService.listarCuentasCliente(cedula);
    }
    @GetMapping("/transaccion/{id}")
    public List<Transaccion> listarMovimientos(@PathVariable String id) {
        return transaccionService.listarMovimientos(id);
    }

    //Acciones de la Cuenta
    @PutMapping("/accounts/consignar")
    public Cuenta consignar(@RequestBody Cuenta cuenta) {
        return cuentaService.consignarCuenta(cuenta);
    }

    @PutMapping("/accounts/retirar")
    public Cuenta retirar(@RequestBody Cuenta cuenta) {
        return cuentaService.retirarCuenta(cuenta);
    }

    @PutMapping("/accounts/transferir")
    public String transferir(@RequestBody DatosTransaccion datosTransaccion) {
        return cuentaService.transferenciaCuentas(datosTransaccion);
    }

    @DeleteMapping("/accounts/{cuenta}")
    public String cancelarCuenta(@PathVariable String cuenta) {
        return cuentaService.cancelarCuenta(cuenta);
    }

}
