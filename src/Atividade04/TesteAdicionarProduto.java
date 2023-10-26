package Atividade04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class TesteAdicionarProduto {

    @ParameterizedTest
    @CsvFileSource(resources = "/produtos.csv")
    void testAdicionarProduto(int id, String nome, double preco) {
        // Crie uma instância do seu sistema de gerenciamento de produtos
        SistemaGerenciamentoProdutos sistema = new SistemaGerenciamentoProdutos();

     
        // Crie um objeto Produto com os valores do CSV
        Produto produto = new Produto(id, nome, preco);

        // Adicione o produto ao sistema
        sistema.adicionarProduto(produto);

        // Recupere o produto do sistema
        Produto produtoRecuperado = sistema.recuperarProduto(id);

        // Verifique se o produto foi adicionado corretamente
        assertEquals(id, produtoRecuperado.getId());
        assertEquals(nome, produtoRecuperado.getNome());
        assertEquals(preco, produtoRecuperado.getPreco());
    }
}

