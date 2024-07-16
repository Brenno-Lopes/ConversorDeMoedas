package br.com.alura.ForumHub.controller;

import br.com.alura.ForumHub.modelo.topico.DTO.AtualizarTopico;
import br.com.alura.ForumHub.modelo.topico.DTO.ListarTopicos;
import br.com.alura.ForumHub.modelo.topico.Topico;
import br.com.alura.ForumHub.modelo.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import br.com.alura.ForumHub.modelo.topico.DTO.CriarTopico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {


    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity Cadastrar(@RequestBody CriarTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new ListarTopicos(topico));
    }


    @GetMapping
    @Transactional
    public ResponseEntity<List<ListarTopicos>> listar() {
        List<Topico> topicos = repository.findAllByOrderByDataCriacaoDesc();
        var retornoListar = topicos.stream()
                .map(ListarTopicos::new)
                .toList();

        return ResponseEntity.ok(retornoListar);
    }

    @GetMapping("/{id}")
    public Optional<Topico> buscar(@PathVariable Long id){
        var dadosTopico = repository.findById(id);
        return dadosTopico;
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new ListarTopicos(topico));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizarTopico dados){
        var alterarTopico = repository.getReferenceById(dados.id());
        alterarTopico.atualizarInformacoes(dados);

        return ResponseEntity.ok(new ListarTopicos(alterarTopico));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        repository.deleteById(id);


        return ResponseEntity.noContent().build();
    }


}
