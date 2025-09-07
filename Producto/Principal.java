import java.util.Scanner;

public class Principal{

  Scanner sc = new Scanner(System.in);

  public static void main(String[] args){
    Principal p = new Principal();
    p.menu();
  }

  public void menu(){
    int opc = 0;
    
    System.out.println("Ingresa el nombre del producto>> ");
    String nom = sc.nextLine();
    System.out.println("Ingresa el tipo del producto>> ");
    String tipo = sc.nextLine();
    System.out.println("Ingresa el precio del producto>> ");
    float precio = sc.nextFloat();

    // Llamada a constructor
    Producto prod = new Producto(nom, tipo, precio);
    
    do{
      System.out.println("== ALMACEN ==");
      System.out.println("[1] Revisar Stock     [4] Ajustar precio");
      System.out.println("[2] Reabastecer       [5] Ajugar tipo de producto");
      System.out.println("[3] Retirar           [6] Ajustar nombre");
      System.out.println("                      [7] Salir");
      opc = sc.nextInt();
      sc.nextLine();
      switch (opc) {
        case 1: // Revisar Stock
          System.out.println("El stock disponible es de: " + prod.getStock() + " " +prod.getNombre());
          break;
        case 2: // Reabastecer
          System.out.println("Ingrese la cantidad a abastecer ");
          int abastecer = sc.nextInt();
          sc.nextLine();
          prod.abastecer(abastecer);
          System.out.println("Stock reabastecido: " + prod.getStock() + " " + prod.getNombre());
          break;
        case 3: // Retirar
          System.out.println("Ingrese la cantidad a retirar ");
          int retirar = sc.nextInt();
          sc.nextLine();
          if(!prod.retirar(retirar))
            System.out.println("Operacion no exitosa... Stock insuficiente. Stock: " + prod.getStock());
          else
            System.out.println("Operacion exitosa!!");
          break;
        case 4: // Ajustar precio
          System.out.println("Precio actual: " + prod.getPrecio());
          System.out.println("Ingrese el nuevo precio ");
          precio = sc.nextFloat();
          sc.nextLine();
          prod.setPrecio(precio);
          System.out.println("Nuevo precio: " + prod.getPrecio());
          break;
        case 5: // Ajustar tipo de producto
          System.out.println("Tipo de producto actual: " + prod.getTipo());
          System.out.println("Ingrese el nuevo tipo ");
          tipo = sc.nextLine();
          prod.setTipo(tipo);
          System.out.println("Nuevo tipo de producto: " + prod.getTipo());
          break;
        case 6: // Ajustar nombre
          System.out.println("Nombre del producto actual: " + prod.getNombre());
          System.out.println("Ingrese el nuevo nombre ");
          String nombre = sc.nextLine();
          prod.setNombre(nombre);
          System.out.println("Nuevo nombre: " + prod.getNombre());
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
}
