package io.github.LuizHenriqueMaronezi.libraryapi.repository;

import io.github.LuizHenriqueMaronezi.libraryapi.model.Autor;
import io.github.LuizHenriqueMaronezi.libraryapi.model.GeneroLivro;
import io.github.LuizHenriqueMaronezi.libraryapi.model.Livro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public interface LivroRepository extends JpaRepository<Livro,UUID> {

    // JPA Query Methods

    // Select * from livro where autor = ?
    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTitulo(String titulo);

    // Select * from livro where titulo = ? and preco = ?
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    // Select * from livro where titulo = ? or isbn = ? order by titulo
    List<Livro> findByTituloOrIsbnOrderByTitulo(String titulo, BigDecimal preco);

    // Select * from livro where data_publicacao between ? and ?
    List<Livro> findByDataPublicacaoBetween(LocalDate inicio, LocalDate fim);


    // JPQL -> referencia as entidades e suas propriedades

    @Query(" select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloEPreco();

    @Query(" select a from Livro as l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    // Para fazer querys maiores, com mais linhas
    @Query("""
            select l.genero
            from Livro l
            join l.autor a
            where a.nacionalidade = 'Brasileiro'
            order by l.genero
            """)
    List<String> listarGenerosAutoresBrasileiros();

    // Named Parameters
    @Query(" select l from Livro l where l.genero = :genero order by :paramOrdernacao")
    List<Livro> findByGeneroNamedParam(
            @Param("genero") GeneroLivro generoLivro,
            @Param("paramOrdenacao") String nomePropriedade);

    // Positional Parameters
    @Query(" select l from Livro l where l.genero = ?1 order by ?2")
    List<Livro> findByGeneroPositionalParam(
            @Param("genero") GeneroLivro generoLivro,
            @Param("paramOrdenacao") String nomePropriedade);

    @Modifying
    @Transactional
    @Query(" delete from Livro where genero = ?1 ")
    void deleteByGenero(GeneroLivro generoLivro);

    @Modifying
    @Transactional
    @Query(" update Livro set dataPublicacao = ?1 ")
    void updateDataPublicacao(LocalDate novaData);

    boolean existsByAutor(Autor autor);
}
