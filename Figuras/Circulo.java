public class Circulo{
  //atributos
  public float radio;
  public float perimetro;
  public float pi = 3.1416f;

  //metodos
  public float calcularArea(){
    return pi * (radio * radio);
  }

  public float calcularPerimetro(){
    return 2 * pi * radio;
  }
}
