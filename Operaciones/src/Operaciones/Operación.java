package Operaciones;

import javax.swing.*;

public class Operación {
    //Atributos
    int Num1;
    int Num2;
    int Suma;
    int Resta;
    int Multiplicacion;
    int Division;

    //Métodos

    /*Para pedirle al usuario los datos*/
public void Pedir_Numeros() {
    Num1 = Integer.parseInt(JOptionPane.showInputDialog("Digita un número"));
    Num2 = Integer.parseInt(JOptionPane.showInputDialog("Digita otro número"));
}
/*Suma*/
public void Sumar(){
    Suma=Num1+Num2;
    }

/*Resta*/
    public void Restar(){
        Resta=Num1-Num2;
    }

    /*Multiplica*/
    public void Multiplicar(){
        Multiplicacion=Num1*Num2;
    }

    /*Divide*/
    public void Dividir(){
        Division=Num1/Num2;
    }

    /*Muestra los resultados*/
    public void Resultados(){
        System.out.println("El resultado de la suma es "+Suma);
        System.out.println("El resultado de la resta es "+Resta);
        System.out.println("El resultado de la multipliación es "+Multiplicacion);
        System.out.println("El resultado de la divisón es "+Division);
    }
}
