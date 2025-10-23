public class Sucursal{

  // Atributos
  private String direccion;
  private int noSucursal;

  // relacion 
  private Cliente[] clientes; 
  private Cuenta[] accounts;
  private int indice;
  private int indiceCuentas;

  // Constructor 
  public Sucursal(String direccion, int noSucursal){
    this.direccion = direccion;
    this.noSucursal = noSucursal;
    // cada sucursal podra tener hasta 10 clientes
    clientes = new Cliente[10];
    // Como cada cliente puede tener hasta 10 cuentas
    // entonces la sucursal puede tener hasta 100 cuentas
    accounts = new Cuenta[100];
    indice = 0;
    indiceCuentas = 0;
  }

  public String getDireccion(){
    return direccion;
  }
  
  public int getCantidad() {
    return indice;
  }

  // No hay sets, la direccion no se cambia ni el numero de sucursal

  public Cliente buscarCliente(String nombre){
    if(indice == 0){
      return null; // no hay clientes
    }
    for(int i = 0; clientes[i] != null; i++){
      if(clientes[i].getNombre().equals(nombre)){
        return clientes[i]; // encontro el cliente
      }
    }
    return null; // no encontro nada
  }

  public void addCliente(String nombre, String direccion) {
    clientes[indice++] = new Cliente((indice), nombre, direccion);
  }

  public void getClientes() {
    for(int i = 0; clientes[i] != null; i++) {
      System.out.println(clientes[i].toString() + "\n");
    }
  }

  public void addAccount(Cuenta account) {
    accounts[indiceCuentas++] = account;
  }

  public void watchAccounts() {
    for(int i = 0; i < indiceCuentas; i++) {
      System.out.println(accounts[i].toString() + "\n");
    }
  }
}
