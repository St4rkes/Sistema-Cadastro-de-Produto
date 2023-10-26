package Atividade04;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TesteRemoverProduto {

    @ParameterizedTest
    @CsvFileSource(resources = "/ids_produtos_para_remover.csv")
    void testRemoverProduto(int id) {
        // Crie uma instância do seu sistema de gerenciamento de produtos
        SistemaGerenciamentoProdutos sistema = new SistemaGerenciamentoProdutos();

        // Adicione o produto de teste ao sistema (opcional, se necessário)
        // Produto produto = new Produto(id, "Nome do Produto", BigDecimal.valueOf(19.99));
        // sistema.adicionarProduto(produto);

        // Remova o produto com base no ID
        sistema.removerProduto(id);

        // Tente recuperar o produto removido do sistema
        Produto produtoRemovido = sistema.recuperarProduto(id);

        // Verifique se o produto foi removido corretamente (espera-se que seja nulo)
        assertNull(produtoRemovido);
    }
}
