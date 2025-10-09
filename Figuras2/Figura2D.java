public class Figura2D extends Figura { 

  protected float area;
  protected float perimetro;

  public Figuras2D() {
    super();
  }

  public Figura2D(float area, float perimetro) {
    super();
    this.area = area;
    this.perimetro = perimetro;
  }

  public Figura2D(float area, float perimetro, String color, String patron) {
    super(color, patron);
    this.area = area;
    this.perimetro = perimetro;
  }

  public float getArea() {
    return area;
  }

  public float getPerimetro() {
    return perimetro;
  }

  /*
   * Estos metodos estan vacios porque los hijos
   * de esta clase realizaran una sobreescritura
   * de estos metodos.
   * Simplemente estamos "avisando" que estos
   * metodos existiran
   */

  public void area() {}
  public void primetro() {}

  public String toString() {
    // Llamamos al toString del padre
    // por eso usamos super.
    String cadena = super.toString() + 
    "--- el area es " + area +
    " y su perimetro es " + perimetro;
    return cadena;
  }
}
