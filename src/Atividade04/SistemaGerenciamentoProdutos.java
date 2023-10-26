package Atividade04;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamentoProdutos {
    private Connection connection;

    public SistemaGerenciamentoProdutos() {
        try {
            // Estabelecer a conexão com o banco de dados ElephantSQL
            String url = "jdbc:postgresql://motty.db.elephantsql.com/ftzateey";
            String user = "ftzateey";
            String password = "IZ7GOfln-UPAkfuxI6t07rnhJur82BxW";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarProduto(int id, String nome, double preco) {
        String sql = "INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nome);
            preparedStatement.setDouble(3, preco);
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProduto(int id) {
        String sql = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Produto removido com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarPreco(int id, double novoPreco) {
        String sql = "UPDATE produtos SET preco = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, novoPreco);
            preparedStatement.setInt(2, id);
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                System.out.println("Preço atualizado com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto recuperarProduto(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int produtoId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                return new Produto(produtoId, nome, preco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Produto não encontrado
    }

    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                produtos.add(new Produto(id, nome, preco));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public Produto obterProduto(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
