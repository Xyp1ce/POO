/*
 * Ramon Manriquez Guerrero 
 * 01/09/2025
 * Cuenta de public static 
*/ 
import java.util.Scanner;

public class Cliente{
  public static void main(String[] args){
    Cliente c = new Cliente();
    c.menu();
  }

  public void menu(){
    Cuenta cuenta = new Cuenta(123456789L, 1234, "01/09/2030", "Credito");
    cuenta.depositar(415.98F);
    cuenta.retirar(400.98F);
    cuenta.getSaldo();
  }
}
