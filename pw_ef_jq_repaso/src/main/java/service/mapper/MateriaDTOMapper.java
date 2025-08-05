package service.mapper;

import repository.model.dto.MateriaDTO;
import service.to.MateriaDTOTo;

public class MateriaDTOMapper {

    public static MateriaDTOTo toTo(MateriaDTO materiaDTO) {
        if (materiaDTO == null) {
            return null;
        }
        MateriaDTOTo mDTOTo = new MateriaDTOTo();
        mDTOTo.setId(materiaDTO.getId());
        mDTOTo.setNombre(materiaDTO.getNombre());
        mDTOTo.setCodigo(materiaDTO.getCodigo());
        mDTOTo.setNumeroCreditos(materiaDTO.getNumeroCreditos());

        return mDTOTo;
    }

}
