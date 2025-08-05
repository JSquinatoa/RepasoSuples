package service.to;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import controller.MateriaController;
import jakarta.ws.rs.core.UriInfo;

public class MateriaDTOTo {

    private Integer id;
    private String nombre;
    private String codigo;
    private Integer numeroCreditos;
    private Map<String, String> _links = new HashMap<>();

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

    public Map<String, String> get_links() {
        return _links;
    }

    public void set_links(Map<String, String> _links) {
        this._links = _links;
    }

    public void buidlURI(UriInfo uriInfo) {
        URI materia = uriInfo.getBaseUriBuilder().path(MateriaController.class)
                .path(MateriaController.class, "obtenerPorId").build(id);
        _links.put("materiaCompleta", materia.toString());
    }

}
