public class ClientePoli {

    // Atributos
    private int noCliente;
    private String nombre;
    private String direccion;
    private int indice;
    private CuentaPoli[] cuentas;
    private Telefono[] telefonos;
    private int cantTelefonos;

    // constructores
    public ClientePoli(){}

    public ClientePoli(int noCliente, String nombre, String direccion){
        this.noCliente = noCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.indice = 0;
        // relacion
        cuentas = new CuentaPoli[10];
        // Un cliente puede tener multiples cuentas
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre +
                "\nDireccion: " + direccion +
                "\nNo. Cliente " + noCliente;
    }

    // get/sets
    public int getNoCliente(){
        return noCliente;
    }

    public String getNombre(){
        return nombre;
    }

    public String getDireccion(){
        return direccion;
    }

    public void getDireccion(String direccion){
        this.direccion = direccion;
    }

    public void addAccount(CuentaPoli account) {
        cuentas[indice++] = account;
    }

    public String verCuentas() { // Concatenacion de todas las cuentas de un cliente
        String msgCuentas = "";
        for(int i = 0; i < indice; i++) {
            msgCuentas += cuentas[i].toString();
            msgCuentas += "\n";
        }
        return msgCuentas;
    }

    public CuentaPoli buscarCuenta(long noCuenta) {
        for(int i = 0; i < indice; i++) {
            if(cuentas[i].getNoCuenta() == noCuenta) {
                return cuentas[i];
            }
        }
        return null; // no lo encontro
    }

    public void addTelefono(String tipo, String numero) {
        telefonos[cantTelefonos++] = new Telefono(tipo, numero);
    }

    public void getTelefonos() {
        for(int i = 0; i < cantTelefonos; i++) {
            System.out.println((cantTelefonos+1) + ".-\n"+ "Numero: " + telefonos[i].getNumero() +
                    "Tipo: " + telefonos[i].getTipo());
        }
    }

    class Telefono {
        private String tipo;
        private String numero;

        public Telefono(String tipo, String numero) {
            this.tipo = tipo;
            this.numero = numero;
        }

        public String getTipo() {
            return tipo;
        }

        public String getNumero() {
            return numero;
        }
    }
}
