package service.mapper;

import repository.model.Doctor;
import repository.model.Paciente;
import service.to.PacienteTo;

public class PacienteMapper {

    // toTo
    public static PacienteTo toTo (Paciente paciente){
        if (paciente == null) {
            return null;            
        }
        PacienteTo pTo = new PacienteTo();
        pTo.setId(paciente.getId());
        pTo.setNombre(paciente.getNombre());
        pTo.setApellido(paciente.getApellido());
        pTo.setCedula(paciente.getCedula());
        pTo.setNombreDoctor(paciente.getDoctor().getNombre());
        pTo.setCedulaDoctor(paciente.getDoctor().getCedula());
        return pTo;
    }

    // TOEntity
    public static Paciente toEntity (PacienteTo pacienteTo){
        Paciente p = new Paciente();
        p.setId(pacienteTo.getId());
        p.setNombre(pacienteTo.getNombre());
        p.setApellido(pacienteTo.getApellido());
        p.setCedula(pacienteTo.getCedula());

        Doctor d = new Doctor();
        d.setCedula(pacienteTo.getCedulaDoctor());

        p.setDoctor(d);
        
        return p;
    }

}
