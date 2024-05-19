package Controller;

import Model.ClienteModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerArquivoCliente extends ControllerArquivo {

    private List<ClienteModel> clientes = new ArrayList<>();

    @Override
    public boolean ler() {
        try {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
            clientes = (List<ClienteModel>) leitor.readObject();
            leitor.close();
            return true;
        } catch (ClassNotFoundException | IOException erro) {
            System.err.println(erro.getMessage() + "Erro ao ler arquivo binário.");
            return false;
        }
    }

    @Override
    public boolean escrever(boolean append) {
        if (arquivo != null) {
            try {
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(arquivo, append));
                escritor.writeObject(clientes);
                escritor.close();
                return true;
            } catch (IOException erro) {
                System.err.println(erro.getMessage() + "Erro ao escrever arquivo binário.");
                return false;
            }
        } else {
            return false;
        }
    }

    public List<ClienteModel> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteModel> clientes) {
        this.clientes = clientes;
    }

   public boolean adicionarCliente(ClienteModel cliente) {
        List<ClienteModel> clientes = listarClientes();
        clientes.add(cliente);
        setClientes(clientes);
        return escrever(false); // Sobrescrever o arquivo com a lista atualizada
    }

    public List<ClienteModel> listarClientes() {
        List<ClienteModel> clientes = new ArrayList<>();
        setArquivo("Selecione o arquivo para leitura");

        if (ler()) {
            // Limpar a lista atual de clientes
            clientes.clear();

            // Adicionar todos os clientes lidos do arquivo
            clientes.addAll(getClientes());
        }

        return clientes;
    }

    public boolean atualizarCliente(int id, ClienteModel novoCliente) {
        List<ClienteModel> clientes = listarClientes();
        for (ClienteModel clienteExistente : clientes) {
            if (clienteExistente.getId() == id) {
                clienteExistente.setNome(novoCliente.getNome());
                clienteExistente.setTelefone(novoCliente.getTelefone());
                clienteExistente.setEndereco(novoCliente.getEndereco());
                // Outros atributos que você precisa atualizar

                return escrever(false); // false para sobrescrever o arquivo
            }
        }
        return false; // Cliente não encontrado para atualização
    }

    public boolean excluirCliente(int id) {
    List<ClienteModel> clientes = listarClientes();
    ClienteModel clienteExcluir = null;
    for (ClienteModel cliente : clientes) {
        if (cliente.getId() == id) {
            clienteExcluir = cliente;
            break;
        }
    }
    if (clienteExcluir != null) {
        clientes.remove(clienteExcluir);
        setClientes(clientes);
        return escrever(false); // false para sobrescrever o arquivo
    }
    return false; // Cliente não encontrado para exclusão
}


    public ClienteModel buscarCliente(int id) {
        List<ClienteModel> clientes = listarClientes();
        for (ClienteModel cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

}
