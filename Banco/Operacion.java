import java.time.LocalDate;

public abstract class Operacion {
  protected float monto;
  private LocalDate fecha;
  private long folio;

  public Operacion(){ }

  public Operacion(float monto, LocalDate fecha, long folio) {
    this.monto = monto;
    this.fecha = fecha;
    this.folio = folio;
  }

  public float getMonto() {
    return monto;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public long getFolio() {
    return folio;
  }

  public abstract void calculaComision();

  @Override 
  public String toString() {
    String msg = "==MONTO==\n" 
                 + monto +
                 "\n==FECHA==\n"
                 + fecha +
                 "\n==FOLIO==\n"
                 + folio + "\n";
    return msg;
  }
}
