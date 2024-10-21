package com.example.jyaa2024_grupo10.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "ingreso_materia_prima")
public class IngresoMateriaPrima {
    @Id
    @Column(name = "ingreso_materia_prima_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingresoMateriaPrimaId;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id", nullable = false)
    private MateriaPrima materiaPrima;

    @ManyToOne
    @JoinColumn(name = "productora_agricola_id", nullable = false)
    private ProductoraAgricola productoraAgricola;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDeIngreso;

    @Column(name = "agroecologico")
    private Character agroecologico;

    @Column(name = "fecha_cosecha")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDeCosecha;

    @ManyToOne
    @JoinColumn(name = "modo_almacenamiento_id", nullable = false)
    private ModoAlmacenamiento modoAlmacenamiento;

    @Column(name = "fecha_almacenamiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDeAlmacenamiento;

    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDesde = new Date();

    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaHasta = null;



    public IngresoMateriaPrima(){}

    public IngresoMateriaPrima(
            Date fechaDeIngreso,
            MateriaPrima materiaPrima,
            ProductoraAgricola productoraAgricola,
            double cantidad,
            Date fechaDeCosecha,
            Character agroecologico,
            ModoAlmacenamiento modoAlmacenamiento,
            Date fechaDeAlmacenamiento
    ) {
        this.fechaDeIngreso = fechaDeIngreso;
        this.materiaPrima = materiaPrima;
        this.productoraAgricola = productoraAgricola;
        this.cantidad = cantidad;
        this.fechaDeCosecha = fechaDeCosecha;
        this.agroecologico = agroecologico;
        this.modoAlmacenamiento = modoAlmacenamiento;
        this.fechaDeAlmacenamiento = fechaDeAlmacenamiento;
    }

    public Long getIngresoMateriaPrimaId() {
        return ingresoMateriaPrimaId;
    }

    public void setIngresoMateriaPrimaId(Long ingresoMateriaPrimaId) {
        this.ingresoMateriaPrimaId = ingresoMateriaPrimaId;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public ProductoraAgricola getProductoraAgricola() {
        return productoraAgricola;
    }

    public void setProductoraAgricola(ProductoraAgricola productoraAgricola) {
        this.productoraAgricola = productoraAgricola;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaDeIngreso() {
        return fechaDeIngreso;
    }

    public void setFechaDeIngreso(Date fechaDeIngreso) {
        this.fechaDeIngreso = fechaDeIngreso;
    }

    public ModoAlmacenamiento getModoAlmacenamiento() {
        return modoAlmacenamiento;
    }

    public void setModoAlmacenamiento(ModoAlmacenamiento modoAlmacenamiento) {
        this.modoAlmacenamiento = modoAlmacenamiento;
    }

    public Character getAgroecologico() {
        return agroecologico;
    }

    public void setAgroecologico(Character agroecologico) {
        this.agroecologico = agroecologico;
    }

    public Date getFechaDeCosecha() {
        return fechaDeCosecha;
    }

    public void setFechaDeCosecha(Date fechaDeCosecha) {
        this.fechaDeCosecha = fechaDeCosecha;
    }

    public Date getFechaDeAlmacenamiento() {
        return fechaDeAlmacenamiento;
    }

    public void setFechaDeAlmacenamiento(Date fechaDeAlmacenamiento) {
        this.fechaDeAlmacenamiento = fechaDeAlmacenamiento;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "IngresoMateriaPrima {" +
                "\n  ingresoMateriaPrimaId: " + ingresoMateriaPrimaId +
                ",\n  materiaPrima: " + materiaPrima.getMateriaPrimaId() + ", " + materiaPrima.getDescripcion() +
                ",\n  productoraAgricola: " + productoraAgricola.getProductoraAgricolaId() + ", " + productoraAgricola.getNombre() +
                ",\n  modoAlmacenamiento: " + modoAlmacenamiento.getModoAlmacenamientoId() + ", " + modoAlmacenamiento.getNombre() +
                ",\n  agroecologico: " + agroecologico +
                ",\n  fechaDeCosecha: " + fechaDeCosecha +
                ",\n  fechaDeAlmacenamiento: " + fechaDeAlmacenamiento +
                "\n}";
    }
}
