package br.com.alura.ForumHub.modelo.usuario.AutenticadorUsuario;

import br.com.alura.ForumHub.modelo.usuario.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository <Autor, Long> {

    UserDetails findByLogin(String username);
}
