package Model;

import java.io.Serializable;

public class FuncionarioModel  implements Serializable{

    private static long serialVersionUID = 1L;
    private int idFuncionario;
    private String nomeFuncionario;
    private String cargo;

    public FuncionarioModel() {
    }

    public FuncionarioModel(int idFuncionario, String nomeFuncionario, String cargo) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
    }
    
    
    

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

}
