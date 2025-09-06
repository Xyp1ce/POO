public class Pentagono{
  //atributos 
  public float apotema;
  public float lado;
  
  // Metodos
  public float calcularArea(){
    return (calcularPerimetro() * apotema) / 2;
  }

  public float calcularPerimetro(){
    return lado * 5;
  }
}
