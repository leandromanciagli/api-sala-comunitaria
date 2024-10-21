package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "unidad_de_medida", nullable = false)
    private String unidadDeMedida;

    @Column(name = "stock", nullable = false)
    private int stock = 0;

    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER)
    private List<PresentacionProducto> presentaciones;



    public Producto(){}

    public Producto(String nombre, String descripcion, String unidadDeMedida, int stock, List<PresentacionProducto> presentaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadDeMedida = unidadDeMedida;
        this.stock = stock;
        this.presentaciones = presentaciones;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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

    public String getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(String unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<PresentacionProducto> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<PresentacionProducto> presentaciones) {
        this.presentaciones = presentaciones;
    }

    @Override
    public String toString() {
        return "Producto {" +
                "\n  productoId: " + productoId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  descripcion: '" + descripcion + '\'' +
                ",\n  unidadDeMedida: '" + unidadDeMedida + '\'' +
                ",\n  stock: " + stock +
                ",\n  presentaciones: " + presentaciones.size() +
                "\n}";
    }
}