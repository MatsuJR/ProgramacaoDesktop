package Controller;

import DAO.FuncionarioDAO;
import Model.FuncionarioModel;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    private final FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        this.funcionarioDAO = new FuncionarioDAO();
    }

    public void inserirFuncionario(FuncionarioModel funcionario) {
        try {
            funcionarioDAO.inserir(funcionario);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir funcionário: " + ex.getMessage());
        }
    }

    public void atualizarFuncionario(FuncionarioModel funcionario) {
        try {
            funcionarioDAO.atualizar(funcionario);
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar funcionário: " + ex.getMessage());
        }
    }

    public boolean excluirFuncionario(int id) {
        try {
            return funcionarioDAO.excluir(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FuncionarioModel consultarFuncionario(int id) {
        try {
            return funcionarioDAO.consultar(id);
        } catch (SQLException ex) {
            System.err.println("Erro ao consultar funcionário: " + ex.getMessage());
            return null;
        }
    }

    public List<FuncionarioModel> listarFuncionarios() {
        try {
            return funcionarioDAO.listar();
        } catch (SQLException ex) {
            System.err.println("Erro ao listar funcionários: " + ex.getMessage());
            return null;
        }
    }

    public boolean verificarIdExistente(int id) {
        try {
            return funcionarioDAO.existeId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
