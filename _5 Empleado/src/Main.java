import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Uso del primer constructor
        Empleado empleado1 = new Empleado();
        JOptionPane.showMessageDialog(null,"Empleado 1");
        empleado1.Imprimir();

        //2do constructor
        /*Empleado de base que tenga 40 años y que trabajo 12 horas*/
        Empleado empleado2 = new Empleado(101, "Enrique", "Marquez", 30, 'B', "Base", 12);
        JOptionPane.showMessageDialog(null,"Empleado 2");
        empleado2.Imprimir();

        /*Salario del empleado 2*/
        double salarioEmpleado2 = empleado2.salario();
        JOptionPane.showMessageDialog(null,"Salario de empleado 2: $" + salarioEmpleado2);

        /*Empleado Eventual que tenga 22 años y que trabajo 8 horas*/
        Empleado empleado3 = new Empleado(102, "Nat", "Dominguez", 22, 'A', "Eventual", 8);
        JOptionPane.showMessageDialog(null,"Empleado 3");
        empleado3.Imprimir();

        /*Salario del empleado 3*/
        double salarioEmpleado3 = empleado3.salario();
        JOptionPane.showMessageDialog(null,"Salario de empleado 3: $" + salarioEmpleado3);

        /*Empleado Eventual que tenga 22 años y que trabajo 8 horas*/
        Empleado empleado4 = new Empleado(103, "Jorge", "Vera", 23, 'A', "Eventual", 8);
        JOptionPane.showMessageDialog(null,"Empleado 4");
        empleado4.Imprimir();

        /*Incrementar la edad del empleado 4 y recalcular la categoría*/
        empleado4.cumpleaños();
        JOptionPane.showMessageDialog(null,"Empleado 4 después de cumplir años");
        empleado4.Imprimir();
    }
}