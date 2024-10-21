package com.example.jyaa2024_grupo10.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "presentacion_producto")
public class PresentacionProducto {
    @Id
    @Column(name = "presentacion_producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long presentacionProductoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "stock", nullable = false)
    private int stock = 0;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "insumo_producto_presentacion",
            joinColumns = @JoinColumn(name = "presentacion_producto_id"),
            inverseJoinColumns = @JoinColumn(name = "insumo_id"))
    private List<Insumo> insumos;



    public PresentacionProducto(){}

    public PresentacionProducto(String nombre, Producto producto, int stock, List<Insumo> insumos) {
        this.nombre = nombre;
        this.producto = producto;
        this.stock = stock;
        this.insumos = insumos;
    }

    public Long getPresentacionProductoId() {
        return presentacionProductoId;
    }

    public void setPresentacionProductoId(Long presentacionProductoId) {
        this.presentacionProductoId = presentacionProductoId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    @Override
    public String toString() {
        return "PresentacionProducto {" +
                "\n  presentacionProductoId: " + presentacionProductoId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  producto: " + producto.getProductoId() + ", " + producto.getNombre() +
                ",\n  stock: " + stock +
                ",\n  insumos: " + insumos.size() +
                "\n}";
    }
}