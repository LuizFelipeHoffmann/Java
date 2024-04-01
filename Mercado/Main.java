import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int opcao = lerOpcao();
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    sair = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        leitor.close();
    }

    private static void exibirMenu() {
        System.out.println("=================================");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Atualizar Produto");
        System.out.println("3. Remover Produto");
        System.out.println("4. Gerar Relatório de Estoque");
        System.out.println("5. Sair");
        System.out.println("=================================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        return leitor.nextInt();
    }

    private static void adicionarProduto() {
        System.out.println("=================================");
        System.out.print("Nome do novo produto: ");
        String nomeProduto = leitor.next();
        System.out.print("Código do produto: ");
        int codigoProduto = leitor.nextInt();
        System.out.print("Preço do produto: ");
        double precoProduto = leitor.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidadeEstoque = leitor.nextInt();
        System.out.println("=================================");
        listaProdutos.add(new Produto(nomeProduto, codigoProduto, precoProduto, quantidadeEstoque));
        System.out.println("Produto adicionado com sucesso!");
        System.out.println("=================================");
    }

    private static void atualizarProduto() {
        System.out.print("Digite o código do produto a ser atualizado: ");
        int codigoProduto = leitor.nextInt();
        System.out.println("==========================================");
        Produto produto = buscarProduto(codigoProduto);
        if (produto != null) {
            System.out.print("Novo nome do produto: ");
            String nomeProduto = leitor.next();
            System.out.print("Novo preço do produto: ");
            double precoProduto = leitor.nextDouble();
            System.out.print("Nova quantidade em estoque: ");
            int quantidadeEstoque = leitor.nextInt();
            produto.setNome(nomeProduto);
            produto.setPreco(precoProduto);
            produto.setQuantidade(quantidadeEstoque);
            System.out.println("Produto atualizado com sucesso!");
            System.out.println("=================================");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void removerProduto() {
        System.out.print("Digite o código do produto a ser removido: ");
        int codigoProduto = leitor.nextInt();
        System.out.println("==========================================");
        Produto produto = buscarProduto(codigoProduto);
        if (produto != null) {
            listaProdutos.remove(produto);
            System.out.println("Produto removido com sucesso!");
            System.out.println("==========================================");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static Produto buscarProduto(int codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    private static void gerarRelatorio() {
        System.out.println("                 RELATÓRIO ");
        System.out.println("==========================================");
        if (listaProdutos.isEmpty()) {
            System.out.println("Não há produtos no estoque.");
        } else {
            for (Produto produto : listaProdutos) {
                System.out.println(produto);
            }
        }
    }
}
