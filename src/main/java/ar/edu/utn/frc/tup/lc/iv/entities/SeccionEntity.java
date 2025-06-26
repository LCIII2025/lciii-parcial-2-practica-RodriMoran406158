package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "seccion_entity")
public class SeccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
//    @JoinColumn(name = "distrito_id")
    private DistritoEntity distrito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DistritoEntity getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoEntity distrito) {
        this.distrito = distrito;
    }
}
