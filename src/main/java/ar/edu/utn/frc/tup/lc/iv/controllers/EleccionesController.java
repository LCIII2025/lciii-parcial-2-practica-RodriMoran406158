package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.common.CargoPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.DistritoGetDto;
import ar.edu.utn.frc.tup.lc.iv.dtos.common.SeccionPorDistritoDto;
import ar.edu.utn.frc.tup.lc.iv.entities.DistritoEntity;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;
import ar.edu.utn.frc.tup.lc.iv.services.DistritoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.TypeToken;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/elecciones")
public class EleccionesController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping("/distritos")
    public ResponseEntity<List<DistritoGetDto>> getAllDistritos(@RequestParam(required = false, name = "distrito_nombre") String nombre){
        List<DistritoGetDto> listDistritosDto = distritoService.getAllDistritos(nombre);
        if(Objects.isNull(listDistritosDto)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request has an error");
        } else {
            return ResponseEntity.ok(listDistritosDto);
        }
    }

    @GetMapping("/cargos")
    public ResponseEntity<CargoPorDistritoDto> getCargoPorDistrito(@RequestParam(required = false, name = "distrito_id") Long id){
        CargoPorDistritoDto cargoPorDistritoDto = distritoService.getCargosPorDistrito(id);
        return ResponseEntity.ok(cargoPorDistritoDto);
    }

    @GetMapping("/secciones")
    public ResponseEntity<List<SeccionPorDistritoDto>> getAllSeccionesOrSeccionByDistritoId(@RequestParam(required = true, name = "distrito_id") Long distritoId,
                                                                                      @RequestParam(required = false, name = "seccion_id") Long seccionId){
        List<SeccionPorDistritoDto> seccionPorDistritoDtoList = distritoService.getSeccionesPorDistrito(distritoId,seccionId);
        return ResponseEntity.ok(seccionPorDistritoDtoList);
    }
}