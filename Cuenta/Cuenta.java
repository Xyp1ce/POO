/* 
 * Ramon Manriquez 
 * 01/09/2025
 * Cuenta de banco 
 */ 

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

  // Metodos
  public void getSaldo(){
    System.out.println("El saldo es: " + saldo + "$");
  }

  public void getFechaVencimiento(){
    System.out.println("La fecha de vencimiento es: " + fechaVencimiento);
  }

  public void renovar(String fechaVencimiento){
    // La palabra clave "this" nos permite diferenciar el alcance de una variable
    // en caso que el nombre del atributo sea igual al del parametro.
    // En este caso "this" hace referencia a los atributos de la clase
    // (los que estan situados hasta arriba)
    this.fechaVencimiento = fechaVencimiento;
  }
  public float depositar(float deposito){
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
