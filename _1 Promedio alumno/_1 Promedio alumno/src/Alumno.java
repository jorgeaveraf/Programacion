import javax.swing.*;
import java.util.Scanner;

public class Alumno {
    // Atributos
    String Nombre;
    Integer Promedio;
    int EE;


    /* Métodos*/
//Pedir datos
public void Pedir_Datos(){
Nombre = String.valueOf(JOptionPane.showInputDialog("¿Cuál es tu nombre?"));
EE = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas experiencias educativas cursaste?"));
}
    //Calcular el promedio
public void Calificaciones(){
    int i=0;
    int j=0;
    while(i < EE){
        i++;
        j+=Integer.parseInt(JOptionPane.showInputDialog("¿Cuál es la calificación de la experiencia educativa "+i+"?"));
    }
    Promedio=j/i;
}
    //Decir el promedio
public void Enunciar(){
JOptionPane.showMessageDialog(null,Nombre+" el promedio de tus "+EE+" experiencias educativas es "+ Promedio.doubleValue());
}

}
