import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pizza> pizzas = new ArrayList<>();
    private static ArrayList<Pedido> pedidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        Pizza mussarela = new Pizza("Mussarela", 28.0);
        Pizza calabresa = new Pizza("Calabresa", 32.0);
        pizzas.add(mussarela);
        pizzas.add(calabresa);

        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    adicionarPedido();
                    break;
                case 2:
                    cancelarPedido();
                    break;
                case 3:
                    gerarRelatorio();
                    break;
                case 4:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n========= Pizzaria do Luiz =========\n");
        System.out.println("                MENU:");
        System.out.println("------------------------------------");
        System.out.println("1. Adicionar Pedido");
        System.out.println("2. Cancelar Pedido");
        System.out.println("3. Gerar Relatório de Pedidos");
        System.out.println("4. Sair");
        System.out.println("=====================================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        return scanner.nextInt();
    }

    private static void adicionarPedido() {
        System.out.println("\n--------- Adicionar Pedido ---------\n");
        System.out.println("         Escolha uma pizza:");
        System.out.println("------------------------------------");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println((i + 1) + " - " + pizzas.get(i).getNome() + " - R$" + pizzas.get(i).getValor());
        }
        System.out.println("=====================================");
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 
        

        if (escolha > 0 && escolha <= pizzas.size()) {
            Pizza pizzaEscolhida = pizzas.get(escolha - 1);
            System.out.println("=====================================");
            System.out.print("Informe o tamanho da pizza (P, M, G): ");
            String tamanho = scanner.nextLine();
            System.out.print("Informe o endereço de entrega: ");
            String endereco = scanner.nextLine();
            Pedido novoPedido = new Pedido(pizzaEscolhida, tamanho, endereco);
            pedidos.add(novoPedido);
            System.out.println("Pedido adicionado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void cancelarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println("\n--------- Cancelar Pedido ---------");
            System.out.println("Não há pedidos para cancelar.");
            return;
        }

        System.out.println("\n--------- Cancelar Pedido ---------");
        System.out.println("Escolha o pedido a ser cancelado:");
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println((i + 1) + " - " + pedidos.get(i).getPizza().getNome() + " - R$" + pedidos.get(i).getPizza().getValor() + " - " + pedidos.get(i).getEndereco());
        }
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); 

        if (escolha > 0 && escolha <= pedidos.size()) {
            pedidos.remove(escolha - 1);
            System.out.println("Pedido cancelado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void gerarRelatorio() {
        System.out.println("\n--------- RELATÓRIO DE PEDIDOS ---------");
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("Pizza: " + pedido.getPizza().getNome());
                System.out.println("Valor: R$" + pedido.getPizza().getValor());
                System.out.println("Tamanho: " + pedido.getTamanho());
                System.out.println("Endereço: " + pedido.getEndereco());
                System.out.println("------------------------------------");
            }
        }
    }
}
