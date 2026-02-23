package io.github.LuizHenriqueMaronezi.libraryapi.controller;

import io.github.LuizHenriqueMaronezi.libraryapi.controller.dto.UsuarioDTO;
import io.github.LuizHenriqueMaronezi.libraryapi.controller.mappers.UsuarioMapper;
import io.github.LuizHenriqueMaronezi.libraryapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody UsuarioDTO dto){
        var usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }
}
