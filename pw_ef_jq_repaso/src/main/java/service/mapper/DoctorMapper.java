package service.mapper;

import repository.model.Doctor;
import service.to.DoctorTo;

public class DoctorMapper {

    public static Doctor toEntity(DoctorTo doctorTo) {
        Doctor d = new Doctor();
        d.setId(doctorTo.getId());
        d.setCedula(doctorTo.getCedula());
        d.setNombre(doctorTo.getNombre());
        d.setApellido(doctorTo.getApellido());
        d.setGenero(doctorTo.getGenero());
        return d;
    }

}
