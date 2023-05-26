package Domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Contactos implements Serializable {
   private String Nombre; // nombre del cliente del banco al que pertenece la cuenta
    private long telefono; //: número de cuenta
    private String email; // saldo actual de la cuenta
    private LocalDate birthday;

    //Constructor


    public Contactos(String nombre, long telefono, String email, LocalDate birthday) {
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
}
