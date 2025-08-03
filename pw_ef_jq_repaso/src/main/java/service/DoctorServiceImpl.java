package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IDoctorRepo;
import repository.model.Doctor;
import service.to.UsuarioTo;

@ApplicationScoped
public class DoctorServiceImpl implements IDoctorService {

    @Inject
    private IDoctorRepo iDoctorRepo;

    @Override
    public Doctor buscarPorId(String cedula) {
        return this.iDoctorRepo.seleccionarPorId(cedula);
    }

    @Override
    public List<Doctor> buscarTodos() {
        return this.iDoctorRepo.seleccionarTodos();
    }

    @Override
    public void guardar(Doctor doctor) {
        this.iDoctorRepo.insertar(doctor);
    }

    @Override
    public void actualizar(Doctor doctor) {
        this.iDoctorRepo.actualizar(doctor);
    }

    @Override
    public void borrarPorId(String cedula) {
        this.iDoctorRepo.eliminarPorId(cedula);
    }

    @Override
    public Boolean verificarDoctor(UsuarioTo usuarioTo) {
        Doctor d = buscarPorId(usuarioTo.getCedula());

        if (d.getPassword().equals(usuarioTo.getPassword())) {
            return true;            
        }
    
        return false;
    }

}
