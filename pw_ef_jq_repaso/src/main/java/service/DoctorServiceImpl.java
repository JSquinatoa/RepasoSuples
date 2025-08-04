package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IDoctorRepo;
import repository.model.Doctor;

@ApplicationScoped
public class DoctorServiceImpl implements IDoctorService {

    @Inject
    private IDoctorRepo iDoctorRepo;

    @Override
    public Doctor buscarPorCedula(String cedula) {
        return this.iDoctorRepo.seleccionarPorCedula(cedula);
    }

    @Override
    public void guardar(Doctor doctor) {
        this.iDoctorRepo.insertar(doctor);
    }

}
