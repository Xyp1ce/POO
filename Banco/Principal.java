/* Ramon Manriquez Guerrero
 * 15/09/2025
 * Empleado junto con Cuenta y Banco
 */

import java.util.Scanner;

public class Principal{
  public static Scanner sc = new Scanner(System.in);
  public static Sucursal sucursal;
  public static void main(String[] args){
    int opc;
    sucursal = crearSucursal();
    do {
      System.out.println("[1] Agregar Cliente");
      System.out.println("[2] Ver Cliente");
      System.out.println("[3] Agregar Cuenta");
      System.out.println("[4] Salir");
      opc = sc.nextInt();
      sc.nextLine();
      switch(opc) {
        case 1: // agregar Clientes
          if(sucursal.getCantidad() == 9) {
            System.out.println("No es posible agregar mas clientes");
          } else {
            crearCliente(sucursal);
          }
          break;
        case 2: // ver Clientes
          sucursal.getClientes();
          break;
        case 3: // Agregar Cuenta
          crearCuenta(sucursal);
          break;
        case 4: // Salir 
          System.out.println("Finalizando programa...");
          break;
        default:
          break;
      }
    } while(opc != 4); 
  }

  public static Sucursal crearSucursal() {
    System.out.println("Ingresa el numero de la sucursal");
    int noSucursal = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la direccion de la sucursal");
    String direccion = sc.nextLine();
    return new Sucursal(direccion, noSucursal);
  }

  public static void crearCliente(Sucursal sucursal) {
    System.out.println("Ingresa el nombre del cliente");
    String nombre = sc.nextLine();
    System.out.println("Ingresa la direccion del cliente");
    String direccion = sc.nextLine();
    sucursal.addCliente(nombre, direccion);
  }
  
  public static void crearCuenta(Sucursal sucursal) {
    System.out.println("Ingresa el nombre del Cliente");
    String nombre = sc.nextLine();
    Cliente cliente = sucursal.buscarCliente(nombre);
    if(cliente != null) { // Si existe el cliente
      System.out.println("Cliente encontrado");
      System.out.println("Ingresa el numero de cuenta");
      long noCuenta = sc.nextLong();
      sc.nextLine();
      System.out.println("Ingresa su CLABE");
      long clave = sc.nextLong();
      sc.nextLine();
      System.out.println("Ingresa la fecha de vencimiento");
      String fechaVencimiento = sc.nextLine();
      System.out.println("Ingresa el tipo de la cuenta");
      String tipo = sc.nextLine();
      cliente.addCuenta(noCuenta, clave, fechaVencimiento, tipo);
    } else {
      System.out.println("No se encontro ningun cliente con ese numero de cliente");
    }
  }
}


