package Logic;

public class Display {
    private String tipo;

    public Display(String tipo) {
        this.tipo = tipo;
    }

    public void setDisplayHora(Hora hora){
        if (tipo=="digital"){
            System.out.println("Digital");
        } else if (tipo=="analogico") {
            System.out.println("Analógico");
        }
    }
}
