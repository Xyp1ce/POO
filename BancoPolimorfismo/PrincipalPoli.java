/* Ramon Manriquez Guerrero
 * 29/10/2025
 * Cuenta con polimorfismo practica 8
 */

import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

public class PrincipalPoli {

    public Random rnd = new Random();

    public static void main(String[] args){
        // Setear el interes para los prestamos
        CuentaPoli.setInteres(10.5f);
        PrincipalPoli p = new PrincipalPoli();
        p.menu();
    }

    public void menu() {
        int opc;
        SucursalPoli sucursal = new SucursalPoli("Zona Rio", 123);

        // Declaracion de variables a utilizar (se puede optimizar)
        ClientePoli cliente;
        CuentaPoli cuenta;

        String msgMenu = "Bienvenido a la sucursal de " + sucursal.getDireccion() + "\n" +
                "Elija una opcion:" + "\n" +
                "1. Agregar Cliente"+ "\n" +
                "2. Ver Clientes" + "\n" +
                "3. Agregar Cuenta" + "\n" +
                "4. Ver Cuentas Cliente" + "\n" +
                "5. Realizar transaccion" + "\n" +
                "6. Cambiar interes" + "\n" +
                "7. Ver Cuentas Sucursal" + "\n" +
                "8. Ver Movimientos" + "\n" +
                "9. Salir" + "\n";

        String msgTransaccion = "1. Deposito" + "\n" +
                                "2. Retiro" + "\n" +
                                "3. Transferencia" + "\n" +
                                "4. Prestamo" + "\n" +
                                "5. Cambiar de cuenta" + "\n" +
                                "6. Salir" + "\n";
        do {
            // Pedir y Validar dato
            opc = ValidacionPoli.validInt(msgMenu, 1, 9);
            switch(opc) {
                case 1: // agregar Clientes
                    if(sucursal.getCantidad() == 9) {
                        System.out.println("No es posible agregar mas clientes");
                    } else {
                        crearCliente(sucursal);
                    }
                    break;
                case 2: // ver Clientes
                    if(sucursal.getCantidad() > 0)
                        JOptionPane.showMessageDialog(null, sucursal.getClientes());
                    else
                        JOptionPane.showMessageDialog(null, "No hay clientes registrados...");
                    break;
                case 3: // Agregar Cuenta
                    cliente = buscarCliente(sucursal);
                    if(cliente != null) {
                        CuentaPoli account;
                        account = crearCuenta(sucursal);
                        //Agregamos la cuenta al cliente y a la sucursal
                        cliente.addAccount(account);
                        sucursal.addAccount(account);
                        //Relacionamos el cliente a la cuenta
                        account.setClient(cliente);
                    }
                    break;
                case 4: // Ver Cuentas Clientes
                    cliente = buscarCliente(sucursal);
                    if(cliente != null)
                        JOptionPane.showMessageDialog(null, cliente.verCuentas());
                    break;
                case 5: // Transaccion
                    if (sucursal.getCantidad() > 0) {
                        cliente = buscarCliente(sucursal);
                        if(cliente == null)
                            break;
                        cuenta = buscarCuenta(cliente);
                        if(cuenta == null)
                            break;
                        do { // Escoger opcion
                            opc = ValidacionPoli.validInt(msgTransaccion, 1 , 6);
                            switch(opc) {
                                case 1: // Deposito
                                    deposito(cuenta);
                                    break;
                                case 2: // Retiro
                                    retiro(cuenta);
                                    break;
                                case 3: // Transferencia
                                    // Tiene que haber mas de una cuenta registrada para hacer una transferencia
                                    if(sucursal.getCantidadCuentas() > 1) {
                                        ClientePoli clienteDest;
                                        clienteDest = buscarCliente(sucursal);
                                        if(clienteDest != null) {
                                            CuentaPoli cuentaDest;
                                            cuentaDest = buscarCuenta(clienteDest);
                                            if(cuentaDest != null) {
                                                transferencia(cuenta, cuentaDest);
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Operacion cancelada...");
                                                break;
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Operacion cancelada...");
                                            break;
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "No hay cuentas suficientes para hacer" +
                                                                            "una tranferencia");
                                    }
                                    break;
                                case 4: // Prestamo
                                    solicitarPrestamo(cuenta);
                                    break;
                                case 5: // Cambiar de cuenta
                                    CuentaPoli aux;
                                    aux = buscarCuenta(cliente);
                                    if(aux != null)
                                        cuenta = aux;
                                    break;
                                case 6: // Salir
                                    System.out.println("Cancelando...\n");
                                    break;
                                default:
                                    System.out.println("Opcion invalida...");
                                    break;
                            }
                        } while(opc != 6);
                    } else
                        JOptionPane.showMessageDialog(null, "No hay cuentas registradas en la sucursal");

                    break;
                case 6: // Cambiar interes
                    cambiarInteres();
                    break;
                case 7: // Ver cuentas sucursal
                    if(sucursal.getCantidadCuentas() > 0)
                        JOptionPane.showMessageDialog(null, sucursal.watchAccounts());
                    else
                        JOptionPane.showMessageDialog(null, "No hay cuentas registradas en la sucursal");
                    break;
                case 8: // Ver movimientos
                    if (sucursal.getCantidad() > 0) {
                        cliente = buscarCliente(sucursal);
                        if(cliente == null){
                            JOptionPane.showMessageDialog(null, "Cancelando...");
                            break;
                        }
                        cuenta = buscarCuenta(cliente);
                        if(cuenta == null){
                            JOptionPane.showMessageDialog(null, "Cancelando...");
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Movimientos de la cuenta " + cuenta.getMovimientos());
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay cuentas registradas en la sucursal");
                    }
                    break;
                case 9: // Salir
                    System.out.println("Finalizando programa...\n");
                    System.exit(0);
                default:
                    System.out.println("Opcion Invalida...\n");
                    break;
            }
        } while(true);
    }

    public void crearCliente(SucursalPoli sucursal) {
        // Pedir informacion del cliente
        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del cliente");
        String direccion = JOptionPane.showInputDialog(null, "Ingresa la direccion del cliente");
        // .addCliente crea un objeto tipo ClientePoli dentro de si y lo agrega a su arreglo de clientes
        sucursal.addCliente(nombre, direccion);
    }

    public CuentaPoli crearCuenta(SucursalPoli sucursal) {
        // Pedimos los datos de la cuenta
        String noCuentaS = JOptionPane.showInputDialog(null, "Ingresa el numero de cuenta");
        long noCuenta = Long.parseLong(noCuentaS);

        String claveS= JOptionPane.showInputDialog(null, "Ingresa su CLABE");
        long clave= Long.parseLong(claveS);

        String fechaVencimiento = JOptionPane.showInputDialog(null, "Ingresa la fecha de vencimiento (MM/AA)");

        String tipo = JOptionPane.showInputDialog(null, "Ingresa el tipo de la cuenta");

        // Creamos un objeto Cuenta
        CuentaPoli account = new CuentaPoli(noCuenta, clave, fechaVencimiento, tipo);
        // retornamos la cuenta para agregarla en el cliente
        return account;
    }

    public ClientePoli buscarCliente(SucursalPoli sucursal) {
        ClientePoli cliente;
        int opc = 2;
        do {
            String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del cliente");
            cliente = sucursal.buscarCliente(nombre);
            opc = 2;
            if(cliente == null){
                JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                String msg = "Continuar? [1] SI [2] NO";
                opc = ValidacionPoli.validInt(msg, 1, 2);
            }
        } while(opc == 1);
        if(cliente != null)
            return cliente;
        return null;
    }

    public CuentaPoli buscarCuenta(ClientePoli cliente) {
        CuentaPoli cuenta;
        int opc = 2;
        do { // Buscar la cuenta del cliente
            String msg = cliente.verCuentas();
            long noCuenta = ValidacionPoli.validLong(msg + "Ingresa el No. de Cuenta");
            cuenta = cliente.buscarCuenta(noCuenta);
            if(cuenta == null){
                JOptionPane.showMessageDialog(null, "Cuenta no encontrada");
                String msgContinuar = "Continuar? [1] SI [2] NO";
                opc = ValidacionPoli.validInt(msgContinuar, 1, 2);
            }
        } while(opc == 1);
        if(cuenta != null)
            return cuenta;
        return null;
    }

    public void deposito(CuentaPoli cuenta){
        float deposito = ValidacionPoli.validFloat("Ingresa la cantidad a depositar");
        // Generar la fecha actual
        LocalDate today = LocalDate.now();
        // Generar numero aleatorios para el folio y referencia
        long referencia = rnd.nextLong(10000);
        long folio = rnd.nextLong(1000);
        JOptionPane.showMessageDialog(null, "Saldo actual: " + cuenta.getSaldo());
        if(cuenta.depositar(deposito, "Deposito", referencia, deposito, today, folio) == 0) {
            JOptionPane.showMessageDialog(null, "Error, Deposito no exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo actualizado: " + cuenta.getSaldo());
        }
    }

    public void retiro(CuentaPoli cuenta) {
        float retiro = ValidacionPoli.validFloat("Ingresa la cantidad a retirar");
        LocalDate today = LocalDate.now();
        long referencia = rnd.nextLong(10000);
        long folio = rnd.nextLong(1000);
        JOptionPane.showMessageDialog(null, "Saldo actual: " + cuenta.getSaldo());
        if(cuenta.retirar(retiro, "Retiro", referencia, retiro, today, folio) == 0) {
            JOptionPane.showMessageDialog(null, "Error, Retiro no exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo actualizado: " + cuenta.getSaldo());
        }
    }

    public void transferencia(CuentaPoli cuentaOrig, CuentaPoli cuentaDest) {
        float monto = ValidacionPoli.validFloat("Ingresa la cantidad a transferir");
        LocalDate today = LocalDate.now();
        long referencia = rnd.nextLong(10000);
        long folio = rnd.nextLong(1000);
        JOptionPane.showMessageDialog(null, "Saldo actual: " + cuentaOrig.getSaldo());
        if(cuentaOrig.transferencia(referencia, monto, today, folio) == 0) {
            JOptionPane.showMessageDialog(null, "Error, Transferencia no exitosa");
        } else {
            JOptionPane.showMessageDialog(null, "Saldo actualizado: " + cuentaOrig.getSaldo());
            cuentaDest.recibirTransferencia(monto);
        }
    }

    public void cambiarInteres() {
        JOptionPane.showMessageDialog(null, "Interes actual: " + CuentaPoli.getInteres());
        float interes = ValidacionPoli.validFloat("Ingresa el nuevo interes");
        CuentaPoli.setInteres(interes);
        JOptionPane.showMessageDialog(null, "Interes actualizado: " + CuentaPoli.getInteres());
    }

    public void solicitarPrestamo(CuentaPoli cuenta) {
        float cantidad = ValidacionPoli.validFloat("Ingresa la cantidad del préstamo");
        LocalDate today = LocalDate.now();
        long folio = rnd.nextLong(1000);
        
        JOptionPane.showMessageDialog(null, "Saldo actual: " + cuenta.getSaldo());
        float intereses = cuenta.solicitarPrestamo(cantidad, today, folio);
        
        if (intereses == 0) {
            JOptionPane.showMessageDialog(null, "Error, Préstamo no exitoso");
        } else {
            JOptionPane.showMessageDialog(null, 
                "Préstamo exitoso\n" +
                "Cantidad prestada: " + cantidad + "\n" +
                "Intereses: " + intereses + "\n" +
                "Total a pagar: " + (cantidad + intereses) + "\n" +
                "Saldo actualizado: " + cuenta.getSaldo());
        }
    }
}
