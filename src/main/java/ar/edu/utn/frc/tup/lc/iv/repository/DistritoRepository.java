package ar.edu.utn.frc.tup.lc.iv.repository;

import ar.edu.utn.frc.tup.lc.iv.entities.DistritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, Long> {
    List<DistritoEntity> findByNameContainingIgnoreCase(String name);
}
