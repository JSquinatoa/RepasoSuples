package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Cita;

@ApplicationScoped
@Transactional
public class CitaRepoImpl implements ICitaRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cita> seleccionarTodos() {
        TypedQuery<Cita> myQuery = this.entityManager.createQuery("SELECT c FROM Cita c", Cita.class);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Cita cita) {
        this.entityManager.persist(cita);
    }

}
