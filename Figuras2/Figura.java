public abstract class Figura {
  protected String color;
  private String patron;

  public Figura() {}

  public Figura(String color, String patron) {
    this.patron = patron;
    this.color = color;
  }

  public String getPatron() {
    return patron;
  }

  public void setColor(String color) {
    this.color = color;
  }
  
  // Metodo abstracto 
  abstract String dibuja();

  public String toString() {
    return "EL color es " + color + " y patron es " + patron;
  }
}
