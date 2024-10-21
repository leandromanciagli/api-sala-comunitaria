package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "lote_presentacion_producto_detalle")
public class LotePresentacionProductoDetalle {
    @Id
    @Column(name = "lote_presentacion_producto_detalle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lotePresentacionProductoDetalleId;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

    @ManyToOne
    @JoinColumn(name = "presentacion_producto_id")
    private PresentacionProducto presentacion;

    @Column(name = "costo_unitario", nullable = false)
    private double costoUnitario;

    @Column(name = "porcentaje_ganancia", nullable = false)
    private double porcentajeDeGanancia;



    public LotePresentacionProductoDetalle() {}

    public LotePresentacionProductoDetalle(Lote lote, PresentacionProducto presentacion, double costoUnitario, double porcentajeDeGanancia) {
        this.lote = lote;
        this.presentacion = presentacion;
        this.costoUnitario = costoUnitario;
        this.porcentajeDeGanancia = porcentajeDeGanancia;
    }

    public Long getLotePresentacionProductoDetalleId() {
        return lotePresentacionProductoDetalleId;
    }

    public void setLotePresentacionProductoDetalleId(Long lotePresentacionProductoDetalleId) {
        this.lotePresentacionProductoDetalleId = lotePresentacionProductoDetalleId;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getPorcentajeDeGanancia() {
        return porcentajeDeGanancia;
    }

    public void setPorcentajeDeGanancia(double porcentajeDeGanancia) {
        this.porcentajeDeGanancia = porcentajeDeGanancia;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public PresentacionProducto getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(PresentacionProducto presentacion) {
        this.presentacion = presentacion;
    }

    @Override
    public String toString() {
        return "LotePresentacionProductoDetalle {" +
                "\n  lotePresentacionProductoDetalleId: " + lotePresentacionProductoDetalleId +
                ",\n  lote: " + lote.getLoteId() +
                ",\n  presentacion: " + presentacion.getPresentacionProductoId() + ", " + presentacion.getNombre() +
                ",\n  costoUnitario: " + costoUnitario +
                ",\n  porcentajeDeGanancia: " + porcentajeDeGanancia +
                "\n}";
    }
}
