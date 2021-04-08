package edu.eam.ingesoft.ejemploback.services;

import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import edu.eam.ingesoft.ejemploback.repositories.CuentaRepository;
import edu.eam.ingesoft.ejemploback.repositories.TransaccionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRespository transaccionRespository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public List<Transaccion> listarMovimientos(String cuenta) {
        return transaccionRespository.buscarTransaccionCuenta(cuenta);
    }

}
