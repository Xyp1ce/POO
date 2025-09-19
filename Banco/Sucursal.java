public class Sucursal{
  private String direccion;
  private int noSucursal;

  // relacion 
  private Cliente[] clientes; 
  private int indice;

  // Constructor 
  public Sucursal(String direccion, int noSucursal){
    this.direccion = direccion;
    this.noSucursal = noSucursal;
    // cada sucursal podra tener hasta 10 clientes
    clientes = new Cliente[10];
    indice = 0;
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
    clientes[indice++] = new Cliente((indice+1), nombre, direccion);
  }

  public void getClientes() {
    for(int i = 0; clientes[i] != null; i++) {
      System.out.println(clientes[i].toString());
    }
  }
}
