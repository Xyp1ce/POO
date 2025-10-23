public class Prestamo implements Intereses {
  private float cantidad;
  private float saldo;

  private String fecha;

  public Prestamo(float cantidad, String fecha) {
    this.cantidad = cantidad;
    this.fecha = fecha;
    saldo = cantidad;
  }

  public float getCantidad() {
    return cantidad;
  }

  public String getFecha() {
    return fecha;
  }

  @Override
  // implementa metoodo de la interface
  public float calculaInteres() {
    return cantidad*0.30f;
  }

  // afecta al saldo
  public void calculaIntereses() {
    saldo+=calculaInteres();
  }
}
