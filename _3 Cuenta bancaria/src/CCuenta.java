import javax.swing.*;

public class CCuenta {
    /*Variables globales*/

    String Nombre; // nombre del cliente del banco al que pertenece la cuenta
    int Cuenta; //: número de cuenta
    double Saldo = 0; // saldo actual de la cuenta
    double Tipo_De_Interes; // tipo de interés %

    /*Las acciones(Metodos) que se pueden hacer para una cuenta de un cliente de un determinado banco son:

&    Asignar el nombre de un cliente del banco a una cuenta. ☺

&    Obtener el nombre del cliente de una cuenta ☺

&    Asignar el numero de cuenta ☺

&    Obtener el numero de cuenta ☺

&    Realizar un ingreso ☺

&    Realizar un reintegro(retiro) ☺

&    Asignar el tipo de interés ☺

&    Obtener el tipo de interés ☺

&    Obtener el saldo, esto es, el estado de la cuenta. ☺
*/
    public void A_Nombre() {
        Nombre = String.valueOf(JOptionPane.showInputDialog("¿Cuál es el nombre del cliente a asignar?"));
    }

    public void O_Nombre() {
        JOptionPane.showMessageDialog(null, "El nombre del cliente es " + Nombre);
    }

    public void A_Cuenta() {
        Cuenta = Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es el número de cuenta a asignar?"));
    }

    public void O_Cuenta() {
        JOptionPane.showMessageDialog(null, "El número de la cuenta del cliente es " + Cuenta);
    }

    public void A_Interes() {
        Tipo_De_Interes = Double.parseDouble(JOptionPane.showInputDialog("¿Cuál es el interés?"));
    }

    public void O_Interes() {
        JOptionPane.showMessageDialog(null, "El interés de la cuenta del cliente es " + Tipo_De_Interes+ "%");
    }

    public void Ingreso() {
        Saldo += Double.parseDouble(JOptionPane.showInputDialog("¿Cuál es el ingreso a realizar?"));
    }

    public void Retiro() {
        Saldo -= Double.parseDouble(JOptionPane.showInputDialog("¿Cuál es el retiro a realizar?"));
    }

    public void Saldo() {
        JOptionPane.showMessageDialog(null, "El saldo de la cuenta del cliente es " + Saldo);
    }
}
