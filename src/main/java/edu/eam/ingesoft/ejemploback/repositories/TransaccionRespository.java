package edu.eam.ingesoft.ejemploback.repositories;

import edu.eam.ingesoft.ejemploback.model.Cuenta;
import edu.eam.ingesoft.ejemploback.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransaccionRespository extends JpaRepository <Transaccion, String> {
    //select * from transacciones where numerocuenta = '2'

    @Query("select t from Transaccion t where t.numeroCuenta = :cuenta")
    List<Transaccion> buscarTransaccionCuenta(String cuenta);
}
