package service;

import java.util.List;

import repository.model.Materia;
import repository.model.dto.MateriaDTO;

public interface IMateriaService {

    public List<MateriaDTO> obtenerTodos();

    public Materia obtenerPorId(Integer id);

    public void borrarPorId(Integer id);

    public void guardar(Materia materia);

}
