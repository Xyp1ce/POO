import java.time.LocalDate;

public class CuentaPoli implements Intereses{

    // Atributos
    private long noCuenta;
    private float saldo;
    private long clave;
    private String fechaVencimiento;
    private String tipo;
    private ClientePoli client;

    private static float interes;

    private OperacionPoli[] operaciones;
    private int cantOperaciones;

    // Constructor
    public CuentaPoli(long noCuenta, long clave, String fechaVencimiento, String tipo){
        this.noCuenta = noCuenta;
        this.clave = clave;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;

        operaciones = new OperacionPoli[10];
        cantOperaciones = 0;
        saldo = 0;
    }

    public CuentaPoli(long noCuenta, long clave, String fechaVencimiento, String tipo, float saldo) {
        this.noCuenta = noCuenta;
        this.clave = clave;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
        this.saldo = saldo;

        operaciones = new MovimientoPoli[10];
        cantOperaciones = 0;
    }

    @Override
    public String toString(){
        return "\nCliente " + client.getNombre() +
                "\n\nCuenta " + noCuenta +
                "\nSaldo: " + saldo +
                "\nCLABE: " + clave +
                "\nTipo: " + tipo +
                "\nInteres: " + interes;
    }

    // Metodos
    public long getNoCuenta(){
        return noCuenta;
    }

    public float getSaldo(){
        return saldo;
    }

    public long getClave(){
        return clave;
    }

    public String getFechaVencimiento(){
        return fechaVencimiento;
    }

    public String getTipo(){
        return tipo;
    }

    public void setClient(ClientePoli client) {
        this.client = client;
    }

    public void renovar(String fechaVencimiento){
        this.fechaVencimiento = fechaVencimiento;
    }
    public float depositar(float deposito, String tipo, long referencia, float monto, LocalDate fecha, long folio){
        if(deposito <= 0) {
            return 0;
        }
        OperacionPoli newMovimiento = new MovimientoPoli(tipo, referencia, monto, fecha, folio);
        operaciones[cantOperaciones++] = newMovimiento;
        return saldo+=deposito;
    }

    public float retirar(float retiro, String tipo, long referencia, float monto, LocalDate fecha, long folio){
        if((saldo - retiro) < 0){
            return 0;
        } else{
            OperacionPoli newMovimiento = new MovimientoPoli(tipo, referencia, monto, fecha, folio);
            operaciones[cantOperaciones++] = newMovimiento;
            return saldo-=retiro;
        }
    }

    // Metodo para crear el objeto Operacion y agregarlo a la lista de operaciones
    public float transferencia(long referencia, float monto, LocalDate fecha, long folio) {
        if((saldo - monto) < 0) {
            return 0; // No es posible
        } else {
            OperacionPoli newTransferencia = new TransferenciaPoli(referencia, monto, fecha, folio);
            operaciones[cantOperaciones++] = newTransferencia;
            // Actualizamos el saldo de la cuenta original
            return saldo-=monto;
        }
    }

    // Metodo para actualizar el saldo de la cuenta destino de una transferencia
    public void recibirTransferencia(float monto) {
        saldo += monto;
    }

    public static float getInteres() {
        return interes;
    }

    public static void setInteres(float inte) {
        interes = inte;
    }

    public void calcularIntereses() {
        saldo+=calculaInteres();
    }

    @Override
    public float calculaInteres(){
        return saldo*interes/100;
    }

    public String getMovimientos() {
        String msg = "";
        for(int i = 0; i < cantOperaciones; i++) {
            msg = msg + operaciones[i].toString();
        }
        return msg;
    }

    // Método para solicitar un préstamo
    public float solicitarPrestamo(float cantidad, LocalDate fecha, long folio) {
        if (cantidad <= 0) {
            return 0;
        }
        // Crear un nuevo préstamo
        Prestamo prestamo = new Prestamo(cantidad, fecha.toString());
        // Calcular los intereses del préstamo
        prestamo.calculaIntereses();
        // Registrar la operación
        OperacionPoli newOperacion = new MovimientoPoli("Prestamo", folio, cantidad, fecha, folio);
        operaciones[cantOperaciones++] = newOperacion;
        // Actualizar el saldo con el préstamo más los intereses
        saldo += cantidad;
        return prestamo.calculaInteres();
    }
}
