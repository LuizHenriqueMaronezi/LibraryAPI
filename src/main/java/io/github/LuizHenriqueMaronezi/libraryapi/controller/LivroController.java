package io.github.LuizHenriqueMaronezi.libraryapi.controller;

import io.github.LuizHenriqueMaronezi.libraryapi.controller.dto.CadastroLivroDTO;
import io.github.LuizHenriqueMaronezi.libraryapi.controller.dto.ErroResposta;
import io.github.LuizHenriqueMaronezi.libraryapi.controller.mappers.LivroMapper;
import io.github.LuizHenriqueMaronezi.libraryapi.exceptions.RegistroDuplicadoException;
import io.github.LuizHenriqueMaronezi.libraryapi.model.Livro;
import io.github.LuizHenriqueMaronezi.libraryapi.service.LivroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDTO dto){
        try{
            Livro livro = mapper.toEntity(dto);
            service.salvar(livro);
            // Para ainda fazer:
            // criar url para acesso dos dados do livro
            // retornar a resposta com header location
            return ResponseEntity.ok(dto);
        }catch(RegistroDuplicadoException e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}
