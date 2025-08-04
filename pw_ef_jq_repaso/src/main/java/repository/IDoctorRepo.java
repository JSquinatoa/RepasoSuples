package repository;

import repository.model.Doctor;

public interface IDoctorRepo {

    public Doctor seleccionarPorCedula(String cedula);

    public void insertar(Doctor doctor);

}
