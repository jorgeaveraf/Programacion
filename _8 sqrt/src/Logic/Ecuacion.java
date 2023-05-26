package Logic;

public class Ecuacion {
    private double a;
    private double b;
    private double c;

    public double raizP(double a, double b, double c) {
        double discriminante = (b * b) - (4 * a * c);
            double raiz = Math.round(((-b + Math.sqrt(discriminante)) / (2 * a))* 100.0 / 100.0);
            return raiz;
        }

    public double raizN(double a, double b, double c) {
        double discriminante = (b * b) - (4 * a * c);
        double raiz = Math.round(((-b - Math.sqrt(discriminante)) / (2 * a))* 100.0 / 100.0);
        return raiz;
    }
    }
