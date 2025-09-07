/*
 * Ramon Manriquez Guerrero 
 * 01/09/2025
 * Cuenta de public static 
 */

import java.util.Scanner;

public class Cliente{
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args){
    Cliente c = new Cliente();
    c.menu();
  }

  public void menu(){
    int opc = 0;

    System.out.println("Ingresa el numero de cuenta");
    long noCuenta = sc.nextLong();
    sc.nextLine();
    System.out.println("Ingresa la clave");
    long clave = sc.nextLong();
    sc.nextLine();
    System.out.println("Ingresa la fecha de vencimiento");
    String fechaVencimiento = sc.nextLine();
    System.out.println("Ingresa el tipo");
    String tipo = sc.nextLine();
    // Llamado a metodo Constructor
    Cuenta cuenta = new Cuenta(noCuenta, clave, fechaVencimiento, tipo);

    do{
      System.out.println("== BANCO ==");
      System.out.println("[1] Retirar           [4] Consultar fecha de vencimiento");
      System.out.println("[2] Depostitar        [5] Consultar saldo");
      System.out.println("[3] Renovar           [6] Salir");
      opc = sc.nextInt();
      sc.nextLine();

      switch(opc){
        case 1: // Retirar 
          System.out.println("Ingrese la cantidad a retirar ");
          float retiro = sc.nextFloat();
          sc.nextLine();
          if(cuenta.retirar(retiro) == 0){
            System.out.println("Operacion no exitosa... fondos insuficientes");
          } else {
            System.out.println("Operacion exitosa");
          }
          break;
        case 2: // Depostiar 
          System.out.println("Ingrese la cantidad a depositar ");
          float deposito = sc.nextFloat();
          sc.nextLine();
          cuenta.depositar(deposito);
          System.out.println("Operacion exitosa");
          break;
        case 3: // renovar  
          System.out.println("Ingresa la nueva fecha de vencimiento ");
          fechaVencimiento = sc.nextLine();
          cuenta.renovar(fechaVencimiento);
          break;
        case 4: // getFechaVencimiento 
          cuenta.getFechaVencimiento();
          break;
        case 5: // Consultar saldo tarjeta
          cuenta.getSaldo();
          break;
        case 6: // Salir
          System.out.println("Terminando programa...");
          break;
        default: 
          System.out.println("Opcion invalida...");
          break;
      }
    }while(opc != 6);
  }
}
