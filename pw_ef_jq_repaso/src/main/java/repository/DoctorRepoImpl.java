package repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import repository.model.Doctor;

@ApplicationScoped
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Doctor seleccionarPorCedula(String cedula) {
        try {
            TypedQuery<Doctor> myQuery = this.entityManager
                    .createQuery("SELECT d FROM Doctor d WHERE d.cedula = :cedula", Doctor.class);
            myQuery.setParameter("cedula", cedula);
            return myQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void insertar(Doctor doctor) {
        this.entityManager.persist(doctor);
    }

}
