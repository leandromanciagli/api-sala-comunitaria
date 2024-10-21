package com.example.jyaa2024_grupo10.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tipo_materia_prima")
public class TipoMateriaPrima {

    @Id
    @Column(name = "tipo_materia_prima_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoMateriaPrimaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDesde = new Date();

    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaHasta = null;


    public TipoMateriaPrima(){}

    public TipoMateriaPrima(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Long getTipoMateriaPrimaId() {
        return tipoMateriaPrimaId;
    }

    public void setTipoMateriaPrimaId(Long tipoMateriaPrimaId) {
        this.tipoMateriaPrimaId = tipoMateriaPrimaId;
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
        return "TipoMateriaPrima {" +
                "\n  tipoMateriaPrimaId: " + tipoMateriaPrimaId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  descripcion: '" + descripcion + '\'' +
                "\n}";
    }


}