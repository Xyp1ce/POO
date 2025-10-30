import java.util.Scanner;
import javax.swing.JOptionPane;

public class ValidacionPoli {
    private static int valorInt;

    public static int validInt(String mensaje, int min, int max) {
        int valorInt = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String valor = JOptionPane.showInputDialog(null, mensaje);

                // Si el usuario cancela o cierra el diálogo
                if (valor == null) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                    System.exit(0);
                }

                valorInt = Integer.parseInt(valor);

                if (valorInt >= min && valorInt <= max) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe ser un número entre " + min + " y " + max);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        }
        return valorInt;
    }

    public static float validFloat(String msg) {
        boolean valid = false;
        float valorFloat = 0;
        while(!valid) {
            try {
                String valor = JOptionPane.showInputDialog(null, msg);
                valorFloat = Float.parseFloat(valor);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        }
        return valorFloat;
    }

    public static long validLong(String msg) {
        boolean valid = false;
        long valorLong = 0;
        while(!valid) {
            try {
                String valor = JOptionPane.showInputDialog(null, msg);
                valorLong = Long.parseLong(valor);
                valid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido.");
            }
        }
        return valorLong;
    }
}
