import java.time.LocalDate;

public class TransferenciaPoli extends OperacionPoli {
    private long referencia;
    private String tipo;

    public TransferenciaPoli() { super(); }

    public TransferenciaPoli(long referencia) {
        super();
        this.referencia = referencia;
        tipo = "Transferencia";
    }

    public TransferenciaPoli(long referencia, float monto, LocalDate fecha, long folio) {
        super(monto, fecha, folio);
        tipo = "Transferencia";
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

    // No se va a utilizar pero se tiene que implementar
    @Override
    public void calculaComision() {}
}
