import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.print("Digite o número da conta: ");
        int numeroConta = scanner.nextInt();
        System.out.println("==========================================");
        System.out.print("Digite o nome do titular da conta: ");
        scanner.nextLine();
        String nomeTitular = scanner.nextLine();

        ContaBancaria minhaConta = new ContaBancaria(numeroConta, nomeTitular);

        int opcao;
        do {
            System.out.println("==========================================");
            System.out.println("           1. Depositar");
            System.out.println("           2. Sacar");
            System.out.println("           3. Consultar Saldo");
            System.out.println("           4. Sair");
            System.out.println("==========================================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println("==================================");

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    minhaConta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    System.out.println("==========================================");
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    if (minhaConta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("==========================================");
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque.");
                        System.out.println("==========================================");
                    }
                    break;
                case 3:
                    System.out.println("Saldo atual: " + minhaConta.consultarSaldo());
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
