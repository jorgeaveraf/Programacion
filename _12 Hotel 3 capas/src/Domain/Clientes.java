package Domain;

public class Clientes {
    Cliente clientes[];
    private int contador;
    private int almacenamiento = 30;

    public Clientes() {
        clientes = new Cliente[almacenamiento];
        contador=0;
    }

    public void mostrarClientes() {
        for (int i = 0; i < contador; i++) {
            Cliente cliente = clientes[i];
            System.out.println(cliente.getNombre()+ cliente.getTelefono()+ cliente.getEmail());
        }
    }

    public void addCliente(Cliente cliente){
        if(contador<almacenamiento){
            clientes[contador]=cliente;
            contador++;
        }
    }
    public Cliente[] getClientes() {
        return clientes;
    }


    public Cliente buscarClientePorTelefono(long telefono) {
        for (int i = 0; i < contador; i++) {
            if (clientes[i].getTelefono() == telefono) {
                return clientes[i];
            }
        }
        return null;
    }

    public int getPosition(){
        return contador;
    }
}
