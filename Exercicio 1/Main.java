import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        
        do {
            System.out.println("==========================================");
            System.out.println("           Escolha a operação:");
            System.out.println("------------------------------------------");
            System.out.println("              1. Adição");
            System.out.println("              2. Subtração");
            System.out.println("              3. Multiplicação");
            System.out.println("              4. Divisão");
            System.out.println("==========================================");
            System.out.print("Digite o número da operação desejada: ");
            escolha = scanner.nextInt();
            System.out.println("==========================================");
            
            if (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (escolha < 1 || escolha > 4);

        System.out.print("Digite o primeiro número: ");
        double x = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double y = scanner.nextDouble();
        System.out.println("==========================================");

        double resultado = 0.0;
        switch (escolha) {
            case 1:
                resultado = Calculadora.adi(x, y);
                break;
            case 2:
                resultado = Calculadora.sub(x, y);
                break;
            case 3:
                resultado = Calculadora.mult(x, y);
                break;
            case 4:
                resultado = Calculadora.div(x, y);
                break;
        }

        System.out.println("Resultado: " + resultado);
        System.out.println("==========================================");

        scanner.close();
    }
}

