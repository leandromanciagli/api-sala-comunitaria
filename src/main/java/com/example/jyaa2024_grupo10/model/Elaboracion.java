package com.example.jyaa2024_grupo10.model;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "elaboracion")
public class Elaboracion {
    @Id
    @Column(name = "elaboracion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elaboracionId;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @OneToMany(mappedBy = "elaboracion")
    private List<NotaElaboracion> notas;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @Column(name = "cantidad_producida", nullable = false)
    private double cantidadProducida;

    @Column(name = "observaciones")
    private String observaciones;



    public Elaboracion(){}

    public Elaboracion(Date fecha, List<NotaElaboracion> notas, Receta receta, double cantidadProducida, String observaciones) {
        this.fecha = fecha;
        this.notas = notas;
        this.receta = receta;
        this.cantidadProducida = cantidadProducida;
        this.observaciones = observaciones;
    }

    public Long getElaboracionId() {
        return elaboracionId;
    }

    public void setElaboracionId(Long elaboracionId) {
        this.elaboracionId = elaboracionId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<NotaElaboracion> getNotas() {
        return notas;
    }

    public void setNotas(List<NotaElaboracion> notas) {
        this.notas = notas;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public double getCantidadProducida() {
        return cantidadProducida;
    }

    public void setCantidadProducida(double cantidadProducida) {
        this.cantidadProducida = cantidadProducida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Elaboracion {" +
                "\n  elaboracionId: " + elaboracionId +
                ",\n  fecha: " + fecha +
                //",\n  notas: " + notas.size() +
                ",\n  receta: " + receta.getRecetaId() + ", " + receta.getDescripcion() +
                ",\n  cantidadProducida: " + cantidadProducida +
                ",\n  observaciones: '" + observaciones + '\'' +
                "\n}";
    }
}
