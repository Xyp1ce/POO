public class Sucursal{
  private String direccion;
  private int noSucursal;

  // relacion 
  private Cliente[] clientes;
  private int indice;

  // Constructor 
  public Sucursal(Stirng direccion, int noSucursal){
    this.direccion = direccion;
    this.noSucursal = noSucursal;
  }

  public String getDireccion(){
    return direccion;
  }
  
  // No hay sets, la direccion no se cambia ni el numero de sucursal

  public Cliente buscarCliente(){
    if(indice == 0){
    }
    for(int i = 0; clientes[i] != null; i++){

    }
  }
}
