import java.time.LocalDate;

public class MovimientoPoli extends OperacionPoli {
    private String tipo;
    private long referencia;
    private float comision;

    public MovimientoPoli() {
        super();
        tipo = "";
        comision = 0;
    }

    public MovimientoPoli(String tipo, long referencia) {
        super();
        this.tipo = tipo;
        this.referencia = referencia;
    }

    public MovimientoPoli(String tipo, long referencia, float monto, LocalDate fecha, long folio) {
        super(monto, fecha, folio);
        this.tipo = tipo;
        this.referencia = referencia;
    }

    public String getTipo() {
        return tipo;
    }

    public long getReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        String msg = super.toString() +
                "==TIPO==\n"
                + tipo +
                "\n==REFERENCIA==\n"
                + referencia + "\n";
        return msg;
    }

    public void calcularComision() {
        if(tipo.equals("Deposito"))
            comision = monto * 0.01f;
        else
            comision = monto * 0.02f;
    }

    @Override
    public void calculaComision(){}
}
