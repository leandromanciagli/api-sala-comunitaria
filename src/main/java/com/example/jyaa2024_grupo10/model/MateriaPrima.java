package com.example.jyaa2024_grupo10.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima {
    @Id
    @Column(name = "materia_prima_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materiaPrimaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private double cantidad = 0;

    @ManyToOne
    @JoinColumn(name = "unidad_de_medida_id")
    private UnidadDeMedida unidadDeMedida;

    @ManyToOne
    @JoinColumn(name = "tipo_materia_prima_id")
    private TipoMateriaPrima tipo;

    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDesde = new Date();

    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaHasta = null;



    public MateriaPrima(){}

    public MateriaPrima(String nombre, String descripcion, TipoMateriaPrima tipo, UnidadDeMedida unidadDeMedida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.unidadDeMedida = unidadDeMedida;
    }

    public Long getMateriaPrimaId() {
        return materiaPrimaId;
    }

    public void setMateriaPrimaId(Long materiaPrimaId) {
        this.materiaPrimaId = materiaPrimaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public TipoMateriaPrima getTipo() {
        return tipo;
    }

    public void setTipo(TipoMateriaPrima tipo) {
        this.tipo = tipo;
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
        return "MateriaPrima {" +
                "\n  materiaPrimaId: " + materiaPrimaId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  descripcion: '" + descripcion + '\'' +
                ",\n  cantidad: " + cantidad +
                ",\n  tipo: " + tipo.getTipoMateriaPrimaId() + tipo.getNombre() +
                ",\n  unidadDeMedida: " + unidadDeMedida.getUnidadDeMedidaId() + unidadDeMedida.getAbreviatura() +
                "\n}";
    }
}