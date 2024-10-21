package com.example.jyaa2024_grupo10.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "productora_agricola")
public class ProductoraAgricola {
    @Id
    @Column(name = "productora_agricola_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productoraAgricolaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    @Column(name = "fecha_desde")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaDesde = new Date();

    @Column(name = "fecha_hasta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaHasta = null;


    public ProductoraAgricola(){}

    public ProductoraAgricola(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Long getProductoraAgricolaId() {
        return productoraAgricolaId;
    }

    public void setProductoraAgricolaId(Long productoraAgricolaId) {
        this.productoraAgricolaId = productoraAgricolaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "ProductoraAgricola {" +
                "\n  productoraAgricolaId: " + productoraAgricolaId +
                ",\n  nombre: '" + nombre + '\'' +
                ",\n  direccion: '" + direccion + '\'' +
                ",\n  telefono: '" + telefono + '\'' +
                ",\n  email: '" + email + '\'' +
                "\n}";
    }
}
