package service.mapper;

import repository.model.Paciente;
import service.to.PacienteTo;

public class PacienteMapper {

    public static Paciente toEntity(PacienteTo pacienteTo) {
        Paciente p = new Paciente();
        p.setId(pacienteTo.getId());
        p.setNombre(pacienteTo.getNombre());
        p.setApellido(pacienteTo.getApellido());
        p.setCedula(pacienteTo.getCedula());
        p.setFechaNacimiento(pacienteTo.getFechaNacimiento());
        return p;
    }

}
