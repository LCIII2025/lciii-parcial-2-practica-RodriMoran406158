package ar.edu.utn.frc.tup.lc.iv.services.impl;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoGetDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoGetDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.entities.CargoEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.DistritoEntity;
import ar.edu.utn.frc.tup.lc.iv.entities.SeccionEntity;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import ar.edu.utn.frc.tup.lc.iv.repository.CargoRepository;
import ar.edu.utn.frc.tup.lc.iv.repository.DistritoRepository;
import ar.edu.utn.frc.tup.lc.iv.repository.SeccionRepository;
import ar.edu.utn.frc.tup.lc.iv.services.DistritoService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DistritoServiceImpl implements DistritoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DistritoRepository distritoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private SeccionRepository seccionRepository;

    @Override
    public List<DistritoGetDto> getAllDistritos(String nombre) {

        List<DistritoGetDto> distritosReturn = new ArrayList<>();
        if(Objects.isNull(nombre)) {
            List<DistritoEntity> allDistritosEntities = distritoRepository.findAll();
            for (DistritoEntity d : allDistritosEntities) {
                distritosReturn.add(modelMapper.map(d, DistritoGetDto.class));
            }
            return distritosReturn;
        } else {
            List<DistritoEntity> allDistritosEntities = distritoRepository.findByNameContainingIgnoreCase(nombre);
            for (DistritoEntity d : allDistritosEntities) {
                distritosReturn.add(modelMapper.map(d, DistritoGetDto.class));
            }
            return distritosReturn;
        }
    }

    @Override
    public CargoPorDistritoDto getCargosPorDistrito(Long distritoId) {

        Optional<DistritoEntity> distritoEntityOptional = distritoRepository.findById(distritoId);

        List<CargoEntity> cargosByDistrito = cargoRepository.findAll()
                .stream()
                .filter(c ->c.getDistritos().stream().allMatch(d -> d.getId().equals(distritoId)))
                .toList();
        if(distritoEntityOptional.isEmpty()){
            throw new EntityNotFoundException("No se encontró el distrito con ID: " + distritoId);
        }
        if(cargosByDistrito.isEmpty()){
            throw new EntityNotFoundException("No se encontró cargos para el distrito con ID: " + distritoId);
        }

        CargoPorDistritoDto cargoPorDistritoDto = new CargoPorDistritoDto();


        List<CargoGetDto> cargoGetDtoList = new ArrayList<>();
        for (CargoEntity c : cargosByDistrito){
            cargoGetDtoList.add(modelMapper.map(c, CargoGetDto.class));
        }
        cargoPorDistritoDto.setCargos(cargoGetDtoList);

        cargoPorDistritoDto.setDistrito(modelMapper.map(distritoEntityOptional.get(), DistritoGetDto.class));

        return cargoPorDistritoDto;
    }

    @Override
    public List<SeccionPorDistritoDto> getSeccionesPorDistrito(Long distritoId, Long seccionId) {
        DistritoEntity distritoEntity = distritoRepository.findById(distritoId)
                .orElseThrow(() -> new EntityNotFoundException("Distrito con ID: " + distritoId + " no encontrado."));

        List<SeccionPorDistritoDto> seccionesReturn = new ArrayList<>();
        if(Objects.isNull(seccionId)){
                for (SeccionEntity seccionEntity : distritoEntity.getSecciones()){
                    seccionesReturn.add(modelMapper.map(seccionEntity, SeccionPorDistritoDto.class));
                }
                return seccionesReturn;

        } else {

            SeccionEntity seccionEntity = distritoEntity.getSecciones()
                    .stream()
                    .filter(s -> s.getId().equals(seccionId))
                    .findAny()
                    .orElseThrow(() -> new EntityNotFoundException("Sección con ID " + seccionId + " no encontrada."));


            SeccionPorDistritoDto seccionPorDistritoDto = new SeccionPorDistritoDto();
            seccionPorDistritoDto.setNombre(seccionEntity.getNombre());
            seccionesReturn.add(seccionPorDistritoDto);
            return seccionesReturn;
        }

    }
}