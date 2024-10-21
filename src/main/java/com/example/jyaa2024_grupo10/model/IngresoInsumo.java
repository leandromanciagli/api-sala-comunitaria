package com.example.jyaa2024_grupo10.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ingreso_insumo")
public class IngresoInsumo {
    @Id
    @Column(name = "ingreso_insumo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingresoInsumoId;

    @ManyToOne
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "monto", nullable = false)
    private double monto;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    @Column(name = "observaciones")
    private String observaciones;



    public IngresoInsumo(){}

    public IngresoInsumo(Insumo insumo, Date fecha, double monto, double cantidad, String observaciones) {
        this.insumo = insumo;
        this.fecha = fecha;
        this.monto = monto;
        this.cantidad = cantidad;
        this.observaciones = observaciones;
    }

    public Long getIngresoInsumoId() {
        return ingresoInsumoId;
    }

    public void setIngresoInsumoId(Long ingresoInsumoId) {
        this.ingresoInsumoId = ingresoInsumoId;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "IngresoInsumo {" +
                "\n  ingresoInsumoId: " + ingresoInsumoId +
                ",\n  insumo: " + insumo.getInsumoId() + ", " + insumo.getDescripcion() +
                ",\n  fecha: " + fecha +
                ",\n  monto: " + monto +
                ",\n  cantidad: " + cantidad +
                ",\n  observaciones: '" + observaciones + '\'' +
                "\n}";
    }
}