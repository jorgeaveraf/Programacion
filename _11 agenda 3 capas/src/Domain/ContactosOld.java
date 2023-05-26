package Domain;

import java.io.Serializable;
import java.time.LocalDate;

public class ContactosOld implements Serializable {
   private String Nombre;
    private long telefono;
    private String email;
    private LocalDate birthday;

    //Constructor


    public ContactosOld(String nombre, long telefono, String email, LocalDate birthday) {
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
