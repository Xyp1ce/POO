/* Ramon Manriquez Guerrero
 * 15/09/2025
 * Empleado junto con Cuenta y Banco
 */

import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class PrincipalPoli {
    public Random rnd = new Random();
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        CuentaPoli.setInteres(10.5f);
        PrincipalPoli p = new PrincipalPoli();
        p.menu();
    }

    public void menu() {
        int opc;
        SucursalPoli sucursal = new SucursalPoli("Zona Rio", 123);
        ClientePoli cliente;
        String nombre;
        CuentaPoli cuenta;
        do {
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Ver Clientes");
            System.out.println("3. Agregar Cuenta");
            System.out.println("4. Ver Cuentas Cliente");
            System.out.println("5. Realizar transaccion");
            System.out.println("6. Cambiar interes");
            System.out.println("7. Ver Cuentas Sucursal");
            System.out.println("8. Ver Movimientos");
            System.out.println("9. Salir");
            opc = ValidacionPoli.validInt("Ingresa una opcion: ");
            switch(opc) {
                case 1: // agregar Clientes
                    if(sucursal.getCantidad() == 9) {
                        System.out.println("No es posible agregar mas clientes");
                    } else {
                        crearCliente(sucursal);
                    }
                    break;
                case 2: // ver Clientes
                    sucursal.getClientes();
                    break;
                case 3: // Agregar Cuenta
                    crearCuenta(sucursal);
                    break;
                case 4: // Ver Cuentas Clientes
                    cliente = buscarCliente(sucursal);
                    cliente.verCuentas();
                    break;
                case 5: // Transaccion
                    cliente = buscarCliente(sucursal);
                    if(cliente == null) {
                        System.out.println("Cancelando...\n");
                        break;
                    }
                    System.out.println("Cliente encontrado");
                    cuenta = buscarCuenta(cliente);
                    if(cuenta == null) {
                        System.out.println("Cancelando...\n");
                        break;
                    }
                    System.out.println("Cuenta encontrada");
                    do { // Escoger opcion
                        System.out.println("1. Deposito");
                        System.out.println("2. Retiro");
                        System.out.println("3. Seleccionar Cuenta");
                        System.out.println("4. Cancelar");
                        opc = ValidacionPoli.validInt("Ingresa una opcion: ");
                        sc.nextLine();
                        switch(opc) {
                            case 1: // Deposito
                                deposito(cuenta);
                                break;
                            case 2: // Retiro
                                retiro(cuenta);
                                break;
                            case 3: // Seleccionar cuentas
                                CuentaPoli aux;
                                aux = buscarCuenta(cliente);
                                if(aux != null)
                                    cuenta = aux;
                                break;
                            case 4: // Cancelar
                                System.out.println("Cancelando...\n");
                                break;
                            default:
                                System.out.println("Opcion invalida...");
                                break;
                        }
                    } while(opc != 4);
                    break;
                case 6: // Cambiar interes
                    cambiarInteres();
                    break;
                case 7: // Ver cuentas sucursal
                    sucursal.watchAccounts();
                    break;
                case 8: // Ver movimientos
                    cliente = buscarCliente(sucursal);
                    if(cliente == null){
                        System.out.println("Cancelando...");
                        break;
                    }
                    cuenta = buscarCuenta(cliente);
                    if(cuenta == null){
                        System.out.println("Cancelando...");
                        break;
                    }
                    System.out.println("Movimientos de la cuenta\n" + cuenta.getMovimientos());
                    break;
                case 9: // Salir
                    System.out.println("Finalizando programa...\n");
                    break;
                default:
                    System.out.println("Opcion Invalida...\n");
                    break;
            }
        } while(opc != 8);
    }

    public SucursalPoli crearSucursal() {
        System.out.println("Ingresa el numero de la sucursal");
        int noSucursal = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresa la direccion de la sucursal");
        String direccion = sc.nextLine();
        return new SucursalPoli(direccion, noSucursal);
    }

    public void crearCliente(SucursalPoli sucursal) {
        System.out.println("Ingresa el nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Ingresa la direccion del cliente");
        String direccion = sc.nextLine();
        sucursal.addCliente(nombre, direccion);
    }

    public void crearCuenta(SucursalPoli sucursal) {
        ClientePoli cliente = buscarCliente(sucursal);
        if(cliente != null) { // Si existe el cliente
            System.out.println("\nCliente encontrado");
            System.out.println("Ingresa el numero de cuenta");
            long noCuenta = sc.nextLong();
            sc.nextLine();
            System.out.println("Ingresa su CLABE");
            long clave = sc.nextLong();
            sc.nextLine();
            System.out.println("Ingresa la fecha de vencimiento (MM/AA)");
            String fechaVencimiento = sc.nextLine();
            System.out.println("Ingresa el tipo de la cuenta");
            String tipo = sc.nextLine();

            // Creamos un objeto Cuenta
            CuentaPoli account = new CuentaPoli(noCuenta, clave, fechaVencimiento, tipo);
            // Agregamos la cuenta al cliente y a la sucursal
            cliente.addAccount(account);
            sucursal.addAccount(account);
            // Relacionamos el cliente a la cuenta
            account.setClient(cliente);

        } else {
            System.out.println("No se encontro ningun cliente con ese nombre");
        }
    }

    public ClientePoli buscarCliente(SucursalPoli sucursal) {
        ClientePoli cliente;
        int opc = 2;
        do {
            System.out.println("Ingresa el nombre del Cliente");
            String nombre = sc.nextLine();
            cliente = sucursal.buscarCliente(nombre);
            if(cliente == null){
                System.out.println("Cliente no encontrado");
                System.out.println("Quiere continuar? [1] Si [2] No");
                opc = sc.nextInt();
                sc.nextLine();
            }
        } while(opc == 1);
        if(opc == 2 && cliente != null)
            return cliente;
        else
            return null;
    }

    public CuentaPoli buscarCuenta(ClientePoli cliente) {
        CuentaPoli cuenta;
        int opc = 2;
        do { // Buscar la cuenta del cliente
            cliente.verCuentas();
            System.out.println("Ingresa el No. de Cuenta");
            long noCuenta = sc.nextLong();
            sc.nextLine();
            cuenta = cliente.buscarCuenta(noCuenta);
            if(cuenta == null){
                System.out.println("Cuenta no encontrada");
                System.out.println("Quiere continuar? [1] Si [2] No");
                opc = sc.nextInt();
                sc.nextLine();
            }
        } while(opc == 1);
        if(cuenta != null)
            return cuenta;
        else
            return null;
    }

    public void deposito(CuentaPoli cuenta){
        System.out.println("Ingresa la cantidad a depositar");
        float deposito = sc.nextFloat();
        sc.nextLine();
        LocalDate today = LocalDate.now();
        long referencia = rnd.nextLong(10000);
        long folio = rnd.nextLong(1000);
        System.out.println("Saldo actual: " + cuenta.getSaldo());
        if(cuenta.depositar(deposito, "Deposito", referencia, deposito, today, folio) == 0) {
            System.out.println("Error. Deposito no exitoso");
        } else {
            System.out.println("Saldo actualizado: " + cuenta.getSaldo());
        }
    }

    public void retiro(CuentaPoli cuenta) {
        System.out.println("Ingresa la cantidad a retirar");
        float retiro = sc.nextFloat();
        sc.nextLine();
        LocalDate today = LocalDate.now();
        long referencia = rnd.nextLong(10000);
        long folio = rnd.nextLong(1000);
        System.out.println("Saldo actual: " + cuenta.getSaldo());
        if(cuenta.retirar(retiro, "Retiro", referencia, retiro, today, folio) == 0) {
            System.out.println("Error. Retiro no exitoso");
        } else {
            System.out.println("Saldo actualizado: " + cuenta.getSaldo());
        }
    }

    public void cambiarInteres() {
        System.out.println("Interes actual: " + CuentaPoli.getInteres());
        System.out.println("Ingrese el nuevo interes: ");
        float interes = sc.nextFloat();
        sc.nextLine();
        CuentaPoli.setInteres(interes);
        System.out.println("Interes actualizado: " + CuentaPoli.getInteres());
    }
}
