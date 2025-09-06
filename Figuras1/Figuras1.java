/*
 * Ramon Manriquez Guerrero 
 * 28/08/2025
 * Figuras
 */

import java.util.Scanner;

public class Figuras1{
  // atributos
  float radio, lado, apotema;

  public static void main(String[] args){
    // Creacion del objeto 
    Figuras figura = new Figuras();
    figura.menu();
  }

  public void menu(){
    Scanner scanner = new Scanner(System.in);
    while(true){
      System.out.println("--MENU--");
      System.out.println("[1] Circulo [3] Cerrar");
      System.out.println("[2] Pentagono");
      int opc = scanner.nextInt();
      switch(opc){
        case 1: // Circulo
          System.out.println("ingresa el radio del circulo>> ");
          radio = scanner.nextFloat();
          areaCirculo(radio);
          perimetroCirculo(radio);
          break;
        case 2: // Pentagono
          System.out.println("Ingresa la longitud de un lado>> ");
          lado = scanner.nextFloat();
          System.out.println("Ingresa el apotema del pentagono>> ");
          apotema = scanner.nextFloat();
          areaPentagono(lado, apotema);
          perimetroPentagono(lado);
          break;
        case 3:
          System.out.println("Terminando Programa...");
          return;
        default:
          System.out.println("Opcion invalida...");
      }
    }
  }

  // Metodos para el calculo de areas y perimetros
  public void areaCirculo(float radio){
    float r = radio;
    float pi = 3.1416f;
    System.out.println("El area del circulo con radio " + r + " es " + pi * (r*r)); 
  }

  public void perimetroCirculo(float radio){
    float perimetro = 0;
    float pi = 3.1416f;
    float r = radio;
    perimetro = 2*pi*r;
    System.out.println("El perimetro del ciruclo con radio " + r + " es " + perimetro);
  }

  public void areaPentagono(float lado, float apotema){
    float area = ((lado*5) * apotema)/2;
    System.out.println("El area de un pentagono con lado " + lado + " es de " + area);
  }

  public void perimetroPentagono(float lado){
    System.out.println("El perimetro de un pentagono de lado " + lado + " es de " + lado * 5);
  }
}
