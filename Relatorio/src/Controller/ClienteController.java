package Controller;

import DAO.ClienteDAO;
import Model.ClienteModel;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Junior
 */
public class ClienteController {
    
    private final ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void inserirCliente(ClienteModel cliente) {
        try {
            clienteDAO.inserir(cliente);
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir cliente: " + ex.getMessage());
        }
    }

    public void atualizarCliente(ClienteModel cliente) {
        try {
            clienteDAO.atualizar(cliente);
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar cliente: " + ex.getMessage());
        }
    }

    public boolean excluirCliente(int id) {
    try {
        clienteDAO.excluir(id);
        return true;
    } catch (SQLException ex) {
        System.err.println("Erro ao excluir cliente: " + ex.getMessage());
        return false;
    }
}


    public ClienteModel consultarCliente(int id) {
        try {
            return clienteDAO.consultar(id);
        } catch (SQLException ex) {
            System.err.println("Erro ao consultar cliente: " + ex.getMessage());
            return null;
        }
    }

    public List<ClienteModel> listarClientes() {
        try {
            return clienteDAO.listar();
        } catch (SQLException ex) {
            System.err.println("Erro ao listar clientes: " + ex.getMessage());
            return null;
        }
    }
    
    public boolean verificarIdExistente(int id) {
        try {
            return clienteDAO.existeId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
