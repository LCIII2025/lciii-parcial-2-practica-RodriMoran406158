package ar.edu.utn.frc.tup.lc.iv.repository;

import ar.edu.utn.frc.tup.lc.iv.entities.SeccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeccionRepository extends JpaRepository<SeccionEntity, Long> {
}
