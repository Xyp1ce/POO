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

  public Producto(String nombre, String tipo, float precio, int stock){
    this.nombre = nombre;
    this.tipo = tipo;
    this.precio = precio;
    this.stock = stock;
  }

  // toString
  @Override
  public String toString(){
    return "Nombre: " + nombre + "\nTipo: " + tipo + "\nPrecio: " + precio + "$\nStock: " + stock;
  }


  // Metodos
  public void setPrecio(float precio){
    this.precio = precio;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  /*No hay setStock porque el stock se controla
   * desde las funciones de abastacer y retirar */ 
  
  public float getPrecio(){
    return precio;
  }

  public int getStock(){
    return stock;
  }

  public String getTipo(){
    return tipo;
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
    if(stock - cantidad < 0){
      // No hay stock suficiente
      return false;
    } else {
      stock-=cantidad;
      return true;
    }
  }
}
