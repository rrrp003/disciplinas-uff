package LAB_6.Questao4;

public class Circulo {
    private float x;
    private float y;
    private float raio;

    public Circulo(float x, float y, float raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public float getX() { return x; }
    public void setX(float x) { this.x = x; }

    public float getY() { return y; }
    public void setY(float y) { this.y = y; }

    public float getRaio() { return raio; }
    public void setRaio(float raio) { this.raio = raio; }

    public void desenhar() {
        System.out.println("Desenhando Círculo...");
        System.out.printf("Centro: (%.1f, %.1f) | Raio: %.1f\n", this.x, this.y, this.raio);
        System.out.println("---------------------------------");
    }

    public void mover(float novoX, float novoY) {
        this.x = novoX;
        this.y = novoY;
        System.out.println("-> Círculo movido para as coordenadas (" + this.x + ", " + this.y + ")");
    }

    public void redimensionar(float multiplicador) {
        this.raio *= multiplicador; 
        System.out.println("-> Círculo redimensionado. Novo raio: " + this.raio);
    }

    public void dividir() {
        
        System.out.println("-> Dividindo o círculo em duas partes menores...");
        this.raio /= 2.0f;
        System.out.println("   Novo raio após divisão: " + this.raio);
    }
}