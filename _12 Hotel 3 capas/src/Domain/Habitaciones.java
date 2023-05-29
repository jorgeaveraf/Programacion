package Domain;

public class Habitaciones {
    Habitacion habitaciones [];
    private int contador;
    private int almacenamiento = 30;

    public Habitaciones() {
        habitaciones = new Habitacion[almacenamiento];
        contador=0;
    }

    public void mostrarHabitaciones() {
        for (int i = 0; i < contador; i++) {
            Habitacion habitacion = habitaciones[i];
            System.out.println(habitacion.getNumeroH()+ habitacion.getTipo()+ habitacion.getPrecio()+ habitacion.isDisponible());
        }
    }

    public void addHabitacion(Habitacion habitacion){
        if(contador<almacenamiento){
            habitaciones[contador]=habitacion;
            contador++;
        }
    }
    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }


    public Habitacion buscarPorNumero(int numero) {
        for (int i = 0; i < contador; i++) {
            if (habitaciones[i].getNumeroH() == numero) {
                return habitaciones[i];
            }
        }
        return null;
    }
}
