package repository.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {


    @Id
    @Column(name = "doct_cedula")
    private String cedula;
    @Column(name = "doct_nombre")
    private String nombre;
    @Column(name = "doct_apellido")
    private String apellido;
    @Column(name = "doct_contraseña")
    private String password;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Paciente> pacientes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String appelido) {
        this.apellido = appelido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String constraseña) {
        this.password = constraseña;
    }

}
