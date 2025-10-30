import java.util.Scanner;

public class Principal {
    public Scanner sc = new Scanner(System.in);
    // Almacen de prodctos
    // Almacen almacen = new Almacen();

    public static void main(String[] args) {
        PrincipalPoli p = new PrincipalPoli();
        p.menu();
    }

    public void menu() {
        int opc = 0;
        ClientePoli cliente = null;
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
                    cliente = new ClientePoli(nombre, direccion);
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
                    "[1] Agregar producto   [2] Modificar producto   [3] Modificar IVA   [4] Salir\n");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: // Agregar producto
                    agregarProducto();
                    break;
                case 2: // Modificar producto
                    modificarProducto();
                    break;
                case 3: // Modificar IVA
                    modificarIVA();
                    break;
                case 4: // Salir
                    System.out.println("Saliendo del modo administrador...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 4);
    }

    public void cliente(ClientePoli cliente) {
        int opc;
        do {
            System.out.println("\nBienvenido " + cliente.getNombre() + "!!\n");
            System.out.println("[1] Realizar Pedido   [2] Ver pedidos   [3] Salir");
            opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1: // Realizar pedido
                    Pedido p = pedido(cliente);
                    if (p != null) {
                        System.out.println("Pedido creado: " + p);
                    }
                    break;
                case 2: // Ver pedidos
                    if(cliente.verPedidos() == 0) {
                        System.out.println("No hay pedidos\n");
                    }
                    break;
                case 3: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 3);
    }

    public void agregarProducto() {
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
        if(Almacen.addProducto(nombre, precio, tipo) == 1) 
            System.out.println("Producto agregado exitosamente\n\n");
        else
            System.out.println("No se pudo agregar el producto. Almacen lleno\n\n");
    }

    // Metodo para modificar el producto que el administrador quiera
    public void modificarProducto() {
        int opc;
        String nombre;
        String tipo;
        double precio;
        
        Almacen.verProductos();
        System.out.println("Ingresa el nombre del producto a modificar");
        nombre = sc.nextLine();
        Producto producto = Almacen.buscarProducto(nombre);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        do {
            System.out.println("\nQue quieres modificar del producto " + producto.getNombre() + "\n" +
                    "[1] Nombre  [2] Precio  [3] Tipo  [4] Ver informacion  [5] Cancelar");
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
                case 4: // Ver informacion 
                    System.out.println("\n" + producto + "\n");
                    break;
                case 5: // Cancelar
                    System.out.println("Cancelando...");
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    break;
            }
        } while (opc != 5);
    }

    public void modificarIVA() {
        float nuevoIVA;
        System.out.println("Ingresa el nuevo valor de IVA ");
        nuevoIVA = sc.nextFloat();
        sc.nextLine();
        Pedido.setIVA(nuevoIVA);
        System.out.println("IVA actualizado a: " + Pedido.getIVA());
    }

    // metodo para realizar un pedido y agregarlo al cliente
    public Pedido pedido(ClientePoli cliente) {
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
                Almacen.verProductos();
                System.out.println("Que producto desea agregar (numero):");
                eleccion = sc.nextInt();
                sc.nextLine();
                while (eleccion > Almacen.getCantidad() || eleccion < 1) {
                    System.out.println("Opcion invalida");
                    Almacen.verProductos();
                    System.out.println("Que producto desea agregar (numero):");
                    eleccion = sc.nextInt();
                    sc.nextLine();
                }
                if(pedido.addProducto(Almacen.buscarProducto(eleccion)) == 1)
                    System.out.println("Producto agregado\n");
                else 
                    System.out.println("No se pudo agregar el producto\n");
            }
        } while (opc != 2);
        System.out.println("Saliendo...");
        // Agregamos el pedido al cliente (guardamos el objeto con sus productos)
        cliente.addPedido(pedido);
        return pedido;
    }
}