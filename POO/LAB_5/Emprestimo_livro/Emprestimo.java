package LAB_5.Emprestimo_livro;

import java.util.ArrayList;

public class Emprestimo {
    private ArrayList<Livro> livros;
    private ArrayList<Pessoa> pessoas;  

    public Emprestimo() {
        this.livros = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public void adicionarLivro(Livro novoLivro) {
        livros.add(novoLivro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public void adicionarPessoa(Pessoa novaPessoa) {
        pessoas.add(novaPessoa);
    }

    public void removerPessoa(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public void listagemLivros(){
        for (Livro i : livros) {
            System.out.println("Titulo: " + i.getTitulo());
            System.out.println("Autor: " + i.getAutor());
            System.out.println("Genero: " + i.getGenero());
            System.out.println("Ano de Publicação: " + i.getAnoPublicacao());
            System.out.println("---------");
        }
    }

    public void listagemPessoas(){
        for (Pessoa i : pessoas) {
            System.out.println("Nome: " + i.getNome());
            System.out.println("CPF: " + i.getCpf());
            System.out.println("Telefone: " + i.getTelefone());
            System.out.println("---------");
        }
    }
    
    public void emprestarLivro(Livro livro, Pessoa pessoa){
        if (livros.contains(livro) && (pessoas.contains(pessoa))){
            removerLivro(livro);
            System.out.println("O livro " + livro.getTitulo() + " foi emprestado para a pessoa " + pessoa.getNome() + ".");
            System.out.println("---------"); 
        }
        else{
            System.out.println("Nao foi possivel realizar o emprestimo");
            System.out.println("---------");
        }
    }    
    
    public void devolverLivro(Livro livro, Pessoa pessoa){
        if (!livros.contains(livro) && (pessoas.contains(pessoa))){
            adicionarLivro(livro);
            System.out.println("O livro " + livro.getTitulo() + " foi devolvido pela pessoa " + pessoa.getNome() + ".");
            System.out.println("---------");
        }
        else{
            System.out.println("Nao foi possivel realizar a devolucao");
            System.out.println("---------");
        }
    }

}
