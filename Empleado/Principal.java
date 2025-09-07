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
  public static void main(String[] args) {
    Principal p = new Principal();
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
          if(empCant < 9){
            System.out.println("Ingrese el nombre del empleado");
            String nom = sc.nextLine();
            System.out.println("Ingrese el puesto del empleado");
            String puesto = sc.nextLine();
            System.out.println("Ingrese el salario del empleado (por hora)");
            float salario = sc.nextFloat();
            sc.nextLine();
            // Llamado a metodo constructor
            Empleado empleado = new Empleado(nom, puesto, salario);
            empleados[empCant] = empleado;
            empCant++; // llevar control de en que posicion se 
                       // registrara el nuevo empleado
          } else {
            System.out.println("Ya no se pueden registrar empleados");
          }
          break;
        case 2: // Ingresar datos empleado
          boolean encontrado = false;
          System.out.println("Ingrese el nombre del empleado");
          String buscarNombre = sc.nextLine();
          for(int i = 0; i < empleados.length; i++){
            if(empleados[i] != null && empleados[i].getNombre().equals(buscarNombre)){
              System.out.println("Empleado encontrado: " + empleados[i].getNombre());
              encontrado = true;
              System.out.println("Ingresa la cantidad de horas trabajadas en la semana");
              int horasTrabajadas = sc.nextInt();
              sc.nextLine();
              empleados[i].setHorasTrabajados(horasTrabajadas);
              /* No preguntamos cuantas horas faltaron 
               * el sistema las calcula automaticamente 
               * para evitar inconsistencias */
              int horasFaltadas = 0;
              if(40 - horasTrabajadas > 0) {
                horasFaltadas = 40 - horasTrabajadas;
              }
              empleados[i].setHorasFaltadas(horasFaltadas);
              System.out.println("Cumplio con las metas establecidas? Escriba true o false");
              boolean metaEstablecida = sc.nextBoolean();
              empleados[i].setMetaEstablecida(metaEstablecida);
              System.out.println("Cuantos retardos tuvo?");
              int retardos = sc.nextInt();
              empleados[i].setRetardos(retardos);

            }
          }
          if(!encontrado){
            System.out.println("Empleado con nombre " + buscarNombre + " no encontrado");
          }
          break;
        case 3:
          encontrado = false;
          System.out.println("Ingresa el nombre del empleado");
          buscarNombre = sc.nextLine();
          for(int i = 0; i < empleados.length; i++){
            if(empleados[i] != null && empleados[i].getNombre().equals(buscarNombre)){
              System.out.println("Empleado encontrado: " + empleados[i].getNombre());
              encontrado = true;
              empleados[i].mostrarInfo();
            }
          }
          if(!encontrado){
            System.out.println("Empleado con nombre " + buscarNombre + " no encontrado");
          }
          break;
        case 4: // Mostrar empleados
          for(int i = 0; i < empleados.length; i++){
            if(empleados[i] != null)
              System.out.println((i+1) + ". " + empleados[i].getNombre());
          }
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
}
