package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_insumo")
public class TipoInsumo{

    @Id
    @Column(name = "tipo_insumo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long tipoInsumoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;



    public TipoInsumo(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoInsumo(){}

    public Long getTipoInsumoId() {
        return tipoInsumoId;
    }

    public void setTipoInsumoId(Long tipoInsumoId) {
        this.tipoInsumoId = tipoInsumoId;
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

    @Override
    public String toString() {
        return "TipoInsumo {" +
                "\n  tipoInsumoId: " + tipoInsumoId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  descripcion: '" + descripcion + '\'' +
                "\n}";
    }
}