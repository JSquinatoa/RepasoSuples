package service.mapper;

import repository.model.Materia;
import service.to.MateriaTo;

public class MateriaMapper {

    public static MateriaTo toTo(Materia materia) {
        if (materia == null) {
            return null;
        }
        MateriaTo mTo = new MateriaTo();
        mTo.setId(materia.getId());
        mTo.setNombre(materia.getNombre());
        mTo.setCodigo(materia.getCodigo());
        mTo.setNumeroCreditos(materia.getNumeroCreditos());
        mTo.setProfesor(materia.getProfesor());

        return mTo;
    }

    public static Materia toEntity(MateriaTo materiaTo) {
        Materia m = new Materia();
        m.setId(materiaTo.getId());
        m.setNombre(materiaTo.getNombre());
        m.setCodigo(materiaTo.getCodigo());
        m.setNumeroCreditos(materiaTo.getNumeroCreditos());
        m.setProfesor(materiaTo.getProfesor());
        return m;
    }

}
