package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "insumo")
public class Insumo {
    @Id
    @Column(name = "insumo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insumoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cantidad", nullable = false)
    private double cantidad = 0;

    @Column(name = "capacidad")
    private String capacidad;

    @ManyToOne
    @JoinColumn(name = "tipo_insumo_id")
    private TipoInsumo tipo;



    public Insumo(){}

    public Insumo(String nombre, String descripcion, double cantidad, String capacidad, TipoInsumo tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
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

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Insumo {" +
                "\n  insumoId: " + insumoId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  descripcion: '" + descripcion + '\'' +
                ",\n  cantidad: " + cantidad +
                "\n}";
    }
}
