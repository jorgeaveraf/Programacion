package Logic;

import Domain.Cliente;
import Domain.Clientes;
import Domain.Contacto;

import javax.swing.table.DefaultTableModel;


public class LClientes {
    private Clientes clientes;
    private static LClientes instance;

    public LClientes() {
        clientes = new Clientes();
    }

    public static LClientes getInstance() {
        if (instance == null) {
            instance = new LClientes();
        }
        return instance;
    }


    public void mostrarClientes() {
        clientes.mostrarClientes();
    }

    public void addCliente(LCliente lCliente) {
        clientes.addCliente(lCliente.getCliente());
    }

    public Cliente[] getClientes() {
        return clientes.getClientes();
    }

    public void clienteTable(DefaultTableModel model) {
        Cliente[] clients1 = getClientes();
        for (Cliente cliente1 : clients1) {
            if (cliente1 != null) {
                Object[] rowData = {cliente1.getNombre(), cliente1.getTelefono(), cliente1.getEmail()};
                model.addRow(rowData);
            }
        }
    }

    public LCliente buscarClientePorTelefono(long telefono) {
        Cliente[] clients = getClientes();
        for (Cliente cliente : clients) {
            if (cliente != null && cliente.getTelefono() == telefono) {
                LCliente lCliente = new LCliente(cliente.getNombre(), cliente.getTelefono(), cliente.getEmail());
                return lCliente;
            }
        }
        return null;
    }

    public int index(long nTel) {
        Cliente[] clients = getClientes();
        for (int i = 0; i < clients.length; i++) {
            Cliente cliente = clients[i];
            if (cliente != null && cliente.getTelefono() == nTel) {
                return i;
            }
        }
        return -1;
    }

    public void setName(int index, String nuevoNombre) {
        if (index != -1) {
            Cliente[] clients = getClientes();
            clients[index].setNombre(nuevoNombre);
        }
    }

    public void setTelefono(int index, Long nuevoTel) {
        if (index != -1) {
            Cliente[] clients = getClientes();
            clients[index].setTelefono(nuevoTel);
        }
    }

    public void setEmail(int index, String nuevoMail) {
        if (index != -1) {
            Cliente[] clients = getClientes();
            clients[index].setEmail(nuevoMail);
        }
    }

    public void setCNull(int index) {
        if (index != -1) {
            Cliente[] clients = getClientes();
            clients[index] = null;
        }
    }
}
