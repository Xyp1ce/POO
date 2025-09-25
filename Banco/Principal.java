/* Ramon Manriquez Guerrero
 * 15/09/2025
 * Empleado junto con Cuenta y Banco
 */

import java.util.Scanner;

public class Principal{
  public Scanner sc = new Scanner(System.in);
  public static void main(String[] args){
    Principal p = new Principal();
    p.menu();
  }

  public void menu() {
    int opc;
    Sucursal sucursal = new Sucursal("Zona Rio", 123);
    Cliente cliente;
    String nombre;
    Cuenta cuenta;
    do {
      System.out.println("\n[1] Agregar Cliente [4] Ver Cuentas Cliente\n" +
                         "[2] Ver Clientes    [5] Realizar transaccion\n" +
                         "[3] Agregar Cuenta  [6] Salir\n");
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
        case 4: // Ver Cuentas Clientes
          cliente = buscarCliente(sucursal);
          cliente.verCuentas();
          break;
        case 5: // Transaccion
          cliente = buscarCliente(sucursal);
          if(cliente == null) {
            System.out.println("Cancelando...\n");
            break;
          }
          System.out.println("Cliente encontrado");
          cuenta = buscarCuenta(cliente);
          if(cuenta == null) {
            System.out.println("Cancelando...\n");
            break;
          }
          System.out.println("Cuenta encontrada");
          do { // Escoger opcion
            System.out.println("[1] Deposito [3] Seleccionar Cuenta\n" +
                               "[2] Retiro   [4] Cancelar\n");
            opc = sc.nextInt();
            sc.nextLine();
            switch(opc) {
              case 1: // Deposito
                deposito(cuenta);
                break;
              case 2: // Retiro 
                retiro(cuenta);
                break;
              case 3: // Seleccionar cuentas 
                Cuenta aux;
                aux = buscarCuenta(cliente);
                if(aux != null) 
                  cuenta = aux;
                break;
              case 4: // Cancelar 
                System.out.println("Cancelando...\n");
                break;
              default:
                System.out.println("Opcion invalida...");
                break;
            }
          } while(opc != 4);
          break;
        case 6: // Salir
          System.out.println("Finalizando programa...\n");
          break;
        default:
          break;
      }
    } while(opc != 6); 
  }

  public Sucursal crearSucursal() {
    System.out.println("Ingresa el numero de la sucursal");
    int noSucursal = sc.nextInt();
    sc.nextLine();
    System.out.println("Ingresa la direccion de la sucursal");
    String direccion = sc.nextLine();
    return new Sucursal(direccion, noSucursal);
  }

  public void crearCliente(Sucursal sucursal) {
    System.out.println("Ingresa el nombre del cliente");
    String nombre = sc.nextLine();
    System.out.println("Ingresa la direccion del cliente");
    String direccion = sc.nextLine();
    sucursal.addCliente(nombre, direccion);
  }
 
  public void crearCuenta(Sucursal sucursal) {
    Cliente cliente = buscarCliente(sucursal);
    if(cliente != null) { // Si existe el cliente
      System.out.println("\nCliente encontrado");
      System.out.println("Ingresa el numero de cuenta");
      long noCuenta = sc.nextLong();
      sc.nextLine();
      System.out.println("Ingresa su CLABE");
      long clave = sc.nextLong();
      sc.nextLine();
      System.out.println("Ingresa la fecha de vencimiento (MM/AA)");
      String fechaVencimiento = sc.nextLine();
      System.out.println("Ingresa el tipo de la cuenta");
      String tipo = sc.nextLine();
      cliente.addCuenta(noCuenta, clave, fechaVencimiento, tipo);
    } else {
      System.out.println("No se encontro ningun cliente con ese nombre");
    }
  }

  public Cliente buscarCliente(Sucursal sucursal) {
    Cliente cliente;
    int opc = 2;
    do {
      System.out.println("Ingresa el nombre del Cliente");
      String nombre = sc.nextLine();
      cliente = sucursal.buscarCliente(nombre);
      if(cliente == null){
        System.out.println("Cliente no encontrado");
        System.out.println("Quiere continuar? [1] Si [2] No");
        opc = sc.nextInt();
        sc.nextLine();
      }
    } while(opc == 1);
    if(opc == 2 && cliente != null)
      return cliente;
    else 
      return null;
  }

  public Cuenta buscarCuenta(Cliente cliente) {
    Cuenta cuenta;
    int opc = 2;
    do { // Buscar la cuenta del cliente
      cliente.verCuentas();
      System.out.println("Ingresa el No. de Cuenta");
      long noCuenta = sc.nextLong();
      sc.nextLine();
      cuenta = cliente.buscarCuenta(noCuenta);
      if(cuenta == null){
        System.out.println("Cuenta no encontrada");
        System.out.println("Quiere continuar? [1] Si [2] No");
        opc = sc.nextInt();
        sc.nextLine();
      }
    } while(opc == 1);
    if(cuenta != null)
      return cuenta;
    else 
      return null;
  }

  public void deposito(Cuenta cuenta){
    System.out.println("Ingresa la cantidad a depositar");
    float deposito = sc.nextFloat();
    sc.nextLine();
    System.out.println("Saldo actual: " + cuenta.getSaldo());
    if(cuenta.depositar(deposito) == 0) {
      System.out.println("Error. Deposito no exitoso");
    } else {
      System.out.println("Saldo actualizado: " + cuenta.getSaldo());
    }
  }

  public void retiro(Cuenta cuenta) {
    System.out.println("Ingresa la cantidad a retirar");
    float retiro = sc.nextFloat();
    sc.nextLine();
    System.out.println("Saldo actual: " + cuenta.getSaldo());
    if(cuenta.retirar(retiro) == 0) {
      System.out.println("Error. Retiro no exitoso");
    } else {
      System.out.println("Saldo actualizado: " + cuenta.getSaldo());
    }
  }
}
