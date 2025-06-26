package ar.edu.utn.frc.tup.lc.iv.entities;


import ar.edu.utn.frc.tup.lc.iv.models.Cargo;
import ar.edu.utn.frc.tup.lc.iv.models.Seccion;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="distrito")
public class DistritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "distrito_cargo",
            joinColumns = @JoinColumn(name = "distrito_id"),
            inverseJoinColumns = @JoinColumn(name = "cargo_id")
    )
    private List<CargoEntity> cargos;

    @OneToMany(mappedBy = "distrito", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<SeccionEntity> secciones;

    public List<SeccionEntity> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<SeccionEntity> secciones) {
        this.secciones = secciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CargoEntity> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoEntity> cargos) {
        this.cargos = cargos;
    }
}
