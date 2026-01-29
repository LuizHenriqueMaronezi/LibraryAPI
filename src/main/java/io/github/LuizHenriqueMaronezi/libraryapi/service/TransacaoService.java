package io.github.LuizHenriqueMaronezi.libraryapi.service;

import io.github.LuizHenriqueMaronezi.libraryapi.model.Autor;
import io.github.LuizHenriqueMaronezi.libraryapi.model.GeneroLivro;
import io.github.LuizHenriqueMaronezi.libraryapi.model.Livro;
import io.github.LuizHenriqueMaronezi.libraryapi.repository.AutorRepository;
import io.github.LuizHenriqueMaronezi.libraryapi.repository.LivroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransacaoService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LivroRepository livroRepository;


    @Transactional
    public void atualizacaoSemAtualizar(){
        var livro = livroRepository.findById(UUID.fromString(""))
                .orElse(null);
        livro.setDataPublicacao(LocalDate.of(2024,6,1));
    }

    @Transactional
    public void executar(){

        // Salva o autor
        Autor autor = new Autor();
        autor.setNome("Francisca");
        autor.setNacionalidade("Brasileira");
        autor.setDataNascimento(LocalDate.of(1951, 1, 31));

        autorRepository.save(autor);

        // Salva o livro
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Livro Francisca");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        livro.setAutor(autor);

        livroRepository.save(livro);

        if(autor.getNome().equals("José")){
            throw new RuntimeException("Rollback");
        }
    }
}
