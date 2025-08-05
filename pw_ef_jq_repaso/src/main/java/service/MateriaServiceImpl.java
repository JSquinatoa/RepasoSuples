package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IMateriaRepo;
import repository.model.Materia;
import repository.model.dto.MateriaDTO;

@ApplicationScoped
public class MateriaServiceImpl implements IMateriaService {

    @Inject
    private IMateriaRepo iMateriaRepo;

    @Override
    public List<MateriaDTO> obtenerTodos() {
        return this.iMateriaRepo.seleccionarTodos();
    }

    @Override
    public Materia obtenerPorId(Integer id) {
        return this.iMateriaRepo.seleccionarPorId(id);
    }

    @Override
    public void borrarPorId(Integer id) {
        this.iMateriaRepo.eliminarPorId(id);
    }

    @Override
    public void guardar(Materia materia) {
        this.iMateriaRepo.insertar(materia);
    }

}
