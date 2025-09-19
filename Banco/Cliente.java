public class Cliente{
  private int noCliente;
  private String nombre;
  private String direccion;
  private int indice;
  private Cuenta[] cuentas;

  // constructores
  public Cliente(int noCliente, String nombre, String direccion){
    this.noCliente = noCliente;
    this.nombre = nombre;
    this.direccion = direccion;
    this.indice = 0;
    // relacion
    cuentas = new Cuenta[10]; 
    // Un cliente puede tener multiples cuentas
  }

  @Override
  public String toString() {
    return "Nombre: " + nombre + "\nDireccion: " + direccion + "\nNo. Cliente " + noCliente;
  }
 
  // get/sets
  public int getNoCliente(){
    return noCliente;
  }

  public String getNombre(){
    return nombre;
  }

  public String getDireccion(){
    return direccion;
  }

  public void getDireccion(String direccion){
    this.direccion = direccion;
  }

  public void addCuenta(long noCuenta, long clave, String fechaVencimiento, String tipo){
    cuentas[indice++] = new Cuenta(noCuenta, clave, fechaVencimiento, tipo);
  }
}
