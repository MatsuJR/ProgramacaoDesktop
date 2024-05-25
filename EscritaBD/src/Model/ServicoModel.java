
package Model;


public class ServicoModel {

    private int idServico;
    private String descricao;
    private String cliente;

    public ServicoModel() {
    }

    public ServicoModel(int idServico, String descricao, String cliente) {
        this.idServico = idServico;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    
}


