package bancodados2;

/**
 * @author fabricio
 */
public class Cliente {

    private int id;
    private String nome;
    private int idade;
    private String fone;
    private String email;

    public Cliente() {
    }

    public Cliente(int id, String nm, int idade, String fone, String email) {
        this.id = id;
        this.nome = nm;
        this.idade = idade;
        this.fone = fone;
        this.email = email;
    }

    @Override
    public String toString() {
        String resposta = this.getId() + "\n";
        resposta += this.getNome() + "\n";
        resposta += this.getIdade() + "\n";
        resposta += this.getFone() + "\n";
        resposta += this.getEmail() + "\n\n\n";
        return resposta;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
