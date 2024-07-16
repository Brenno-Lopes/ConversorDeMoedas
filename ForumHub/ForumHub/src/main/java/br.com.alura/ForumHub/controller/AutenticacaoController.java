package br.com.alura.ForumHub.controller;


import br.com.alura.ForumHub.infra.security.DTO.DadosTokenJWT;
import br.com.alura.ForumHub.infra.security.TokenService;
import br.com.alura.ForumHub.modelo.usuario.AutenticadorUsuario.Usuario;
import br.com.alura.ForumHub.modelo.usuario.DTO.DadosAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        var autenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autentication = manager.authenticate(autenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) autentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));

    }
}
