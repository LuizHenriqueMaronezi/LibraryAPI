package io.github.LuizHenriqueMaronezi.libraryapi.controller.mappers;

import io.github.LuizHenriqueMaronezi.libraryapi.controller.dto.UsuarioDTO;
import io.github.LuizHenriqueMaronezi.libraryapi.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
