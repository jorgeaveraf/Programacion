package Domain;

public class Agenda {
    private Contacto contactos [];
    private int contador;
    private int almacenamiento = 30;

    public Agenda() {
        contactos = new Contacto[almacenamiento];
        contador=0;
    }

    public void mostrarContactos() {
        for (int i = 0; i < contador; i++) {
            Contacto contacto = contactos[i];
            System.out.println(contacto.getNombre()+ contacto.getTelefono()+ contacto.getEmail()+ contacto.getBirthday());
        }
    }

    public void addContact(Contacto contacto){
        if(contador<almacenamiento){
            contactos[contador]=contacto;
            contador++;
        }
    }
    public Contacto[] getContactos() {
        return contactos;
    }


    public Contacto buscarContactoPorTelefono(long telefono) {
        for (int i = 0; i < contador; i++) {
            if (contactos[i].getTelefono() == telefono) {
                return contactos[i];
            }
        }
        return null;
    }

    public int getContador() {
        return contador;
    }
}
