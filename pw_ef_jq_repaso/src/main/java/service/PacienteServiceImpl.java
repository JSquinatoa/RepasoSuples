package service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.IPacienteRepo;
import repository.model.Paciente;

@ApplicationScoped
public class PacienteServiceImpl implements IPacienteService {

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

    @Override
    public List<Paciente> buscarTodos() {
        return this.iPacienteRepo.seleccionarTodos();
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return this.iPacienteRepo.seleccionarPorId(id);
    }

    @Override
    public void actualizar(Paciente paciente) {
        this.iPacienteRepo.actualizar(paciente);
    }

    @Override
    public void borrarPorCedula(String cedula) {
        this.iPacienteRepo.eliminarPorCedula(cedula);
    }

}
