package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IPacienteRepo;
import repository.model.Paciente;

@ApplicationScoped
public class PacienteServiceImpl implements IPacienteService{

    @Inject
    private IPacienteRepo iPacienteRepo;

    @Override
    public Paciente buscarPorCedula(String cedula) {
        return this.iPacienteRepo.seleccionarPorCedula(cedula);
    }

    @Override
    public void guardar(Paciente paciente) {
        this.iPacienteRepo.insertar(paciente);
    }

}
