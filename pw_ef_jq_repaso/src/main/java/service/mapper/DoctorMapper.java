package service.mapper;

import repository.model.Doctor;
import service.to.DoctorTo;

public class DoctorMapper {

    // toTo -> mostrar Información , get

    public static DoctorTo toTo(Doctor doctor) {
        if (doctor == null) {
            return null;
        }
        DoctorTo dTo = new DoctorTo();
        dTo.setNombre(doctor.getNombre());
        dTo.setApellido(doctor.getApellido());
        dTo.setCedula(doctor.getCedula());
        return dTo;
    }

    // ToEntity -> para guardar en la base de datos

    public static Doctor toEntity(DoctorTo doctorTo) {
        Doctor d = new Doctor();
        d.setNombre(doctorTo.getNombre());
        d.setApellido(doctorTo.getApellido());
        d.setCedula(doctorTo.getCedula());
        return d;
    }

}
