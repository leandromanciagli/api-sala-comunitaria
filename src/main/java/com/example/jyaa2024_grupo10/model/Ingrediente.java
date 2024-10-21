package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente
{
    @Id
    @Column(name = "ingrediente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredienteId;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @ManyToOne
    @JoinColumn(name = "materia_prima_id")
    private MateriaPrima materiaPrima;

    @Column(name = "cantidad", nullable = false)
    private double cantidad;



    public Ingrediente(){}

    public Ingrediente(Receta receta, MateriaPrima materiaPrima, double cantidad) {
        this.receta = receta;
        this.materiaPrima = materiaPrima;
        this.cantidad = cantidad;
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ingrediente {" +
                "\n  ingredienteId: " + ingredienteId +
                ",\n  receta: " + receta.getRecetaId() + ", " + receta.getDescripcion() +
                ",\n  materia prima: " + materiaPrima.getMateriaPrimaId() + ", " + materiaPrima.getDescripcion() +
                ",\n  cantidad: " + cantidad +
                "\n}";
    }
}
