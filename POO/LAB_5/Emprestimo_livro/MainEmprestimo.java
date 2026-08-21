package LAB_5.Emprestimo_livro;


public class MainEmprestimo {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa("Rafael", "14521892891", "212121212");
        Pessoa p2 = new Pessoa("RR ", "1223232212", "121212121");
       
        Livro l1 = new Livro ("Cancao de Gelo e Fogo" , "GG Martin", "fantasia", 2007);
        Livro l2 = new Livro ("Cavaleiro de Sete Reinos" , "GG Martin", "fantasia", 2002);
        Livro l3 = new Livro ("Fogo e Sangue" , "GG Martin", "fantasia", 2001);
        Livro l4 = new Livro ("Banquete de Corvos" , "GG Martin", "fantasia", 2010);
        Livro l5 = new Livro ("Tempestade de Ecos" , "GG Martin", "fantasia", 2010);

        Emprestimo emp = new Emprestimo();
        emp.adicionarPessoa(p1);
        emp.adicionarPessoa(p2);

        emp.adicionarLivro(l1);
        emp.adicionarLivro(l2);
        emp.adicionarLivro(l3);
        emp.adicionarLivro(l4);
        emp.adicionarLivro(l5);

        //Teste listagens
        System.out.println("Teste listagem:");
        emp.listagemLivros();
        emp.listagemPessoas();
        
        // emprestar livros
        emp.emprestarLivro(l5, p2);
        emp.emprestarLivro(l2, p1);
        
        //Teste listagens
        System.out.println("Teste listagem:");
        emp.listagemLivros();
    
        

    }

}
