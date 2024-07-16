package br.com.alura.ForumHub.modelo.topico.DTO;

import jakarta.validation.constraints.NotNull;

public record AtualizarTopico(@NotNull Long id,
                              String titulo,
                              String mensagem,
                              String status) {
}