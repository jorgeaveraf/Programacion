package Domain;

public class Reservaciones {
    Reservacion reservaciones [];
    private int contador;
    private int almacenamiento = 30;

    public Reservaciones() {
        reservaciones = new Reservacion[almacenamiento];
        contador=0;
    }

    public void mostrarReservaciones() {
        for (int i = 0; i < contador; i++) {
            Reservacion reservacion = reservaciones[i];
            System.out.println(reservacion.getnReservacion() + ", " +
                    reservacion.getCliente() + ", " +
                    reservacion.getHabitacion() + ", " +
                    reservacion.getFecha() + ", " +
                    reservacion.getDiasR()
            );
        }
    }

    public void addReservacion(Reservacion reservacion){
        if(contador<almacenamiento){
            reservaciones[contador]= reservacion;
            contador++;
        }
    }
    public Reservacion[] getReservaciones() {
        return reservaciones;
    }


    public Reservacion buscarReservacionPorNumero(int numero) {
        for (int i = 0; i < contador; i++) {
            if (reservaciones[i].getnReservacion() == numero) {
                return reservaciones[i];
            }
        }
        return null;
    }

    public int getContador() {
        return contador;
    }

}
