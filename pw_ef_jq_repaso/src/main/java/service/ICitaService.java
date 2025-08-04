package service;

import java.util.List;

import repository.model.Cita;

public interface ICitaService {

        public List<Cita> buscarTodos();

    public void guardar(Cita cita);

}
