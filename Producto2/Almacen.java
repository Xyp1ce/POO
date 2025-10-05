public class Almacen {
    private static Producto[] productos = new Producto[100];
    private static int indice = 0;

    // Getters
    public static int getCantidad() {
        return (indice + 1);
    }

    public static void verProductos() {
        for(int i = 0; i < indice; i++) {
            System.out.println((i + 1) + ".\n" + productos[i]);
        }
    }

    public static int addProducto(String nombre, double precio, String tipo) {
        if(indice < 100) {
            productos[indice++] = new Producto(nombre, precio, tipo);
        } else { // No hay espacio
            return 0;
        }
        return 1; // se completo la accion
    }

    public static Producto buscarProducto(String nombre) {
        for (int i = 0; i < indice; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                return productos[i];
            }
        }
        return null; // No se encontró el producto
    }

    public static Producto buscarProducto(int eleccion) {
        return productos[eleccion - 1];
    }
}