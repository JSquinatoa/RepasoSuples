package service;

import java.util.List;

import repository.model.Paciente;

public interface IPacienteService {

    // cajon
    public Paciente buscarPorCedula(String cedula);

    public void guardar(Paciente paciente);

    public List<Paciente> buscarTodos();

    // opcionales

    public Paciente buscarPorId(Integer id);

    public void actualizar(Paciente paciente);

    public void borrarPorCedula(String cedula);

}
