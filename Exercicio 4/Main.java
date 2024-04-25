import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jogador> jogadores = new ArrayList<>();

        int opcao;
        do {
            System.out.println("==============================");
            System.out.println("           Jogador");
            System.out.println("==============================");
            System.out.println("1. Adicionar jogador");
            System.out.println("2. Alterar pontuação de jogador");
            System.out.println("3. Visualizar jogadores");
            System.out.println("4. Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("==============================");

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do jogador: ");
                    String nomeJogador = scanner.nextLine();

                    System.out.print("Digite a pontuação inicial do jogador: ");
                    int pontuacaoInicial = scanner.nextInt();

                    System.out.print("Digite o nível inicial do jogador: ");
                    int nivelInicial = scanner.nextInt();

                    Jogador novoJogador = new Jogador(nomeJogador, pontuacaoInicial, nivelInicial);
                    jogadores.add(novoJogador);
                    System.out.println("Jogador adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome do jogador que deseja alterar a pontuação: ");
                    String nomeAlterar = scanner.nextLine();
                    boolean encontrado = false;

                    for (Jogador jogador : jogadores) {
                        if (jogador.getNome().equalsIgnoreCase(nomeAlterar)) {
                            System.out.print("Digite o valor a ser adicionado à pontuação: ");
                            int pontosAdicionais = scanner.nextInt();
                            jogador.aumentarPontuacao(pontosAdicionais);
                            System.out.println("Pontuação do jogador alterada com sucesso!");
                            encontrado = true;
                            break; 
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;
                case 3:
                    if (jogadores.isEmpty()) {
                        System.out.println("Não há jogadores cadastrados.");
                    } else {
                        System.out.println("Lista de jogadores cadastrados:");
                        for (int i = 0; i < jogadores.size(); i++) {
                            System.out.println("Jogador " + (i+1) + ": " + jogadores.get(i).getNome());
                        }
                    }
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
