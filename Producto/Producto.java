public class Producto{
  // Atributos
  private String nombre;
  private String tipo;
  private float precio;
  private int stock;
  // Constructos

  public Producto(String nombre, String tipo, float precio){
    this.nombre = nombre;
    this.tipo = tipo;
    this.precio = precio;
    stock = 0;
  }

  // Metodos
  public void setPrecio(float precio){
    this.precio = precio;
  }
  public float getPrecio(){
    return precio;
  }

  /*No hay setStock porque el stock se controla
   * desde las funciones de abastacer y retirar */ 

  public int getStock(){
    return stock;
  }
  public void setTipo(String tipo){
    this.tipo = tipo;
  }
  public String getTipo(){
    return tipo;
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getNombre(){
    return nombre;
  }

  public void abastecer(int cantidad){
    stock+=cantidad;
  }

  /* retirar regresa un bool como bandera
   * para la clase main y saber si se pudo
   * retirar o no */ 

  public boolean retirar(int cantidad){
    if(stock-cantidad < 0){
      // No hay stock suficiente
      return false;
    } else {
      stock-=cantidad;
      return true;
    }
  }
}
