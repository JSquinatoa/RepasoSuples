package service;

import repository.model.Paciente;

public interface IPacienteService {

    public Paciente buscarPorCedula(String cedula);

    public void guardar(Paciente paciente);

}
