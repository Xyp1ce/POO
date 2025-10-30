import java.time.LocalDate;

public class CuentaPoli implements Intereses{

  // Atributos
  private long noCuenta;
  private float saldo;
  private long clave;
  private String fechaVencimiento;
  private String tipo;
  private ClientePoli client;

  // Los metodos static se diferencian en que:
  // el valor se cambia para todos los objetos que existan de esta clase 
  // aunque se tengan 2 objetos o mas, el valor, en este caso de interes, 
  // interes sera el mismo para todas las clases, si se modifica en uno 
  // se modifica en todos
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
    // La palabra clave "this" nos permite diferenciar el alcance de una variable
    // en caso que el nombre del atributo sea igual al del parametro.
    // En este caso "this" hace referencia a los atributos de la clase
    // (los que estan situados hasta arriba)
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

  public static float getInteres() {
    return interes;
  }

  /*
   * OJO: no podemos poner en el parametro el mismo nombre al
   * atributo interes que es static. Static no es un atributo del objeto
   * es un atributo de la clase
   * Intentar hacer:
   * public static void setInteres(float interes) {
   * this.insteres = interes;
   * }
   * Resultaria en un error por lo anteriormente comentado
   */ 
  
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
}
