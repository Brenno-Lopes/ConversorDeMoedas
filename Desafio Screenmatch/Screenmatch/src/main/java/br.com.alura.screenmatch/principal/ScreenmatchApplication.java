package br.com.alura.screenmatch.principal;
import br.com.alura.screenmatch.modelBanco.EntidadeLivro;
import br.com.alura.screenmatch.modelBanco.EntidadeAutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.alura.screenmatch.model.livro","br.com.alura.screenmatch.model.autor"})
@EnableJpaRepositories(basePackages = "br.com.alura.screenmatch.modelBanco")
public class ScreenmatchApplication implements CommandLineRunner {

	@Autowired
	private EntidadeLivro repositorioLivro;
	@Autowired
	private EntidadeAutor repositorioAutor;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var menuPrincipal = new MenuPrincipal(repositorioLivro, repositorioAutor);
		menuPrincipal.exibeMenu();
	}
}