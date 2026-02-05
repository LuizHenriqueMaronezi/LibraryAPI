package io.github.LuizHenriqueMaronezi.libraryapi.controller.mappers;

import io.github.LuizHenriqueMaronezi.libraryapi.controller.dto.AutorDTO;
import io.github.LuizHenriqueMaronezi.libraryapi.model.Autor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
