package com.example.jyaa2024_grupo10.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "receta")
public class Receta {
    @Id
    @Column(name = "receta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recetaId;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "porcion", nullable = false)
    private String porcion;

    @Column(name = "duracion_estimada", nullable = false)
    private String duracionEstimada;

    @Column(name = "imagen")
    private String imagen;

    @OneToMany(mappedBy = "receta")
    private List<PasoReceta> pasos;

    @OneToMany(mappedBy = "receta")
    private List<Ingrediente> ingredientes;

    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;



    public Receta(){}

    public Receta(String descripcion, String porcion, String duracionEstimada, String imagen, Producto producto) {
        this.descripcion = descripcion;
        this.porcion = porcion;
        this.duracionEstimada = duracionEstimada;
        this.imagen = imagen;
        this.producto = producto;
    }

    public Long getRecetaId() {
        return recetaId;
    }

    public void setRecetaId(Long recetaId) {
        this.recetaId = recetaId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPorcion() {
        return porcion;
    }

    public void setPorcion(String porcion) {
        this.porcion = porcion;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<PasoReceta> getPasos() {
        return pasos;
    }

    public void setPasos(List<PasoReceta> pasos) {
        this.pasos = pasos;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Receta {" +
                "\n  recetaId: " + recetaId +
                ",\n  descripcion: '" + descripcion + '\'' +
                ",\n  porcion: '" + porcion + '\'' +
                ",\n  duracionEstimada: '" + duracionEstimada + '\'' +
                ",\n  imagen: '" + imagen + '\'' +
                ",\n  producto: " + producto.getProductoId() + ", " + producto.getNombre() +
                "\n}";
    }
}