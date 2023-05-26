package Domain;
import Logic.Ccuenta;
import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {

    private static Database instance = null;
    public ArrayList<Ccuenta> cuentas;

    private Database() {
        cuentas = new ArrayList<Ccuenta>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void agregarCuenta(Ccuenta cuenta) {
        cuentas.add(cuenta);
    }

    public ArrayList<Ccuenta> getCuentas() {
        return cuentas;
    }

    public void guardarDatos() {
        try {
            FileOutputStream fileOut = new FileOutputStream("datos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cuentas);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void cargarDatos() {
        try {
            FileInputStream fileIn = new FileInputStream("datos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cuentas = (ArrayList<Ccuenta>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}
