package Logic;

import java.io.Serializable;

public class Ccuenta implements Serializable {
   private String Nombre; // nombre del cliente del banco al que pertenece la cuenta
    private int Cuenta; //: número de cuenta
    private double Saldo; // saldo actual de la cuenta
    private double Tipo_De_Interes; // tipo de interés %

    //Constructor


    public Ccuenta(String nombre, int cuenta, double saldo, double tipo_De_Interes) {
        Nombre = nombre;
        Cuenta = cuenta;
        Saldo = saldo;
        Tipo_De_Interes = tipo_De_Interes;
    }

    //Setters y Getters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCuenta() {
        return Cuenta;
    }

    public void setCuenta(int cuenta) {
        Cuenta = cuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public double getTipo_De_Interes() {
        return Tipo_De_Interes;
    }

    public void setTipo_De_Interes(double tipo_De_Interes) {
        Tipo_De_Interes = tipo_De_Interes;
    }

    //Métodos
    public void Ingreso(double i) {
        Saldo += i;
    }

    public void Retiro(double i) {
        Saldo -= i;
    }

}
