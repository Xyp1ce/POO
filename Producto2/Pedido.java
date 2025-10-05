public class Pedido {
    private String fecha;
    private int numeroPedido;
    private double total;
    private Producto[] productos;
    private int indice;
    private static float IVA; 

    // Constructor
    public Pedido(String fecha, int numeroPedido) {
        this.fecha = fecha;
        this.numeroPedido = numeroPedido;
        total = 0;
        productos = new Producto[50];
        indice = 0;
    }

    static {
        // IVA por defecto 16%
        IVA = .16f;
    }

    @Override
    public String toString() {
    double totalConIVA = total + (total * IVA);
    return String.format("Pedido{%nNumero=%d%n total=%.2f%n totalConIVA=%.2f%n}",
                         numeroPedido, total, totalConIVA);
    }

    // Getters 
    public String getFecha() {
        return fecha;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public double getTotal() {
        return total;
    }

    public static float getIVA() {
        return IVA;
    }

    // Setters
    public static void setIVA(float nuevoIVA) {
        if(nuevoIVA > 1) {
            nuevoIVA = nuevoIVA/100; // convertimos a por ciento en caso de ser mayor a 1
        }
        IVA = nuevoIVA;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    // Agregar un producto ya existente
    public int addProducto(Producto producto) {
        if (indice < productos.length) {
            productos[indice++] = producto;
            total += producto.getPrecio();
        } else {
            return 0;
        }
        return 1;
    }

    public void verProductos() {
        for(int i = 0; i < indice; i++) {
            System.out.println((i+1) + " -> " + productos[i]);
        }
    }
}