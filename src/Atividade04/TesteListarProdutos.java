package Atividade04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.math.BigDecimal;
import java.util.List;

public class TesteListarProdutos {

    private SistemaGerenciamentoProdutos sistema;

    @BeforeEach
    void setUp() {
        // Inicialize o sistema antes de cada teste
        sistema = new SistemaGerenciamentoProdutos();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/produtos_para_listar.csv")
    void testListarProdutos(int id, String nome, BigDecimal preco) {
        // Adicione o produto ao sistema
        sistema.adicionarProduto(id, nome, preco.doubleValue());

        // Liste todos os produtos do sistema
        List<Produto> produtos = sistema.listarProdutos();

        // Verifique se o número de produtos na lista é o esperado
        assertEquals(1, produtos.size());

        // Verifique se os detalhes do produto na lista correspondem aos dados do CSV
        Produto produtoListado = produtos.get(0);
        assertEquals(id, produtoListado.getId());
        assertEquals(nome, produtoListado.getNome());
        assertEquals(preco, BigDecimal.valueOf(produtoListado.getPreco()));
    }
}

