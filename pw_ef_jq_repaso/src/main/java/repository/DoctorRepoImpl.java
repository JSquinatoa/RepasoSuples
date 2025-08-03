package repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
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
    public Doctor seleccionarPorId(String cedula) {
        return this.entityManager.find(Doctor.class, cedula);
    }

    @Override
    public List<Doctor> seleccionarTodos() {
        TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d", Doctor.class);
        return myQuery.getResultList();
    }

    @Override
    public void insertar(Doctor doctor) {
        this.entityManager.persist(doctor);
    }

    @Override
    public void actualizar(Doctor doctor) {
        this.entityManager.merge(doctor);
    }

    @Override
    public void eliminarPorId(String cedula) {
        this.entityManager.remove(seleccionarPorId(cedula));
    }

}
