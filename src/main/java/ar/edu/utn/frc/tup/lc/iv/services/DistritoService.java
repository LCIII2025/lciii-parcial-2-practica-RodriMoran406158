package ar.edu.utn.frc.tup.lc.iv.services;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoGetDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoGetDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistritoService {
    List<DistritoGetDto> getAllDistritos(String nombre);

    CargoPorDistritoDto getCargosPorDistrito(Long distritoId);

    List<SeccionPorDistritoDto> getSeccionesPorDistrito(Long distritoId, Long seccionId);
}