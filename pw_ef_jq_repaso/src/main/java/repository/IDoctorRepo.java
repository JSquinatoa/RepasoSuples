package repository;

import java.util.List;

import repository.model.Doctor;

public interface IDoctorRepo {

    public Doctor seleccionarPorId(String cedula);

    public List<Doctor> seleccionarTodos();

    public void insertar(Doctor doctor);

    // opcionales

    public void actualizar(Doctor doctor);

    public void eliminarPorId(String cedula);

}
