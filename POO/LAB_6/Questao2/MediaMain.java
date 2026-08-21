package LAB_6.Questao2;

public class MediaMain {
    public static void main(String[] args) {
    
        System.out.println("Aluno 1:");
        Media alunoAprovado = new Media(8.5f, 7.0f, 9.0f, 8.0f);
        alunoAprovado.statusAluno();

        System.out.println("Aluno 2:");
        Media alunoVS = new Media(5.0f, 4.5f, 2.0f, 5.5f);
        alunoVS.statusAluno();

        System.out.println("Aluno 3:");
        Media alunoReprovado = new Media(2.0f, 3.5f, 1.0f, 4.0f);
        alunoReprovado.statusAluno();
    }
}