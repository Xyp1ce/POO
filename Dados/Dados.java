import java.util.Random;

public class Dados{

  Random generador = new Random();
 
  private int caraVisible;

  // No se necesita contrusctor

  // metodos 
  public int getCara(){
    return caraVisible;
  }

  public void setAleatorio(){
     caraVisible = generador.nextInt(6) + 1;
  }
}
