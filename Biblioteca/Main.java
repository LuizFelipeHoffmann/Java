import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();
        int opcao = 0;

        while(opcao != 3) {
            System.out.println("=====================================");
            System.out.println("    [1] Adicionar um livro");
            System.out.println("    [2] Exibir livro");
            System.out.println("    [3] Mostrar todos os livros");
            System.out.println("    [4] Sair do programa");
            System.out.println("=====================================");
            System.out.print("Escolha uma opcao(1-4): ");
            opcao = input.nextInt();
            System.out.println("-------------------------------------");

            switch(opcao) {
                case 1:
                    input.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Informe o nome do livro: ");
                    String titulo = input.nextLine();
                    
                    System.out.print("Informe o autor do livro: ");
                    String autor = input.nextLine();

                    System.out.print("Informe o ano do livro: ");
                    int ano = input.nextInt();
                    System.out.println("=====================================");

                    livros.add(new Livro(titulo, autor, ano));
                    break;
                case 2:
                    System.out.print("Digite o termo para buscar o livro: ");
                    String termoBusca = input.next();
                    System.out.println("=====================================");

                    boolean encontrado = false;
                    for (Livro livro : livros) {
                        if (livro.getTitulo().equalsIgnoreCase(termoBusca) || livro.getAutor().equalsIgnoreCase(termoBusca) || String.valueOf(livro.getAno()).equals(termoBusca)) {
                            System.out.println(livro.exibirInfo());
                            encontrado = true;
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Livro não encontrado.");
                        System.out.println("=====================================");
                    }
                    break;
                case 3:
                    System.out.println("Lista de todos os livros cadastrados:");
                    for (Livro livro : livros) {
                        System.out.println(livro.exibirInfo());
                    }
                    System.out.println("=====================================");
                    break;
                case 4:
                    System.out.println("Encerrando o programa...");
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("Opcao invalida! Tente novamente.");
                    System.out.println("=====================================");
            }
        }

        input.close();
    }
}
