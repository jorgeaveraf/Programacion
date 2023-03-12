import javax.swing.*;

public class Empleado {
    //Atributos
    private int id;
    private String nombre;
    private String apellidos;
    private int edad;
    private char categoria;
    private String tipo_Contratacion;
    private int horas_Trabajadas;

    //Constructores
    public Empleado() {
        this.id = 100;
        this.nombre = "Nuevo empleado";
        this.apellidos = "Nuevo empleado";
        this.edad = 18;
        this.categoria = 'A';
        this.tipo_Contratacion = "Eventual";
        this.horas_Trabajadas = 0;
    }

    public Empleado(int id, String nombre, String apellidos, int edad, char categoria, String tipo_Contratacion, int horas_Trabajadas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.categoria = categoria;
        this.tipo_Contratacion = tipo_Contratacion;
        this.horas_Trabajadas = horas_Trabajadas;
    }
    //Métodos
    /*Incremente la edad del empleado*/
    public void cumpleaños(){
        edad++;
        reCategorizar();
    }
    /*Categoriza*/
    private void reCategorizar(){
        if (tipo_Contratacion.equals("Eventual")) {
            if (edad >= 18 && edad <= 23) {
                categoria = 'A';
            } else if (edad > 23) {
                categoria = 'C';
            }
        } else if (tipo_Contratacion.equals("Base")) {
            if (edad >= 18 && edad <= 23) {
                categoria = 'B';
            } else if (edad > 23) {
                categoria = 'D';
            }
        }
    }
    /*Calcula el salario*/
    public double salario(){
        double salario = horas_Trabajadas*120;
        if (horas_Trabajadas > 8) {
            salario += (horas_Trabajadas - 8) * 120;
        }
        switch (categoria) {
            case 'A':
                salario += 1000;
                break;
            case 'B':
                salario += 1200;
                break;
            case 'C':
                salario += 1500;
                break;
            case 'D':
                salario += 1800;
                break;
        }
        return salario;
        }

        /*Imprimir atributos*/
    public void Imprimir(){
        JOptionPane.showMessageDialog(null,"Los datos del empleado son:"+"\nID - "+id+"\nNombre - "+nombre+" "+apellidos+"\nEdad - "+edad
                +"\nCategoría - "+categoria+"\nTipo de contratación - "+tipo_Contratacion+"\nHoras trabajadas - "+horas_Trabajadas+"\nSalario - $"+salario());
    }

        //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public String getTipo_Contratacion() {
        return tipo_Contratacion;
    }

    public void setTipo_Contratacion(String tipo_Contratacion) {
        this.tipo_Contratacion = tipo_Contratacion;
    }

    public int getHoras_Trabajadas() {
        return horas_Trabajadas;
    }

    public void setHoras_Trabajadas(int horas_Trabajadas) {
        this.horas_Trabajadas = horas_Trabajadas;
    }
}

