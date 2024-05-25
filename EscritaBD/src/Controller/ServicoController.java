package Controller;

import DAO.ServicoDAO;
import Model.ServicoModel;
import java.sql.SQLException;
import java.util.List;

public class ServicoController {

    private final ServicoDAO servicoDAO;

    public ServicoController() {
        this.servicoDAO = new ServicoDAO();
    }

    public void inserirServico(ServicoModel servico) {
        try {
            servicoDAO.inserir(servico);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir serviço: " + ex.getMessage());
        }
    }

    public void atualizarServico(ServicoModel servico) {
        try {
            servicoDAO.atualizar(servico);
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar serviço: " + ex.getMessage());
        }
    }

    public boolean excluirServico(int id) {
        try {
            return servicoDAO.excluir(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ServicoModel consultarServico(int id) {
        try {
            return servicoDAO.consultar(id);
        } catch (SQLException ex) {
            System.err.println("Erro ao consultar serviço: " + ex.getMessage());
            return null;
        }
    }

    public List<ServicoModel> listarServicos() {
        try {
            return servicoDAO.listar();
        } catch (SQLException ex) {
            System.err.println("Erro ao listar serviços: " + ex.getMessage());
            return null;
        }
    }

    public boolean verificarIdExistente(int id) {
        try {
            return servicoDAO.existeId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
