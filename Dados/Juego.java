import java.util.Scanner;

public class Juego{

  Scanner sc = new Scanner(System.in);
  int opc;

  public static void main(String[] args){
    Juego j = new Juego();
    j.dados();
  }

  public void dados(){
    /* Juego por pares o impares
     * El jugador escoge si apostar por pares o impares
     * Se juega con dos dados */ 

    // Creacion de objetos tipo Dado
    Dados d1 = new Dados();
    Dados d2 = new Dados();
    int res; // Guardara el modulo para saber si es par o impar

    while(true){ // Bucle hasta que el jugador lo decida
      do{
        System.out.println("Apuestas por [1] Pares o [2] Impares>>");
        opc = sc.nextInt();
      }while(opc != 1 && opc != 2);
      d1.setAleatorio();
      d2.setAleatorio();
      res = (d1.getCara() + d2.getCara());
      if((res%2 == 0 && opc == 1) || (res%2 == 1 && opc == 2)){
        System.out.println("Has Ganado!!!");
        System.out.println("Los dados han sumado:" + res);
      } else {
        System.out.println("Has Perdido");
        System.out.println("Los dados han sumado:" + res);
      }
      do{
        System.out.println("Quieres seguir jugando?\n[1] SI [2] NO\n>>");
        opc = sc.nextInt();
      }while(opc != 1 && opc != 2);
      if(opc == 2){
        break;
      }
    }
  }
}
