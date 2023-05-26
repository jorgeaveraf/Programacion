package Logic;

import java.time.LocalDate;

public class Contacto {
    private String Nombre;
    private long telefono;
    private String email;
    private LocalDate birthday;

    //Constructor


    public Contacto(String nombre, long telefono, String email, LocalDate birthday) {
        Nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.birthday = birthday;
    }

    //Setters y Getters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    /*
    String nombre = cName.getText();
                    String sCellphone = cCellphone.getText();
                    String sBalance = cBalance.getText();
                    String sInterest = cInterest.getText();
                    int cellphone = Integer.parseInt(sCellphone);
                    double saldo = Double.parseDouble(sBalance);
                    double interes = Double.parseDouble(sInterest);

                    // Crear un nuevo objeto Ccuenta con los datos ingresados
                    Contactos cuentaNueva = new Contactos(nombre, cellphone, saldo, interes);

                    // Agregar la cuenta al ArrayList en la clase Database
                    Agenda.getInstance().agregarCuenta(cuentaNueva);
     */
}
