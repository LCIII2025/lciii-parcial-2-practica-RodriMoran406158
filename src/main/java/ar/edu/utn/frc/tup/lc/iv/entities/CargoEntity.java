package ar.edu.utn.frc.tup.lc.iv.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cargo")
public class CargoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany()
    private List<DistritoEntity> distritos;

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

    public List<DistritoEntity> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<DistritoEntity> distritos) {
        this.distritos = distritos;
    }
}
