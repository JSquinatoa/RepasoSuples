package repository.model.dto;

public class MateriaDTO {

    private Integer id;
    private String nombre;
    private String codigo;
    private Integer numeroCreditos;

    public MateriaDTO() {
        super();
    }

    public MateriaDTO(Integer id, String nombre, String codigo, Integer numeroCreditos) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }   

}
