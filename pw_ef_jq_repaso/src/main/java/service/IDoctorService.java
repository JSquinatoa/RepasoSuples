package service;

import repository.model.Doctor;

public interface IDoctorService {

    public Doctor buscarPorCedula(String cedula);

    public void guardar(Doctor doctor);

}
