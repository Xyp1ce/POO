/*
 * Ramon Manriquez Guerrero
 * 10-09-2025
 * Clase Principal en la que tendremos la 
 * implementacion del menu
 */

import java.util.Scanner;

public class Principal {
  // Array con capacidad de hasta 10 empleados
  Empleado[] empleados = new Empleado[10];
  Scanner sc = new Scanner(System.in);

  // pago minimo por hora
  private final float salarioMinimo = 52.48f;

  public static void main(String[] args) {
    Principal p = new P rincipal();
    p.menu();
  }

  public void menu(){
    int empCant = 0;
    int opc;
    do{
      System.out.println("--MENU--");
      System.out.println("[1] Agregar Empleado        [3] Calcular Nomina");
      System.out.println("[2] Ingresar Datos Empleado [4] Mostar Empleados");
      System.out.println("                            [5] Salir");
      opc = sc.nextInt();
      sc.nextLine();
      switch (opc) {
        case 1: // Agregar Empleado
          Empleado empleado = addEmpleado(empCant);
          if(empleado == null){
            System.out.println("Ya no se pueden registrar empleados");
          } else {
            empleados[empCant++] = empleado; // no aumentamos 
          }
          // llevar control de en que posicion se registrara el nuevo empleado
          break;
        case 2: // Ingresar datos empleado
          datosEmpleado(empleados);
          break;
        case 3: // calcular nomina
          calcularNomina(empleados);
          break;
        case 4: // Mostrar empleados
          showEmpleados(empleados);
          break;
        case 5:
          System.out.println("Finalizando programa...");
          break;
        default:
          System.out.println("Opcion invalida...");
          break;
      }
    }while(opc != 5);
  }

  public Empleado addEmpleado(int empCant) {
    float salario;
    if(empCant < 9){
      System.out.println("Ingrese el nombre del empleado");
      String nom = sc.nextLine();
      System.out.println("Ingrese el puesto del empleado");
      String puesto = sc.nextLine();
      do {
        System.out.println("Ingrese el salario del empleado (por hora)");
        salario = sc.nextFloat();
        sc.nextLine();
      } while(salario < salarioMinimo);
      // Llamado a metodo constructor
      return new Empleado(nom, puesto, salario);
    } else {
      return null;
    }
  }

  public void datosEmpleado(Empleado[] empleados) {
    boolean encontrado = false;
    System.out.println("Ingrese el nombre del empleado");
    String buscarNombre = sc.nextLine();
    int horasTrabajadas;
    int retardos;
    boolean metaEstablecida;
    for(int i = 0; i < empleados.length; i++){
      if(empleados[i] != null && empleados[i].getNombre().equals(buscarNombre)){
        System.out.println("Empleado encontrado: " + empleados[i].getNombre());
        encontrado = true;
        do {
          System.out.println("Ingresa la cantidad de horas trabajadas en la semana");
          horasTrabajadas = sc.nextInt();
          sc.nextLine();
          // Maximo 57 horas a la semana
        } while(horasTrabajadas < 0 || horasTrabajadas > 57);
        empleados[i].setHorasTrabajados(horasTrabajadas);
        /* No preguntamos cuantas horas faltaron 
         * el sistema las calcula automaticamente 
         * para evitar inconsistencias */
        int horasFaltadas = 0;
        if(40 - horasTrabajadas > 0) {
          horasFaltadas = 40 - horasTrabajadas;
        }
        empleados[i].setHorasFaltadas(horasFaltadas);
        if(horasTrabajadas == 0) {
          metaEstablecida = false;
          retardos = 0;
        } else {
          do {
            System.out.println("Cumplio con las metas establecidas? Escriba true o false");
            metaEstablecida = sc.nextBoolean();
          } while(metaEstablecida != true && metaEstablecida != false);
          empleados[i].setMetaEstablecida(metaEstablecida);
          do {
            System.out.println("Cuantos retardos tuvo?");
            retardos = sc.nextInt();
          } while(retardos < 0 || retardos > 7);
          empleados[i].setRetardos(retardos);
        }
      }
    }
    if(!encontrado){
      System.out.println("Empleado con nombre " + buscarNombre + " no encontrado");
    }
  }

  public void calcularNomina(Empleado[] empleados) {
    boolean encontrado = false;
    System.out.println("Ingresa el nombre del empleado");
    String buscarNombre = sc.nextLine();
    for(int i = 0; i < empleados.length; i++){
      if(empleados[i] != null && empleados[i].getNombre().equals(buscarNombre)){
        System.out.println("Empleado encontrado: " + empleados[i].getNombre());
        encontrado = true;
        if(empleados[i].getHorasTrabajadas() == 0){ // falto 3 dias
          System.out.println("El empleado " + empleados[i].getNombre() + " falto demasiado en la semana" +
          " esta despedido");
          empleados[i] = null;
        } else {
          System.out.println(empleados[i]);
        }
      }
    }
    if(!encontrado){
      System.out.println("Empleado con nombre " + buscarNombre + " no encontrado");
    }
  }

  public void showEmpleados(Empleado[] empleados) {
    for(int i = 0; i < empleados.length; i++){
      if(empleados[i] != null)
        System.out.println((i+1) + ". " + empleados[i].getNombre());
    }
  }
}
