package Atividade04;
import java.util.List;

public class main {

	public static void main(String[] args) {
        SistemaGerenciamentoProdutos sistema = new SistemaGerenciamentoProdutos();

        // Exemplo de uso dos métodos
        sistema.adicionarProduto(1, "Produto A", 10.0);
        sistema.adicionarProduto(2, "Produto B", 15.0);
        sistema.adicionarProduto(3, "Produto C", 20.0);

        List<Produto> produtos = sistema.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }

        sistema.atualizarPreco(1, 12.0);

        Produto produtoB = sistema.recuperarProduto(2);
        if (produtoB != null) {
            System.out.println("Informações do Produto B: " + produtoB);
        } else {
            System.out.println("Produto não encontrado.");
        }

        sistema.removerProduto(3);

        produtos = sistema.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}


