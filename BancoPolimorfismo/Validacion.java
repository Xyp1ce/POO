import java.util.Scanner;

public class Validacion {
  private static int valor;

  public static int validInt(String mensaje) {
  Scanner sc = new Scanner(System.in);
    while(true) {
      try {
        System.out.println(mensaje);
        valor = sc.nextInt();
        sc.nextLine();
        return valor;
      } catch(Exception e) {
        System.out.println("Ingresa un valor entero valido");
        sc.nextLine();
      }
    }
  }
}
