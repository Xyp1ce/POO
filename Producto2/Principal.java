import java.util.Scanner;

public class Principal {
    public Scanner sc = new Scanner(System.in);
    // Lista general de productos disponibles
    private Producto[] productos;
    private int indice;

    public Principal() {
        productos = new Producto[100];
        indice = 0;
    }

    public static void main(String[] args) {
        Principal p = new Principal();
        p.menu();
    }

    public void menu() {
        int opc = 0;
        Cliente cliente = null;
        while (true) {
            System.out.println("Bienvenido\n" +
                    "Ingresa como cliente o como administrador?\n" +
                    "[1] Administrador  [2] Cliente  [3] Salir\n");
            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1)
                administrador();
            else if (opc == 2) {
                if (cliente == null) { // Creamos al cliente solo una vez
                    System.out.println("Ingrese su nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese su direccion: ");
                    String direccion = sc.nextLine();
                    cliente = new Cliente(nombre, direccion);
                }
                cliente(cliente);
            } else if (opc == 3) {
                System.out.println("Saliendo del programa...");
                break;
            } else {
                System.out.println("Opcion invalida...");
            }
        }
    }

    public void administrador() {
        int opc;
        do {
            System.out.println("Desea:\n" +
                    "[1] Agregar producto   [2] Modificar producto   [3] Salir\n");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: // Agregar producto
                    if (indice < productos.length) {
                        productos[indice++] = agregarProducto();
                    } else {
                        System.out.println("No se pueden agregar más productos.");
                    }
                    break;
                case 2: // Modificar producto
                    modificarProducto(productos);
                    break;
                case 3: // Salir
                    System.out.println("Saliendo del modo administrador...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 3);
    }

    public void cliente(Cliente cliente) {
        int opc;
        do {
            System.out.println("\nBienvenido " + cliente.getNombre() + "!!\n");
            System.out.println("[1] Realizar Pedido\n[2] Salir");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: // Realizar pedido
                    Pedido p = pedido(cliente);
                    if (p != null) {
                        System.out.println("Pedido creado: " + p);
                    }
                    break;
                case 2: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 2);
    }

    public Producto agregarProducto() {
        String nombre;
        String tipo;
        double precio;
        System.out.println("Ingresa el nombre del producto");
        nombre = sc.nextLine();
        System.out.println("Ingresa el precio del producto");
        precio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingresa el tipo del producto");
        tipo = sc.nextLine();
        return new Producto(nombre, precio, tipo);
    }

    // Metodo para modificar el producto que el administrador quiera
    public void modificarProducto(Producto[] productos) {
        int opc;
        String nombre;
        String tipo;
        double precio;
        System.out.println("Ingresa el nombre del producto a modificar");
        nombre = sc.nextLine();
        Producto producto = null;
        for (int i = 0; i < indice; i++) {
            if (productos[i] != null && productos[i].getNombre().equals(nombre)) {
                producto = productos[i];
                break;
            }
        }
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        do {
            System.out.println("\nQue quieres modificar del producto " + producto.getNombre() + "\n" +
                    "[1] Nombre  [2] Precio  [3] Tipo  [4] Cancelar");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: // Nombre
                    System.out.println("Ingresa el nuevo nombre");
                    nombre = sc.nextLine();
                    producto.setNombre(nombre);
                    break;
                case 2: // Precio
                    System.out.println("Ingresa el nuevo precio");
                    precio = sc.nextDouble();
                    sc.nextLine();
                    producto.setPrecio(precio);
                    break;
                case 3: // Tipo
                    System.out.println("Ingresa el nuevo tipo");
                    tipo = sc.nextLine();
                    producto.setTipo(tipo);
                    break;
                case 4: // Cancelar
                    System.out.println("Cancelando...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 4);
    }

    // método para ver todos los productos disponibles
    public void verProductos(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) break;
            System.out.println((i + 1) + " -> " + productos[i]);
        }
    }

    // metodo para realizar un pedido y agregarlo al cliente
    public Pedido pedido(Cliente cliente) {
        int opc;
        int eleccion;
        int noPedido;
        String fecha;
        System.out.println("Ingresa la fecha del pedido: ");
        fecha = sc.nextLine();
        System.out.println("Numero de pedido: ");
        noPedido = sc.nextInt();
        sc.nextLine();
        Pedido pedido = new Pedido(fecha, noPedido);

        // Agregar productos al pedido
        do {
            System.out.println("[1] Agregar productos [2] Salir");
            opc = sc.nextInt();
            sc.nextLine();
            if (opc == 1) {
                verProductos(productos);
                System.out.println("Que producto desea agregar (numero):");
                eleccion = sc.nextInt();
                sc.nextLine();
                while (eleccion > indice || eleccion < 1) {
                    System.out.println("Opcion invalida");
                    verProductos(productos);
                    System.out.println("Que producto desea agregar (numero):");
                    eleccion = sc.nextInt();
                    sc.nextLine();
                }
                pedido.addProducto(productos[eleccion - 1]);
            }
        } while (opc != 2);
        System.out.println("Saliendo...");
        // agregar pedido al cliente
        cliente.addPedido(pedido);
        return pedido;
    }
}