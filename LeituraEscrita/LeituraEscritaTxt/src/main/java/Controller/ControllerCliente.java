package Controller;

import java.util.ArrayList;
import java.util.StringTokenizer;
import Model.ClienteModel;

public class ControllerCliente extends ControllerFileTxt {

    private ArrayList<ClienteModel> clientes = new ArrayList<ClienteModel>();

    // Método para ler os clientes do arquivo e armazená-los na lista 'clientes'
    public boolean lerCliente() {
        clientes = new ArrayList<ClienteModel>();
        if (ler()) {
            String conteudo = getTexto();
            StringTokenizer linha = new StringTokenizer(conteudo, "--");
            while (linha.hasMoreTokens()) {
                StringTokenizer registro = new StringTokenizer(linha.nextToken(), ";");
                ClienteModel cliente = new ClienteModel();
                cliente.setId(Integer.parseInt(registro.nextToken()));
                cliente.setNome(registro.nextToken());
                cliente.setTelefone(registro.nextToken());
                cliente.setEndereco(registro.nextToken());

                clientes.add(cliente);
            }
            return true;
        } else {
            return false;
        }
    }

    // Método para escrever os clientes da lista 'clientes' no arquivo
   public boolean escreverCliente(boolean append) {
    ClienteModel novoCliente = clientes.get(clientes.size() - 1);
    String texto = novoCliente.getId() + ";" + novoCliente.getNome() + ";" + novoCliente.getTelefone() + ";" + novoCliente.getEndereco() + "--\n";
    setTexto(texto);
    return escrever(append);
}

    // Método para adicionar um novo cliente à lista 'clientes' e escrever no arquivo
   public boolean adicionarCliente(ClienteModel cliente) {
    // Verifica se o cliente já existe na lista
    if (!clientes.contains(cliente)) {
        // Adiciona o cliente à lista
        clientes.add(cliente);
        // Escreve a lista atualizada no arquivo
        return escreverCliente(true);
    }
    // Retorna falso se o cliente já existe na lista
    return false;
}

    // Método para atualizar um cliente na lista 'clientes' e escrever no arquivo
    public boolean atualizarCliente(ClienteModel clienteAntigo, ClienteModel clienteNovo) {
        int index = clientes.indexOf(clienteAntigo);
        if (index != -1) {
            clienteNovo.setId(clienteAntigo.getId());
            clientes.set(index, clienteNovo);
            return escreverCliente(false);
        }
        return false;
    }

    // Método para remover um cliente da lista 'clientes' e escrever no arquivo
    public boolean removerCliente(ClienteModel cliente) {
        boolean removido = clientes.removeIf(c -> c.getId() == cliente.getId());
        if (removido) {
            return escreverCliente(false);
        }
        return false;
    }

    // Métodos de acesso aos clientes
    public ArrayList<ClienteModel> getClientes() {
        return clientes; // Retorna a lista de clientes
    }

    
}
