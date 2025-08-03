package service;

import java.util.List;

import repository.model.Doctor;
import service.to.UsuarioTo;

public interface IDoctorService {

    public Doctor buscarPorId(String cedula);

    public List<Doctor> buscarTodos();

    public void guardar(Doctor doctor);

    // opcionales

    public void actualizar(Doctor doctor);

    public void borrarPorId(String cedula);

    // autentiación

    public Boolean verificarDoctor(UsuarioTo usuarioTo);

}
