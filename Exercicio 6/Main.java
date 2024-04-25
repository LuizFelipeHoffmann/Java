import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Contato> contatos = new ArrayList<>();

        while (true) {
            System.out.println("====================================");
            System.out.println("1. Cadastrar Contato");
            System.out.println("2. Visualizar Todos os Contatos");
            System.out.println("3. Procurar Contato por Nome");
            System.out.println("4. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("==========================================");
                    System.out.print("Informe o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    Contato novoContato = new Contato(nome, telefone);
                    System.out.println("==========================================");
                    contatos.add(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("==========================================");
                    System.out.println("Lista de Contatos:");
                    for (Contato contato : contatos) {
                        System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone());
                    }
                    break;
                case 3: 
                    System.out.println("==========================================");
                    System.out.print("Digite o nome do contato para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    boolean encontrado = false;
                    for (Contato contato : contatos) {
                        if (contato.getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Telefone de " + contato.getNome() + ": " + contato.getTelefone());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {  
                        System.out.println("==========================================");
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("==========================================");
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("==========================================");
                    System.out.println("Opção inválida!");
            }
        }
    }
}
