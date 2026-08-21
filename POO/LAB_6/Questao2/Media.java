package LAB_6.Questao2;

public class Media {
    private float p1;
    private float p2;
    private float t1;
    private float t2;

    public Media(float p1, float p2, float t1, float t2) {
        this.p1 = p1;
        this.p2 = p2;
        this.t1 = t1;
        this.t2 = t2;
    }

    private float calcularMedia() {
        // Correção: Dividindo pelas 4 avaliações
        return (this.p1 + this.p2 + this.t1 + this.t2) / 3.0f;
    }

    public void statusAluno() {
        float media = calcularMedia();
        
        System.out.printf("Média final: %.1f\n", media); 

        if (media < 4.0f) {
            System.out.println("Status: O aluno foi reprovado.");
        } 
        // Correção: Usando && (E) e ajustando a lógica de <= 6
        else if (media >= 4.0f && media <= 6.0f) {
            System.out.println("Status: O aluno esta de verificacao suplementar.");
        } 
        else {
            System.out.println("Status: O aluno foi aprovado.");
        }
        System.out.println("----------------------------------------");
    }
}