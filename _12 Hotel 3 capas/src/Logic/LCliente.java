package Logic;

import Domain.Cliente;

public class LCliente {
  Cliente cliente;

    public LCliente(String nombre, long telefono, String email) {
        cliente = new Cliente(nombre, telefono, email);
    }

    public Cliente getCliente(){
        return cliente;
    }

    public String getNombre() {
        return cliente.getNombre();
    }

    public long getTelefono() {

        return cliente.getTelefono();
    }

    public String getEmail() {

        return cliente.getEmail();
    }
}
