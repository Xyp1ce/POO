public class Cliente {
    private String nombre;
    private String direccion;
    private Pedido[] pedidos;
    private int indice;

    // Constructor con parámetros
    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pedidos = new Pedido[50];
        this.indice = 0;
    }

    // Getters 
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    // Setters 
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // agrega un pedido ya creado
    public void addPedido(String fecha, int noPedido) {
        if (indice < pedidos.length) {
            pedidos[indice++] = new Pedido(fecha, noPedido);
        } else {
            System.out.println("No se pueden agregar más pedidos para este cliente.");
        }
    }

    public void verPedidos() {
        if (indice == 0) {
            System.out.println("El cliente no tiene pedidos.");
            return;
        }
        System.out.println("Pedidos de " + nombre + ":");
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + " -> " + pedidos[i]);
        }
    }

    
}