package Atividade04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;



public class TesteAtualizarPreco {

    @ParameterizedTest
    @CsvFileSource(resources = "/atualizacao_preco.csv")
    void testAtualizarPreco(int id, double novoPreco) {
        // Crie uma instância do seu sistema de gerenciamento de produtos
        SistemaGerenciamentoProdutos sistema = new SistemaGerenciamentoProdutos();

        // Adicione o produto de teste ao sistema (opcional, se necessário)
        // Produto produto = new Produto(id, "Nome do Produto", BigDecimal.valueOf(19.99));
        // sistema.adicionarProduto(produto);

        // Atualize o preço do produto com base no ID
        sistema.atualizarPreco(id, novoPreco);

        // Recupere o produto atualizado do sistema
        Produto produtoAtualizado = sistema.recuperarProduto(id);

        // Verifique se o preço foi atualizado corretamente
        assertEquals(novoPreco, produtoAtualizado.getPreco());
    }
}

