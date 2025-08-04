package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.ICitaRepo;
import repository.IDoctorRepo;
import repository.IPacienteRepo;
import repository.model.Cita;
import repository.model.Doctor;
import repository.model.Paciente;

@ApplicationScoped
public class CitaServiceImpl implements ICitaService {

    @Inject
    private ICitaRepo iCitaRepo;

    @Inject
    private IPacienteRepo iPacienteRepo;

    @Inject
    private IDoctorRepo iDoctorRepo;

    @Override
    public List<Cita> buscarTodos() {
        return this.iCitaRepo.seleccionarTodos();
    }

    @Override
    public void guardar(Cita cita) {
        Paciente p = this.iPacienteRepo.seleccionarPorCedula(cita.getPaciente().getCedula());
        cita.setPaciente(p);

        Doctor d = this.iDoctorRepo.seleccionarPorCedula(cita.getDoctor().getCedula());
        cita.setDoctor(d);

        this.iCitaRepo.insertar(cita);
    }

}
