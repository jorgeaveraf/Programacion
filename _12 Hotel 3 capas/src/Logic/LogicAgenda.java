package Logic;

import Domain.Agenda;
import Domain.Contacto;

import java.time.LocalDate;

public class LogicAgenda {
    private Agenda agenda;
    private static LogicAgenda instance;

    public LogicAgenda() {
        agenda = new Agenda();
    }

    public static LogicAgenda getInstance() {
        if (instance == null) {
            instance = new LogicAgenda();
        }
        return instance;
    }

    public void addContact(LogicContacto logicContacto) {
        agenda.addContact(logicContacto.getContacto());
    }

    public void mostrarContactos(){
        agenda.mostrarContactos();
    }

    public Contacto[] getContactos() {
        return agenda.getContactos();
    }

    public LogicContacto buscarContactoPorTelefono(long telefono) {
        Contacto[] contactos = getContactos();
        for (Contacto contacto : contactos) {
            if (contacto != null && contacto.getTelefono() == telefono) {
                LogicContacto logicContacto = new LogicContacto(contacto.getNombre(), contacto.getTelefono(), contacto.getEmail(), contacto.getBirthday());
                return logicContacto;
            }
        }
        return null;
    }

    public int index(long telefono) {
        Contacto[] contactos = getContactos();
        for (int i = 0; i < contactos.length; i++) {
            Contacto contacto = contactos[i];
            if (contacto != null && contacto.getTelefono() == telefono) {
                return i;
            }
        }
        return -1;
    }
    public void setName(int index, String nuevoNombre) {
        if (index != -1) {
            Contacto[] contactos = getContactos();
            contactos[index].setNombre(nuevoNombre);
        }
    }

    public void setTelefono(int index, Long nuevoTel) {
        if (index != -1) {
            Contacto[] contactos = getContactos();
            contactos[index].setTelefono(nuevoTel);
        }
    }

    public void setEmail(int index, String nuevoMail) {
        if (index != -1) {
            Contacto[] contactos = getContactos();
            contactos[index].setEmail(nuevoMail);
        }
    }

    public void setCumple(int index, LocalDate nuevoCumple) {
        if (index != -1) {
            Contacto[] contactos = getContactos();
            contactos[index].setBirthday(nuevoCumple);
        }
    }

    public void setContacto(int index) {
        if (index != -1) {
            Contacto[] contactos = getContactos();
            contactos[index]=null;
        }
    }
}



