package br.com.alura.screenmatch.model.autor;

import br.com.alura.screenmatch.model.livro.Livro;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")

public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    @ManyToMany

    @JoinTable(
            name = "autores_dos_livros",
            joinColumns = @JoinColumn(name = "id_livros"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )

    List<Livro> livros;

    public Autor(DadosAutor autor) {
        this.nome = autor.nome();
        this.anoNascimento = autor.dataNascimento();
        this.anoFalecimento = autor.dataMorte();
    }

    public Autor(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento +
                "}\n";
    }
}
