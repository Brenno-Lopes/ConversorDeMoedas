package br.com.alura.ForumHub.modelo.topico;

import br.com.alura.ForumHub.modelo.curso.EnumCursos;
import br.com.alura.ForumHub.modelo.topico.DTO.AtualizarTopico;
import br.com.alura.ForumHub.modelo.topico.DTO.CriarTopico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DateFormat;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String Titulo;

    @NotBlank
    private String Mensagem;

    @NotBlank
    private DateFormat dataCriacao;

    @NotBlank
    private String status;

    @NotNull
    @Valid
    private String Autor;

    @Enumerated(EnumType.STRING)
    private EnumCursos Curso;

    public Topico(CriarTopico dados) {
        this.Titulo = dados.titulo();
        this.Mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.Autor = dados.autor();
        this.Curso = dados.curso();
    }

    public void atualizarInformacoes(AtualizarTopico dados) {
        if (dados.titulo() != null) {
            this.Titulo = dados.titulo();
        }

        if (dados.mensagem() != null) {
            this.Mensagem = dados.mensagem();
        }

        if (dados.status() != null) {
            this.status = dados.status();
        }
    }
}