package edu.eam.ingesoft.ejemploback.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transacciones")
public class Transaccion implements Serializable {

    @Id
    @Column(name = "numero")
    private String numero;

    @Column(name = "numerocuenta")
    private String numeroCuenta;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "monto")
    private double monto;

    @Column(name = "fecha")
    private Date date;

    public Transaccion() {date = new Date();}

    public Transaccion(String numero, String numeroCuenta, String tipo, double monto, Date date) {
        this.numero = numero;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.date = date;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
