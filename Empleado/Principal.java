/*
 * Ramon Manriquez Guerrero
 * 10-09-2025
 * Clase Principal en la que tendremos la 
 * implementacion del menu
 */ 

import java.util.Scanner;

public class Principal {
  Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    Principal p = new Principal();
    p.menu();
  }

  public void menu(){
    System.out.println("Ingrese el nombre del empleado");
    String nom = sc.nextLine();
    System.out.println("Ingrese el puesto del empleado");
    String puesto = sc.nextLine();
    System.out.println("Ingrese el salario del empleado (por hora)");
    float salario = sc.nextFloat();
    sc.nextLine();
    // Llamado a metodo constructor
    Empleado empleado = new Empleado(nom, puesto, salario);
    System.out.println("Ingresa la cantidad de horas trabajadas en la semana");
    int horasTrabajadas = sc.nextInt();
    sc.nextLine();
    empleado.setHorasTrabajados(horasTrabajadas);
    /* No preguntamos cuantas horas faltaron 
     * el sistema las calcula automaticamente 
     * para evitar inconsistencias */
    int horasFaltadas = 0;
    if(40 - horasTrabajadas > 0) {
      horasFaltadas = 40 - horasTrabajadas;
    }
    empleado.setHorasFaltadas(horasFaltadas);
    System.out.println("Cumplio con las metas establecidas? Escriba true o false");
    boolean metaEstablecida = sc.nextBoolean();
    empleado.setMetaEstablecida(metaEstablecida);
    System.out.println("Cuantos retardos tuvo?");
    int retardos = sc.nextInt();
    empleado.setRetardos(retardos);
    empleado.mostrarInfo();
  }
}
