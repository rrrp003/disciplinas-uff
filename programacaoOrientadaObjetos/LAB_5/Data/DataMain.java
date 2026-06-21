package LAB_5.Data;

public class DataMain {
    public static void main(String[] args) {
        
        // Teste 1: Data perfeitamente normal
        Data d1 = new Data(15, 8, 2023);
        System.out.print("Data 1: ");
        d1.imprime(""); // Usa o padrão "/"
        System.out.println("------");

        // Teste 2: Ano Bissexto válido (29 de fevereiro de 2024)
        Data d2 = new Data(29, 2, 2024);
        System.out.print("Data 2: ");
        d2.imprime("-"); // Usa o separador do usuário "-"
        System.out.println("É bissexto? " + d2.anoBissexto());
        System.out.println("------");

        // Teste 3: Data Inválida (29 de fevereiro de 2023 - não é bissexto)
        Data d3 = new Data(29, 2, 2023);
        System.out.print("Data 3: ");
        d3.imprime(null); 
        System.out.println("------");
        
        // Teste 4: Data Inválida (Mês 13)
        Data d4 = new Data(10, 13, 2022);
        System.out.print("Data 4: ");
        d4.imprime(".");
        System.out.println("------");
    }
}