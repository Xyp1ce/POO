public class Cuenta{

  // Atributos
  private long noCuenta;
  private float saldo;
  private long clave;
  private String fechaVencimiento;
  private String tipo;

  // Constructor
  public Cuenta(long noCuenta, long clave, String fechaVencimiento, String tipo){
    this.noCuenta = noCuenta;
    this.clave = clave;
    this.fechaVencimiento = fechaVencimiento;
    this.tipo = tipo;

    saldo = 0;
  }

  @Override
  public String toString(){
    return "\nCuenta " + noCuenta + "\n" + "\nSaldo: " + saldo + "\nCLABE: " + clave + "\nTipo: " + tipo + "\n";
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

  public void renovar(String fechaVencimiento){
    // La palabra clave "this" nos permite diferenciar el alcance de una variable
    // en caso que el nombre del atributo sea igual al del parametro.
    // En este caso "this" hace referencia a los atributos de la clase
    // (los que estan situados hasta arriba)
    this.fechaVencimiento = fechaVencimiento;
  }
  public float depositar(float deposito){
    if(deposito <= 0) {
      return 0;
    }
    return saldo+=deposito;
  }

  public float retirar(float retiro){
    if((saldo - retiro) < 0){
      return 0;
    } else{
      return saldo-=retiro;
    }
  }
}
