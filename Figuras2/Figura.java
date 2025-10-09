public class Figura {
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
}
