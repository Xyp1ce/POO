/*
 * Ramon Manriquez Guerero
 * 10-9-2025
 * Clase Empleado
 * A las 40 horas se termina tu semana laboral y cualquier
 * hora extra se paga 2 veces el salario base 
 */

public class Empleado{
  // Atributos
  private String nombre;
  private String puesto;
  private float salario;
  private float salarioBruto;
  private float impuestos;
  private float descuentos;
  private int horasTrabajadas;
  private int horasFaltadas;
  private int retardos;
  private boolean metaEstablecida;

  // key word final para declarar una constante
  // Politica: cada retardo descuenta 0.25 horas o 15 minutos
  private final float penalizacionRetardos = 0.25f;
  // Bonos establecidos como constantes por politicas de la emprsa
  private final float bonoPuntualidad = 230.23f;
  private final float bonoProductividad = 530.42f;

  // Constructor
  public Empleado(String nombre, String puesto, float salario){

    // Solo inicializamos estos atributos porque son los prederterminados
    this.nombre = nombre;
    this.puesto = puesto;
    this.salario = salario; // el salario es por hora

    // Estos atributos se modificaran, por lo que no es necesario
    // asignarles un valor
    salarioBruto = 0;
    impuestos = 0;
    horasTrabajadas = 0;
    horasFaltadas = 0;
    retardos = 0;
    descuentos = 0;
    metaEstablecida = false;
  }

  public Empleado() { // Constructor vacio
    this.nombre = null;
    this.puesto = null;
    this.salario = 0.0f;
    this.salarioBruto = 0.0f;
    this.impuestos = 0.0f;
    this.horasTrabajadas = 0;
    this.horasFaltadas = 0;
    this.retardos = 0;
    this.descuentos = 0.0f;
    this.metaEstablecida = false;
  }

  public Empleado(String nombre, String puesto, float salario, int horasTrabajadas, int retardos) {
    // Constructor con
    // nombre, salario, horasTrabajadas y retardos
    this.nombre = nombre;
    this.puesto = puesto;
    this.salario = salario;
    this.horasTrabajadas = horasTrabajadas;
    this.retardos = retardos;

    // Inicializamos lo demás
    this.salarioBruto = 0.0f;
    this.impuestos = 0.0f;
    this.horasFaltadas = 0;
    this.descuentos = 0.0f;
    this.metaEstablecida = false;
  }

  @Override
  public String toString() {
    return "Empleado: " + nombre + " (" + puesto + ")\n" +
      "Horas trabajadas: " + horasTrabajadas + "\n" +
      "Horas faltadas: " + horasFaltadas + " | Retardos: " + retardos + "\n" +
      String.format("Pago horas extra: %.2f\n", calcularPagoHorasExtras()) +
      String.format("Salario bruto: %.2f\n", calcularSalarioBruto()) +
      String.format("Impuestos: %.2f\n", calcularImpuestos()) +
      String.format("Desc. por faltas: %.2f\n", calcularDescuentoPorFaltas()) +
      String.format("Desc. por retardos: %.2f\n", calcularDescuentoPorRetardos()) +
      String.format("Bonos: %.2f\n", calcularBonos()) +
      String.format("Salario neto: %.2f\n", calcularSalarioNeto()) +
      "\n";
  }

  // Metodos
  public void setHorasTrabajados(int horasTrabajadas){
    this.horasTrabajadas = horasTrabajadas;
  }

  public void setHorasFaltadas(int horasFaltadas){
    this.horasFaltadas = horasFaltadas;
  }

  public void setMetaEstablecida(boolean metaEstablecida){
    this.metaEstablecida = metaEstablecida;
  }

  public void setRetardos(int retardos){
    this.retardos = retardos;
  }

  public int getHorasTrabajadas(){
    return horasTrabajadas;
  }

  public String getNombre(){
    return nombre;
  }

  public float calcularSalarioBruto(){
    int horasBase = 0;
    if(horasTrabajadas > 40){
      horasBase = 40;
    } else {
      horasBase = horasTrabajadas;
    }
    salarioBruto = ((horasBase * salario) + calcularPagoHorasExtras());
    return salarioBruto;
  }

  public float calcularPagoHorasExtras(){
    if(horasTrabajadas - 40 <= 0){
      // No hay horas extras
      return 0;
    } else {
      int horasExtras = (horasTrabajadas - 40);
      return horasExtras * (salario * 2);
    }
  }

  public float calcularImpuestos(){
    impuestos = salarioBruto * 0.16f;
    return impuestos;
  }

  public float calcularDescuentoPorFaltas(){
    return salario * horasFaltadas;
  }

  public float calcularDescuentoPorRetardos(){
    return salario * penalizacionRetardos * retardos;
  }

  public float calcularBonos(){
    float totalBonos = 0f;
    if(horasFaltadas == 0 && retardos == 0){
      totalBonos += bonoPuntualidad;
    }
    if(metaEstablecida){
      totalBonos += bonoProductividad;
    }
    return totalBonos;
  }

  public float calcularSalarioNeto(){
    // Recalcular todo para asegurar consistencia
    float bruto = calcularSalarioBruto();
    float imp = calcularImpuestos();
    float descFaltas = calcularDescuentoPorFaltas();
    float descRetardos = calcularDescuentoPorRetardos();
    float bonos = calcularBonos();
    descuentos = descFaltas + descRetardos; // total de descuentos
    float neto = bruto - imp - descuentos + bonos;
    if(neto < 0)
      return 0;
    else 
      return neto;
  }
}
