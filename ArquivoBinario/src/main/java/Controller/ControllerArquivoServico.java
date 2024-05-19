package Controller;

import Model.ServicoModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerArquivoServico extends ControllerArquivo {

    private List<ServicoModel> servicos = new ArrayList<>();

    @Override
    public boolean ler() {
        try {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
            servicos = (List<ServicoModel>) leitor.readObject();
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
                escritor.writeObject(servicos);
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

    public List<ServicoModel> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoModel> servicos) {
        this.servicos = servicos;
    }

    public boolean adicionarServico(ServicoModel servico) {
        List<ServicoModel> servicos = listarServicos();
        servicos.add(servico);
        setServicos(servicos);
        return escrever(false); // Sobrescrever o arquivo com a lista atualizada
    }

    public List<ServicoModel> listarServicos() {
        List<ServicoModel> servicos = new ArrayList<>();
        setArquivo("Selecione o arquivo para leitura");

        if (ler()) {
            // Limpar a lista atual de servicos
            servicos.clear();

            // Adicionar todos os servicos lidos do arquivo
            servicos.addAll(getServicos());
        }

        return servicos;
    }

    public boolean atualizarServico(int id, ServicoModel novoServico) {
        List<ServicoModel> servicos = listarServicos();
        for (ServicoModel servicoExistente : servicos) {
            if (servicoExistente.getIdServico() == id) {
                servicoExistente.setDescricao(novoServico.getDescricao());
                servicoExistente.setCliente(novoServico.getCliente());
                // Outros atributos que você precisa atualizar

                return escrever(false); // false para sobrescrever o arquivo
            }
        }
        return false; // Servico não encontrado para atualização
    }

    public boolean excluirServico(int id) {
        List<ServicoModel> servicos = listarServicos();
        ServicoModel servicoExcluir = null;
        for (ServicoModel servico : servicos) {
            if (servico.getIdServico() == id) {
                servicoExcluir = servico;
                break;
            }
        }
        if (servicoExcluir != null) {
            servicos.remove(servicoExcluir);
            setServicos(servicos);
            return escrever(false); // false para sobrescrever o arquivo
        }
        return false; // Servico não encontrado para exclusão
    }

    public ServicoModel buscarServico(int id) {
        List<ServicoModel> servicos = listarServicos();
        for (ServicoModel servico : servicos) {
            if (servico.getIdServico() == id) {
                return servico;
            }
        }
        return null;
    }
}
