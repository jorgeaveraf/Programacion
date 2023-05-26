package Logic;

import Domain.Contacto;

import java.time.LocalDate;

public class LogicContacto {
    private Contacto contacto;

    public LogicContacto(String nombre, long telefono, String email, LocalDate birthday) {
        contacto = new Contacto(nombre, telefono, email, birthday);

    }

    public Contacto getContacto() {
        return contacto;
    }

    public String getNombre() {

        return contacto.getNombre();
    }
    public void setNombre(String nombre) {
        contacto.setNombre(nombre);
    }
    public long getTelefono() {
        return contacto.getTelefono();
    }
    public void setTelefono(long telefono) {
        contacto.setTelefono(telefono);
    }

    public String getEmail(){
        return contacto.getEmail();
    }
    public void setEmail(String email) {
        contacto.setEmail(email);
    }

    public LocalDate getBirthday() {
        return contacto.getBirthday();
    }

    public void setBirthday(LocalDate birthday) {
        contacto.setBirthday(birthday);
    }

}
