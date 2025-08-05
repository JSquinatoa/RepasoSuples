package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Materia;
import repository.model.dto.MateriaDTO;

@ApplicationScoped
@Transactional
public class MateriaRepoImpl implements IMateriaRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MateriaDTO> seleccionarTodos() {
        TypedQuery<MateriaDTO> myQuery = this.entityManager.createQuery("SELECT m.id, m.nombre, m.codigo, m.numeroCreditos FROM Materia m", MateriaDTO.class);
        return myQuery.getResultList();
    }

    @Override
    public Materia seleccionarPorId(Integer id) {
        return this.entityManager.find(Materia.class, id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        this.entityManager.remove(seleccionarPorId(id));
    }

    @Override
    public void insertar(Materia materia) {
        this.entityManager.persist(materia);
    }

}
