import java.util.Scanner;
public class Calculadora {

    public static double adi(double x, double y) {
        return x + y;
    }

    public static double sub(double x, double y) {
        return x - y;
    }

    public static double mult(double x, double y) {
        return x * y;
    }

    public static double div(double x, double y) {
        if (x != 0) {
            return x / y;
        } else {
            System.out.println("Erro: Divisão por zero não é permitida.");
            return Double.NaN; 
        }
    }
}
        
