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

    // agrega un pedido ya creado (sobrecarga que recibe el objeto Pedido con productos)
    public void addPedido(Pedido pedido) {
        if (indice < pedidos.length) {
            pedidos[indice++] = pedido;
        } else {
            System.out.println("No se pueden agregar más pedidos para este cliente.");
        }
    }

    public int verPedidos() {
        if (indice == 0) {
            return 0;
        }
        System.out.println("Pedidos de " + nombre + ":");
        for (int i = 0; i < indice; i++) {
            System.out.println((i + 1) + " -> " + pedidos[i]);
        }
        return 1;
    }   
}