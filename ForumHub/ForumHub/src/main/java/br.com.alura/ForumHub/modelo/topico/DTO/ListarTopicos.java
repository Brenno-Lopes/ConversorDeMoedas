package br.com.alura.ForumHub.modelo.topico.DTO;

import br.com.alura.ForumHub.modelo.curso.EnumCursos;
import br.com.alura.ForumHub.modelo.topico.Topico;

public record ListarTopicos(Long id,
                            String titulo,
                            String mensagem,
                            java.text.@jakarta.validation.constraints.NotBlank DateFormat dataCriacao,
                            String Status,
                            String autor,
                            EnumCursos curso) {

    public ListarTopicos(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso());
    }

}
