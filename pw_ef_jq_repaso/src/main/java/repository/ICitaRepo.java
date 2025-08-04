package repository;

import java.util.List;

import repository.model.Cita;

public interface ICitaRepo {

    public List<Cita> seleccionarTodos();

    public void insertar(Cita cita);

}
