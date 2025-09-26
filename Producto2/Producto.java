public class Producto {
    private String nombre;
    private double precio;
    private String tipo;

    // Constructor
    public Producto(String nombre, double precio, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nProducto{" +
                "\nnombre='" + nombre + 
                "\nprecio=" + precio +
                "\ntipo='" + tipo + 
                "\n}";
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}