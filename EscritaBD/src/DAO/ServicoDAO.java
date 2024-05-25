package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.ServicoModel;

public class ServicoDAO {

    public void inserir(ServicoModel servico) throws SQLException {
        String sql = "INSERT INTO servico (id_servico, descricao, cliente) VALUES (?, ?, ?)";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, servico.getIdServico());
            stmt.setString(2, servico.getDescricao());
            stmt.setString(3, servico.getCliente());
            stmt.executeUpdate();
        }
    }

    public void atualizar(ServicoModel servico) throws SQLException {
        String sql = "UPDATE servico SET descricao = ?, cliente = ? WHERE id_servico = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, servico.getDescricao());
            stmt.setString(2, servico.getCliente());
            stmt.setInt(3, servico.getIdServico());
            stmt.executeUpdate();
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM servico WHERE id_servico = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public ServicoModel consultar(int id) throws SQLException {
        String sql = "SELECT * FROM servico WHERE id_servico = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ServicoModel servico = new ServicoModel();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setCliente(rs.getString("cliente"));
                return servico;
            }
        }
        return null;
    }

    public List<ServicoModel> listar() throws SQLException {
        String sql = "SELECT * FROM servico";
        List<ServicoModel> servicos = new ArrayList<>();
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServicoModel servico = new ServicoModel();
                servico.setIdServico(rs.getInt("id_servico"));
                servico.setDescricao(rs.getString("descricao"));
                servico.setCliente(rs.getString("cliente"));
                servicos.add(servico);
            }
        }
        return servicos;
    }

    public boolean existeId(int id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM servico WHERE id_servico = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
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
