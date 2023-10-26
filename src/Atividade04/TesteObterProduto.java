package Atividade04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TesteObterProduto {

    @ParameterizedTest
    @CsvFileSource(resources = "/ids_produtos_para_buscar.csv")
    void testObterProduto(int id) {
        // Crie uma instância do seu sistema de gerenciamento de produtos
        SistemaGerenciamentoProdutos sistema = new SistemaGerenciamentoProdutos();

        // Adicione os produtos de teste ao sistema (opcional, se necessário)
        // Produto produto = new Produto(id, "Nome do Produto", BigDecimal.valueOf(19.99));
        // sistema.adicionarProduto(produto);

        // Busque o produto com base no ID
        Produto produtoBuscado = sistema.obterProduto(id);

        // Verifique se o produto foi buscado corretamente
        // Se o produto não existir, você pode verificar se a referência é nula
        // ou adicionar uma lógica adicional para tratar essa situação.
        assertEquals(id, produtoBuscado.getId());
    }
}

