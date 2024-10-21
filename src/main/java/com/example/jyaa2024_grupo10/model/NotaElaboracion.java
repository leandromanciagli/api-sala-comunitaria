package com.example.jyaa2024_grupo10.model;

import javax.persistence.*;

@Entity
@Table(name = "nota_elaboracion")
public class NotaElaboracion {
    @Id
    @Column(name = "nota_elaboracion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notaElaboracionId;

    @ManyToOne
    @JoinColumn(name = "elaboracion_id")
    private Elaboracion elaboracion;

    @ManyToOne
    @JoinColumn(name = "paso_receta_id")
    private PasoReceta paso;

    @Column(name = "observacion", nullable = false)
    private String observacion;



    public NotaElaboracion(){}

    public NotaElaboracion(Elaboracion elaboracion, PasoReceta paso, String observacion) {
        this.elaboracion = elaboracion;
        this.paso = paso;
        this.observacion = observacion;
    }

    public Long getNotaElaboracionId() {
        return notaElaboracionId;
    }

    public void setNotaElaboracionId(Long notaElaboracionId) {
        this.notaElaboracionId = notaElaboracionId;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Elaboracion getElaboracion() {
        return elaboracion;
    }

    public void setElaboracion(Elaboracion elaboracion) {
        this.elaboracion = elaboracion;
    }

    public PasoReceta getPaso() {
        return paso;
    }

    public void setPaso(PasoReceta paso) {
        this.paso = paso;
    }

    @Override
    public String toString() {
        return "NotaElaboracion {" +
                "\n  notaElaboracionId: " + notaElaboracionId +
                ",\n  elaboracion: " + elaboracion.getElaboracionId() + ", " + elaboracion.getReceta().getDescripcion() + " del " + elaboracion.getFecha() +
                ",\n  paso: " + paso.getPasoId() + ", receta: " + paso.getReceta().getRecetaId() + "paso " + paso.getNumero() +
                ",\n  observacion: '" + observacion + '\'' +
                "\n}";
    }
}
