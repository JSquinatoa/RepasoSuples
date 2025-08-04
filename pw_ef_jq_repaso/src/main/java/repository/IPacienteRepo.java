package repository;

import repository.model.Paciente;

public interface IPacienteRepo {

    public Paciente seleccionarPorCedula(String cedula);

    public void insertar(Paciente paciente);

}
