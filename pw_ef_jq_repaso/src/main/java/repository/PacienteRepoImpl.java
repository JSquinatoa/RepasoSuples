package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Paciente;

@ApplicationScoped
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Paciente seleccionarPorCedula(String cedula) {
        try {
            TypedQuery<Paciente> myQuery = this.entityManager
                    .createQuery("SELECT p FROM Paciente p WHERE p.cedula = :cedula", Paciente.class);
            myQuery.setParameter("cedula", cedula);
            return myQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insertar(Paciente paciente) {
        this.entityManager.persist(paciente);
    }

}
