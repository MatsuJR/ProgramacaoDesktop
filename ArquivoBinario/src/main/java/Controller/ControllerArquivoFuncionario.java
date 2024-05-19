package Controller;

import Model.FuncionarioModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ControllerArquivoFuncionario extends ControllerArquivo {

    private List<FuncionarioModel> funcionarios = new ArrayList<>();

    @Override
    public boolean ler() {
        try {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(arquivo));
            funcionarios = (List<FuncionarioModel>) leitor.readObject();
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
                escritor.writeObject(funcionarios);
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

    public List<FuncionarioModel> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<FuncionarioModel> funcionarios) {
        this.funcionarios = funcionarios;
    }

   public boolean adicionarFuncionario(FuncionarioModel funcionario) {
        List<FuncionarioModel> funcionarios = listarFuncionarios();
        funcionarios.add(funcionario);
        setFuncionarios(funcionarios);
        return escrever(false); // Sobrescrever o arquivo com a lista atualizada
    }

    public List<FuncionarioModel> listarFuncionarios() {
        List<FuncionarioModel> funcionarios = new ArrayList<>();
        setArquivo("Selecione o arquivo para leitura");

        if (ler()) {
            // Limpar a lista atual de funcionarios
            funcionarios.clear();

            // Adicionar todos os funcionarios lidos do arquivo
            funcionarios.addAll(getFuncionarios());
        }

        return funcionarios;
    }

    public boolean atualizarFuncionario(int id, FuncionarioModel novoFuncionario) {
        List<FuncionarioModel> funcionarios = listarFuncionarios();
        for (FuncionarioModel funcionarioExistente : funcionarios) {
            if (funcionarioExistente.getIdFuncionario() == id) {
                funcionarioExistente.setNomeFuncionario(novoFuncionario.getNomeFuncionario());
                funcionarioExistente.setCargo(novoFuncionario.getCargo());
                // Outros atributos que você precisa atualizar

                return escrever(false); // false para sobrescrever o arquivo
            }
        }
        return false; // Funcionario não encontrado para atualização
    }

    public boolean excluirFuncionario(int id) {
        List<FuncionarioModel> funcionarios = listarFuncionarios();
        FuncionarioModel funcionarioExcluir = null;
        for (FuncionarioModel funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                funcionarioExcluir = funcionario;
                break;
            }
        }
        if (funcionarioExcluir != null) {
            funcionarios.remove(funcionarioExcluir);
            setFuncionarios(funcionarios);
            return escrever(false); // false para sobrescrever o arquivo
        }
        return false; // Funcionario não encontrado para exclusão
    }


    public FuncionarioModel buscarFuncionario(int id) {
        List<FuncionarioModel> funcionarios = listarFuncionarios();
        for (FuncionarioModel funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                return funcionario;
            }
        }
        return null;
    }

}
