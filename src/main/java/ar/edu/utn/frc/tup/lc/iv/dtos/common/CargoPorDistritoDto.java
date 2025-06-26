package ar.edu.utn.frc.tup.lc.iv.dtos.common;

import ar.edu.utn.frc.tup.lc.iv.models.Cargo;
import ar.edu.utn.frc.tup.lc.iv.models.Distrito;

import java.util.List;

public class CargoPorDistritoDto {
    private DistritoGetDto distrito;

    private List<CargoGetDto> cargos;

    public DistritoGetDto getDistrito() {
        return distrito;
    }

    public void setDistrito(DistritoGetDto distrito) {
        this.distrito = distrito;
    }

    public List<CargoGetDto> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoGetDto> cargos) {
        this.cargos = cargos;
    }
}
