package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.FuncionarioModel;

public class FuncionarioDAO {

    public void inserir(FuncionarioModel funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (id_funcionario, nome_funcionario, cargo) VALUES (?, ?, ?)";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.setString(2, funcionario.getNomeFuncionario());
            stmt.setString(3, funcionario.getCargo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(FuncionarioModel funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome_funcionario = ?, cargo = ? WHERE id_funcionario = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCargo());
            stmt.setInt(3, funcionario.getIdFuncionario());
            stmt.executeUpdate();
        }
    }

    public boolean excluir(int id) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        }
    }

    public FuncionarioModel consultar(int id) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
                funcionario.setCargo(rs.getString("cargo"));
                return funcionario;
            }
        }
        return null;
    }

    public List<FuncionarioModel> listar() throws SQLException {
        String sql = "SELECT * FROM funcionario";
        List<FuncionarioModel> funcionarios = new ArrayList<>();
        try (Connection conn = Connect.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                FuncionarioModel funcionario = new FuncionarioModel();
                funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    public boolean existeId(int id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM funcionario WHERE id_funcionario = ?";
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
