package repository;

import java.util.List;

import repository.model.Paciente;

public interface IPacienteRepo {

    // cajon
    public Paciente seleccionarPorCedula(String cedula);

    public void insertar(Paciente paciente);

    public List<Paciente> seleccionarTodos();

    // opcionales

    public Paciente seleccionarPorId(Integer id);

    public void actualizar(Paciente paciente);

    public void eliminarPorCedula(String cedula);

}
