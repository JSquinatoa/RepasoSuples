package repository;

import java.util.List;

import repository.model.Materia;
import repository.model.dto.MateriaDTO;

public interface IMateriaRepo {

    public List<MateriaDTO> seleccionarTodos();

    public Materia seleccionarPorId(Integer id);

    public void eliminarPorId(Integer id);
    
    public void insertar(Materia materia);

}
