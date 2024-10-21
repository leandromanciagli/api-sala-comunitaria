package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "paso_receta")
public class PasoReceta {
    @Id
    @Column(name = "paso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pasoId;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "indicacion", nullable = false)
    private String indicacion;



    public PasoReceta(){}

    public PasoReceta(Receta receta, int numero, String indicacion) {
        this.receta = receta;
        this.numero = numero;
        this.indicacion = indicacion;
    }

    public Long getPasoId() {
        return pasoId;
    }

    public void setPasoId(Long pasoId) {
        this.pasoId = pasoId;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getIndicacion() {
        return indicacion;
    }

    public void setIndicacion(String indicacion) {
        this.indicacion = indicacion;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        return "PasoReceta {" +
                "\n  pasoId: " + pasoId +
                ",\n  receta: " + receta.getRecetaId() + ", " + receta.getDescripcion() +
                ",\n  numero: " + numero +
                ",\n  indicacion: '" + indicacion + '\'' +
                "\n}";
    }
 }
