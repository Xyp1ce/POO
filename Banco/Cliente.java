public class Cliente{
  private int noCliente;
  private String nombre;
  private String direccion;
  private int indice;

  // relacion
  private Cuenta[] cuentas; // Un cliente puede tener multiples cuentas

  // constructores
  public Cliente(int noCliente, String nombre, String direccion){
    this.noCliente = noCliente;
    this.nombre = nombre;
    this.direccion = direccion;
    this.indice = 0;
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

  public void addCuenta(){
    cuentas[indice++] = Cuenta(long noCuenta, long clave, String fechaVencimiento, String tipo);
  }
}
