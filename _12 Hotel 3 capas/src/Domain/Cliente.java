package Domain;

public class Cliente {
    private String Nombre;
    private long telefono;
    private String email;

    public Cliente(String nombre, long telefono, String email) {
        Nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

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
}
