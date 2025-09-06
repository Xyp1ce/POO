import java.util.Scanner;

public class Principal{

  Scanner scanner = new Scanner(System.in);

  public static void main(String[] args){
    Principal p = new Principal();
    p.menu();
  }

  public void menu(){
    System.out.println("Ingresa el nombre del producto>> ");
    String nom = scanner.nextLine();
    System.out.println("Ingresa el tipo del producto>> ");
    String tipo = scanner.nextLine();
    System.out.println("Ingresa el precio del producto>> ");
    float precio = scanner.nextFloat();

    // Llamada a constructor
    Producto prod = new Producto(nom, tipo, precio);
    prod.abastecer(10);
    System.out.println("Producto abastecido!");
    System.out.println(prod.getNombre());
    System.out.println(prod.getTipo());
    System.out.println(prod.getPrecio());
    if(prod.retirar(11)){
      System.out.println("Retiro de prodcutos exitoso");
    } else {
      System.out.println("Retiro de productos fallido... Stock disponible: ");
      System.out.println(prod.getStock());
    }
  }
}
