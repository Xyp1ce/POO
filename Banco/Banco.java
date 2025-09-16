public class Banco{
  private String nombre;
  private int indice;

  Sucursal[] sucursales;

  public Banco(String nombre, int indice){
    this.nombre = nombre;
    indice = 0;
  }

  public String getNombre(){
    return nombre;
  }
}
