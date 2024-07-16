package br.com.alura.ForumHub.modelo.topico.DTO;

import br.com.alura.ForumHub.modelo.curso.EnumCursos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.text.DateFormat;

public record CriarTopico(@NotBlank
                          String titulo,

                          @NotBlank
                          String mensagem,

                          @NotBlank
                          DateFormat dataCriacao,

                          @NotBlank
                          String status,

                          @NotBlank
                          String autor,

                          @NotNull
                          @Valid
                          EnumCursos curso) {
}