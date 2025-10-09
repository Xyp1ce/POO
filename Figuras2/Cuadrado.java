public class Cuadrado extends Figura2D {
  
  private float lado;

  // Default
  public Cuadrado() { super(); }

  // Solamente recibe los parametros del Cuadrado
  public Cuadrado(float lado) {
    super();
    this.lado = lado;
  }

  // Recibe los parametros del Cuadrado y de la clase Figura2D
  public Cuadrardo(float lado, float area, float perimetro) {
    super(area, perimetro);
    this.lado = lado;
  }

  // Recibe los parametros del Cuadrado, Figura2D y Figura
  public Cuadrado(float lado, float area, perimetro,, String color, String patron) {
    super(area, perimetro, color, patron);
    this.lado = lado;
  }

  // Getters y setters
  public float getLado() {
    return lado;
  }

  public void setLado(float lado) {
    this.lado = lado;
  }

  public void area() {
    area = lado * lado;
  }

  public void perimetro() {
    perimetro = lado * 4;
  }
}
