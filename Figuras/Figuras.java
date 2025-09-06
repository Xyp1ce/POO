/*
 * Ramon Manriquez 
 * 28-08-2025
 * Figuras
 */ 

// Libreria para la clase Scanner
import java.util.Scanner;

public class Figuras{
  // atributos
  float radio, lado, apotema;

  public static void main(String[] args){
    // creacion de objeto tipo figura
    Figuras figura = new Figuras();
    figura.menu();
  }

  // metodos
  public void menu(){
  // Creacion de objeto tipo Scanner
  Scanner scanner = new Scanner(System.in);
    while(true){ // Mantener el ciclo hasta que el usuario presione 3
      System.out.println("--MENU--");
      System.out.println("[1] Circulo    [3] Cerrar");
      System.out.println("[2] Pentagono");
      int opc = scanner.nextInt();
      switch(opc){
        case 1: // Circulo
          System.out.println("Ingresa el radio del circulo>> ");
          radio = scanner.nextFloat();
          circulo(radio);
          break;
        case 2: // Pentagono
          System.out.println("Ingresa la longitud de un lado>> ");
          lado = scanner.nextFloat();
          System.out.println("Ingresa el apotema>> ");
          apotema = scanner.nextFloat();
          pentagono(lado, apotema);
          break;
        case 3:
          System.out.println("Terminando Programa...");
          return;
        default:
          System.out.println("Opcion invalida...");
      }
    }
  }

  public void circulo(float radio){
    // Creacion de objeto tipo Circulo y asignacino de atributos
    Circulo circulo = new Circulo();
    circulo.radio = radio;
    System.out.println("El area del circulo con radio " + circulo.radio + " es de " + circulo.calcularArea()); 
    System.out.println("El perimetro del circulo con radio " + circulo.radio + " es de " + circulo.calcularPerimetro()); 
  }

  public void pentagono(float lado, float apotema){
    // Creacion de objeto tipo Pentagono y asignacino de atributos
    Pentagono pentagono = new Pentagono();
    pentagono.lado = lado;
    pentagono.apotema = apotema;
    System.out.println("El area de un pentagono con lado de " + pentagono.lado + " es de " + pentagono.calcularArea()); 
    System.out.println("El perimetro un pentagono con lado " + pentagono.lado + " es de " + pentagono.calcularPerimetro()); 
  }
}
