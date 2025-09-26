public class Almacen {
    private Producto[] productos;
    private int indice;

    public Almacen() {
        productos = new Producto[100];
        indice = 0;
    }

    // Getters
    public int getCantidad() {
        return (indice + 1);
    }

    public void verProductos() {
        for(int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ".\n" + productos[i]);
        }
    }

    public int addProducto(String nombre, double precio, String tipo) {
        if(indice < 100) {
            productos[indice++] = new Producto(nombre, precio, tipo);
        } else { // No hay espacio
            return 0;
        }
        return 1; // se completo la accion
    }

    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < indice; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                return productos[i];
            }
        }
        return null; // No se encontró el producto
    }

    public Producto buscarProducto(int eleccion) {
        return productos[eleccion - 1];
    }
}