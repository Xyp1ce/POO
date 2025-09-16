public class Cliente{
  private int noCliente;
  private String nombre;
  private String direccion;

  // relacion
  private Cuenta[] cuentas; // Un cliente puede tener multiples cuentas

  // constructores
  public Cliente(int noCliente, String nombre, String direccion){
    this.noCliente = noCliente;
    this.nombre = nombre;
    this.direccion = direccion;
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

  }

}
