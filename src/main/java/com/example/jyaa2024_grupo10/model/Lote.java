package com.example.jyaa2024_grupo10.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "lote")
public class Lote {
    @Id
    @Column(name = "lote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loteId;

    @Column(name = "cantidad_productos", nullable = false)
    private int cantidadProductos = 0;

    @Column(name = "fecha_vencimiento", nullable = false)
    private Date fechaDeVencimiento;

    @OneToOne
    @JoinColumn(name = "elaboracion_id")
    private Elaboracion elaboracion;

    @OneToMany(mappedBy = "lote")
    private List<LotePresentacionProductoDetalle> lotesPresentacionProductoDetalle;



    public Lote(){}

    public Lote(int cantidadProductos, Date fechaDeVencimiento, Elaboracion elaboracion, List<LotePresentacionProductoDetalle> lotesPresentacionProductoDetalle) {
        this.cantidadProductos = cantidadProductos;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.elaboracion = elaboracion;
        this.lotesPresentacionProductoDetalle = lotesPresentacionProductoDetalle;
    }

    public Long getLoteId() {
        return loteId;
    }

    public void setLoteId(Long loteId) {
        this.loteId = loteId;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public Date getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(Date fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Elaboracion getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Elaboracion elaboracion) {
        this.elaboracion = elaboracion;
    }

    public List<LotePresentacionProductoDetalle> getLotesPresentacionProductoDetalle() {
        return lotesPresentacionProductoDetalle;
    }

    public void setLotesPresentacionProductoDetalle(List<LotePresentacionProductoDetalle> lotesPresentacionProductoDetalle) {
        this.lotesPresentacionProductoDetalle = lotesPresentacionProductoDetalle;
    }

    @Override
    public String toString() {
        return "Lote {" +
                "\n  loteId: " + loteId +
                ",\n  cantidadProductos: " + cantidadProductos +
                ",\n  fechaDeVencimiento: " + fechaDeVencimiento +
                ",\n  elaboracion: " + elaboracion.getElaboracionId() + ", " + elaboracion.getReceta().getDescripcion() + " del " + elaboracion.getFecha() +
                //",\n  lotesPresentacionProductoDetalle: " + lotesPresentacionProductoDetalle.size() +
                "\n}";
    }
}