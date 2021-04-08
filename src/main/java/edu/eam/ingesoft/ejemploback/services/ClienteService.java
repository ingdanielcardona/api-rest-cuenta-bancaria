package edu.eam.ingesoft.ejemploback.services;

import ch.qos.logback.core.net.server.Client;
import edu.eam.ingesoft.ejemploback.model.Cliente;
import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.repositories.ClienteRepository;
import edu.eam.ingesoft.ejemploback.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    public void crearCliente(Cliente cliente) {
        //buscando el cliente en la BD
        Cliente clienteBD = clienteRepository.findById(cliente.getCedula()).orElse(null);

        //si es diferente de null es porque ya existe....
        if (clienteBD != null) {
            throw new RuntimeException("ya existe este cliente");
        }

        clienteRepository.save(cliente);
    }

    public Cliente buscarCliente(String cedula) {
        //orElse retorna el resultado o null si no hay resultado...
        return clienteRepository.findById(cedula).orElse(null);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente editarCliente(Cliente cliente) {
        Cliente clieteBD = clienteRepository.getOne(cliente.getCedula());

        if (clieteBD == null) {
            throw new RuntimeException("No existe el cliente");
        }

        clienteRepository.save(cliente);

        return cliente;
    }

    //eliminar cliente solo si no tiene cuentas
    public void borrarCliente(String cedula) {

        Cliente clieteBD = clienteRepository.getOne(cedula);
        if (clieteBD == null) {
            throw new RuntimeException("No existe el cliente");
        }
        if (cuentaRepository.buscarCuentasCliente(cedula).isEmpty()) {
            clienteRepository.deleteById(cedula);
            System.out.println("cliente borrado");
        } else {
            throw new RuntimeException("el cliente tiene cuentas");
        }
    }
}
