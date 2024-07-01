
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.ClienteModel;
/**
 *
 * @author Junior
 */
public class ClienteDAO {
    public void inserir(ClienteModel cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, telefone, endereco) VALUES (?, ?, ?)";
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ClienteModel cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, telefone = ?, endereco = ? WHERE id = ?";
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public ClienteModel consultar(int id) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                return cliente;
            }
        }
        return null;
    }

    public List<ClienteModel> listar() throws SQLException {
        String sql = "SELECT * FROM cliente";
        List<ClienteModel> clientes = new ArrayList<>();
        try (Connection conn = Connect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ClienteModel cliente = new ClienteModel();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
    
    public boolean existeId(int id) throws SQLException {
    String sql = "SELECT COUNT(*) FROM cliente WHERE id = ?";
    try (Connection conn = Connect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
    }
    return false;
}

}