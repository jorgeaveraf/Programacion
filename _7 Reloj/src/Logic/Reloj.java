package Logic;

public class Reloj {
Hora hora;
Display display;

    public Reloj(Hora hora, String tipo) {
        this.hora = hora;
        this.display = new Display(tipo);
    }

    public String Start(){
        String hora1 = hora.getHoras()+":"+hora.getMinutos()+":"+hora.getSegundos();
        return hora1;
    }

}
