package Controller;

import java.io.File;
import javax.swing.JFileChooser;


public abstract class ControllerFile {
    protected File arquivo = null;

    public abstract boolean ler(String nomeArquivo);
    public abstract boolean escrever(String nomeArquivo, boolean append);

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(String TextoBotao) {
        arquivo = null;
        String pastainicial = System.getProperty("user.dir");
        JFileChooser chooser = new JFileChooser(pastainicial);
        if (chooser.showDialog(null, TextoBotao) == JFileChooser.APPROVE_OPTION) {
            arquivo = chooser.getSelectedFile();
        }
    }
}
