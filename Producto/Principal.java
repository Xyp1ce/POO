import java.util.Scanner;

public class Principal{

  private Producto[] inventario;
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args){
    Principal p = new Principal();
    p.menu();
  }

  public void menu(){
    inventario = new Producto[10];
    int buscarIndice;
    int indice = 0;
    int opc = 0;

    do{
      System.out.println("== ALMACEN ==");
      System.out.println("[1] Crear producto    [5] Ajustar nombre");
      System.out.println("[2] Reabastecer       [6] Mostrar info de un producto");
      System.out.println("[3] Retirar           [7] Salir");
      System.out.println("[4] Ajustar precio    ");
      opc = sc.nextInt();
      sc.nextLine();
      switch (opc) {
        case 1: // Crear producto 
          if(indice == 9){
            System.out.println("Inventario lleno..." + 
                "\nNo es posible agregar mas productos");
          }
          inventario[indice++] = crearProducto();
          break;
        case 2: // Reabastecer Producto
          buscarIndice = buscarIndice(indice);
          if(buscarIndice == -1){
            break;
          }
          sc.nextLine();
          System.out.println("Ingrese la cantidad a abastecer ");
          int abastecer = sc.nextInt();
          sc.nextLine();
          inventario[buscarIndice - 1].abastecer(abastecer);
          System.out.println("Stock reabastecido: " + inventario[buscarIndice - 1].getStock() + " " + inventario[buscarIndice - 1].getNombre());
          break;
        case 3: // Retirar Producto
          buscarIndice = buscarIndice(indice);
          if(buscarIndice == -1){
            break;
          }
          System.out.println("Ingrese la cantidad a retirar ");
          int retirar = sc.nextInt();
          sc.nextLine();
          if(!inventario[buscarIndice - 1].retirar(retirar))
            System.out.println("Operacion no exitosa... Stock insuficiente. Stock: " + inventario[buscarIndice - 1].getStock());
          else
            System.out.println("Operacion exitosa!!");
          break;
        case 4: // Ajustar precio de un Producto
          buscarIndice = buscarIndice(indice);
          if(buscarIndice == -1){
            break;
          }
          System.out.println("Precio actual: " + inventario[buscarIndice - 1].getPrecio());
          System.out.println("Ingrese el nuevo precio ");
          float precio = sc.nextFloat();
          sc.nextLine();
          inventario[buscarIndice - 1].setPrecio(precio);
          System.out.println("Nuevo precio: " + inventario[buscarIndice - 1].getPrecio());
          break;
        case 5: // Ajustar nombre
          buscarIndice = buscarIndice(indice);
          if(buscarIndice == -1){
            break;
          }
          System.out.println("Nombre del producto actual: " + inventario[buscarIndice - 1].getNombre());
          System.out.println("Ingrese el nuevo nombre ");
          String nombre = sc.nextLine();
          inventario[buscarIndice - 1].setNombre(nombre);
          System.out.println("Nuevo nombre: " + inventario[buscarIndice - 1].getNombre());
          break;
        case 6: // Mostrar Info de un producto 
          buscarIndice = buscarIndice(indice);
          if(buscarIndice == -1){
            break;
          }
          System.out.println(inventario[buscarIndice - 1].toString());
          break;
        case 7: // Salir
          System.out.println("Terminando programa...");
          break;
        default:
          System.out.println("Opcion inavalida...");
          break;
      }
    }while(opc != 7);
  }

  public Producto crearProducto(){
    System.out.println("Ingresa el nombre del producto>> ");
    String nom = sc.nextLine();
    System.out.println("Ingresa el tipo del producto>> ");
    String tipo = sc.nextLine();
    System.out.println("Ingresa el precio del producto>> ");
    float precio = sc.nextFloat();

    // Llamada a constructor
    Producto prod = new Producto(nom, tipo, precio);
    return prod;
  }

  public void mostrarProductos(){
    for(int i = 0; inventario[i] != null; i++){
      System.out.println((i+1) + ". "+ inventario[i].getNombre() + "\n");
    }
  }

  public int buscarIndice(int indice){
    int buscarIndice;
    if(indice == 0){
      System.out.println("No hay nada en el inventario");
      return -1;
    }
    mostrarProductos();
    System.out.println("Ingresa el ID del producto");
    buscarIndice = sc.nextInt();
    if(buscarIndice - 1 > indice){
      System.out.println("ID invalido!");
      return -1;
    } else {
      return buscarIndice;
    }
  }
}
