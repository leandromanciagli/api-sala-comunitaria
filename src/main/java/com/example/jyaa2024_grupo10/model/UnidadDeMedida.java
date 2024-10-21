package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "unidad_de_medida")
public class UnidadDeMedida {

    @Id
    @Column(name = "unidad_de_medida_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidadDeMedidaId;

    @Column(name = "denominacion", nullable = false, unique = true)
    private String denominacion;

    @Column(name = "abreviatura", nullable = false)
    private String abreviatura;


    public UnidadDeMedida(){}

    public UnidadDeMedida(String denominacion, String abreviatura) {
        this.denominacion = denominacion;
        this.abreviatura = abreviatura;
    }

    public Long getUnidadDeMedidaId() {
        return unidadDeMedidaId;
    }

    public void setUnidadDeMedidaId(Long unidadDeMedidaId) {
        this.unidadDeMedidaId = unidadDeMedidaId;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return "UnidadDeMedida {" +
                "\n  unidadDeMedidaId: " + unidadDeMedidaId +
                ",\n  denominacion: '" + denominacion + '\'' +
                ",\n  abreviatura: '" + abreviatura + '\'' +
                "\n}";
    }
}
