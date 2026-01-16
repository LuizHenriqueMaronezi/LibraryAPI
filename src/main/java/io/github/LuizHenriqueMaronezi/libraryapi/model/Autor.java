package io.github.LuizHenriqueMaronezi.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor", schema = "public") // schema opcional se for public
@Getter
@Setter // Fazer os getters e setters
public class Autor {

    @Id
    @Column(name = "id") // o 'name' não é obrigatório se for o mesmo nome
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor") // Um autor para varios livros
    private List<Livro> livros;

    @Deprecated
    public Autor(){

    }

    public Autor(LocalDate dataNascimento, String nome, String nacionalidade) {
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
}
