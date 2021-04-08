package edu.eam.ingesoft.ejemploback.model;


import java.io.Serializable;

public class DatosTransaccion implements Serializable {

    private String cuentaDebitar;

    private String cuentaConsignar;

    private float monto;

    public DatosTransaccion() {
    }

    public DatosTransaccion(String cuentaDebitar, String cuentaConsignar, float monto) {
        this.cuentaDebitar = cuentaDebitar;
        this.cuentaConsignar = cuentaConsignar;
        this.monto = monto;
    }

    public String getCuentaDebitar() {
        return cuentaDebitar;
    }

    public void setCuentaDebitar(String cuentaDebitar) {
        this.cuentaDebitar = cuentaDebitar;
    }

    public String getCuentaConsignar() {
        return cuentaConsignar;
    }

    public void setCuentaConsignar(String cuentaConsignar) {
        this.cuentaConsignar = cuentaConsignar;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
