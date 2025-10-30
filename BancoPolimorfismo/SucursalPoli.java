public class SucursalPoli {

  // Atributos
  private String direccion;
  private int noSucursal;

  // relacion 
  private ClientePoli[] clientes;
  private CuentaPoli[] accounts;
  private int indice;
  private int indiceCuentas;

  // Constructor 
  public SucursalPoli(String direccion, int noSucursal){
    this.direccion = direccion;
    this.noSucursal = noSucursal;
    // cada sucursal podra tener hasta 10 clientes
    clientes = new ClientePoli[10];
    // Como cada cliente puede tener hasta 10 cuentas
    // entonces la sucursal puede tener hasta 100 cuentas
    accounts = new CuentaPoli[100];
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

  public ClientePoli buscarCliente(String nombre){
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
    clientes[indice++] = new ClientePoli((indice), nombre, direccion);
  }

  public void getClientes() {
    for(int i = 0; clientes[i] != null; i++) {
      System.out.println(clientes[i].toString() + "\n");
    }
  }

  public void addAccount(CuentaPoli account) {
    accounts[indiceCuentas++] = account;
  }

  public void watchAccounts() {
    for(int i = 0; i < indiceCuentas; i++) {
      System.out.println(accounts[i].toString() + "\n");
    }
  }
}
