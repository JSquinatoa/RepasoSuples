package service.mapper;

import repository.model.Cita;
import repository.model.Doctor;
import repository.model.Paciente;
import service.to.CitaTo;

public class CitaMapper {

    public static CitaTo toTo (Cita cita){
        if (cita == null) {
            return null;            
        }
        CitaTo cTo = new CitaTo();
        cTo.setId(cita.getId());
        cTo.setFechaCita(cita.getFechaCita());
        cTo.setNombrePaciente(cita.getPaciente().getNombre());
        cTo.setApellidoPaciente(cita.getPaciente().getApellido());
        cTo.setCedulaPaciente(cita.getPaciente().getCedula());
        cTo.setNombreDoctor(cita.getDoctor().getNombre());
        cTo.setCedulaDoctor(cita.getDoctor().getCedula());
        return cTo;
    }

    public static Cita toEntity (CitaTo citaTo){
        Cita c = new Cita();
        c.setId(citaTo.getId());
        c.setFechaCita(citaTo.getFechaCita());

        Paciente p = new Paciente();
        p.setCedula(citaTo.getCedulaPaciente());
        c.setPaciente(p);

        Doctor d = new Doctor();
        d.setCedula(citaTo.getCedulaDoctor());
        c.setDoctor(d);

        return c;
    }

}
