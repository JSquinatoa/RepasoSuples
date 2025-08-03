package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Paciente;

@ApplicationScoped
@Transactional
public class IPacienteRepoImpl implements IPacienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    // cajon

    @Override
    public Paciente seleccionarPorCedula(String cedula) {
        try {
            TypedQuery<Paciente> myQuery = this.entityManager
                    .createQuery("SELECT p FROM Paciente p WHERE p.cedula = :cedula", Paciente.class);
            myQuery.setParameter("cedula", cedula);
            return myQuery.getSingleResult();
        } catch (NoResultException e) {
            return null; // retornamos null porque no se encontro un objeto            
        }
    }

    @Override
    public void insertar(Paciente paciente) {
        this.entityManager.persist(paciente);
    }

    @Override
    public List<Paciente> seleccionarTodos() {
        TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class);
        return myQuery.getResultList();
    }

    // opcionales

    @Override
    public Paciente seleccionarPorId(Integer id) {
        return this.entityManager.find(Paciente.class, id);
    }

    @Override
    public void actualizar(Paciente paciente) {
        this.entityManager.merge(paciente);
    }

    @Override
    public void eliminarPorCedula(String cedula) {
        this.entityManager.remove(seleccionarPorCedula(cedula));
    }

}
