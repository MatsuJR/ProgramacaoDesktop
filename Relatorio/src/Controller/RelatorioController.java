package Controller;

import DAO.Connect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Junior
 */
public class RelatorioController {

    private Connection connection;
    private static final String PASTA_RELATORIOS = System.getProperty("user.dir") + "/src/relatorios/";

    private static final File FILE_RELATORIO_CLIENTE_FONTE = new File(PASTA_RELATORIOS, "RelatorioTodosClientes.jrxml");
    private static final File FILE_RELATORIO_CLIENTE_COMPILADO = new File(PASTA_RELATORIOS, "RelatorioTodosClientes.jasper");
    private static final File RELATORIO_CLIENTE_PDF = new File(PASTA_RELATORIOS, "relatorio_cliente.pdf");

    private static final File FILE_RELATORIO_CLIENTE_PARAMETRO_FONTE = new File(PASTA_RELATORIOS, "RelatorioCliente.jrxml");
    private static final File FILE_RELATORIO_CLIENTE_PARAMETRO_COMPILADO = new File(PASTA_RELATORIOS, "RelatorioCliente.jasper");
    private static final File RELATORIO_CLIENTE_PARAMETRO_PDF = new File(PASTA_RELATORIOS, "relatorio_parametro.pdf");

    private static final File FILE_RELATORIO_ITENS_FONTE = new File(PASTA_RELATORIOS, "Blank_A4.jrxml");
    private static final File FILE_RELATORIO_ITENS_COMPILADO = new File(PASTA_RELATORIOS, "Blank_A4.jasper");

    public RelatorioController() {
        connection = Connect.getConnection();
    }

    public File getFileRelatorioClienteFonte() {
        return FILE_RELATORIO_CLIENTE_FONTE;
    }

    public File getFileRelatorioClienteCompilado() {
        return FILE_RELATORIO_CLIENTE_COMPILADO;
    }

    public File getRelatorioClientePdf() {
        return RELATORIO_CLIENTE_PDF;
    }

    public File getFileRelatorioClienteParametroFonte() {
        return FILE_RELATORIO_CLIENTE_PARAMETRO_FONTE;
    }

    public File getFileRelatorioClienteParametroCompilado() {
        return FILE_RELATORIO_CLIENTE_PARAMETRO_COMPILADO;
    }

    public File getRelatorioClienteParametroPdf() {
        return RELATORIO_CLIENTE_PARAMETRO_PDF;
    }

    public Map<String, Object> constroiParametrosCliente() {
        Map<String, Object> params = new HashMap<>();

        int id = Integer.valueOf(JOptionPane.showInputDialog(
                null,
                "Digite o id do cliente",
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE));

        params.put("P1", id);
        return params;
    }

    public File getFileRelatorioItemFonte() {
        return FILE_RELATORIO_ITENS_FONTE;
    }

    public File getFileRelatorioItemCompilado() {
        return FILE_RELATORIO_ITENS_COMPILADO;
    }

    public void gerarRelatorioClientes() {
        JasperPrint impressao;
        try {
            FileInputStream arquivo = new FileInputStream(getFileRelatorioClienteFonte());

            // Compila o relatório (caso deseja usar o jrxml)
            JasperReport relatorio = JasperCompileManager.compileReport(arquivo);

            // Preenchimento do relatório com a conexão e parâmetros
            impressao = JasperFillManager.fillReport(
                    relatorio,
                    null,
                    connection);

            // Opção de visualizar o relatório
            JasperViewer.viewReport(impressao);

        } catch (JRException | FileNotFoundException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
        }
    }

    public void gerarPDFRelatorioClientes() {
        JasperPrint impressao;
        try {
            FileInputStream relatorio = new FileInputStream(getFileRelatorioClienteCompilado());

            // Preenchimento do relatório com a conexão e parâmetros
            impressao = JasperFillManager.fillReport(
                    relatorio,
                    null,
                    connection);

            // Opção de exportar o relatório diretamente para arquivo
            JasperExportManager.exportReportToPdfFile(impressao, getRelatorioClientePdf().getAbsolutePath());

            JOptionPane.showMessageDialog(null, "Gerado o arquivo com sucesso: " + getRelatorioClientePdf().getAbsolutePath());
        } catch (FileNotFoundException | JRException erro) {
            System.err.println("Não foi possível exportar o relatório.\n\n" + erro);
        }
    }

    public void gerarRelatorioClientesComParametro(Map<String, Object> parametros) {
        JasperPrint impressao;
        try {
            FileInputStream relatorio = new FileInputStream(getFileRelatorioClienteParametroCompilado());

            impressao = JasperFillManager.fillReport(
                    relatorio,
                    parametros,
                    connection);

            JasperViewer.viewReport(impressao);
        } catch (FileNotFoundException | JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }

    public void gerarPDFRelatorioClientesComParametro(Map<String, Object> parametros) {
        JasperPrint impressao;
        try {
            FileInputStream relatorio = new FileInputStream(getFileRelatorioClienteParametroCompilado());

            impressao = JasperFillManager.fillReport(
                    relatorio,
                    parametros,
                    connection);

            JasperExportManager.exportReportToPdfFile(impressao, getRelatorioClienteParametroPdf().getAbsolutePath());

            JOptionPane.showMessageDialog(null, "Gerado o arquivo " + getRelatorioClienteParametroPdf().getAbsolutePath());
        } catch (FileNotFoundException | JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////////////////////
    public Map<String, Object> constroiParametrosDatas() {
        Map<String, Object> params = new HashMap<>();

        // Solicita a data de início
        String strDataInicio = JOptionPane.showInputDialog(
                null,
                "Digite a data de início (formato: dd/MM/yyyy)",
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE);
        Date dataInicio = parseData(strDataInicio); // Implemente um método para converter a String em Date, como parseData()

        // Solicita a data de fim
        String strDataFim = JOptionPane.showInputDialog(
                null,
                "Digite a data de fim (formato: dd/MM/yyyy)",
                "Entrada de dados",
                JOptionPane.QUESTION_MESSAGE);
        Date dataFim = parseData(strDataFim); // Implemente um método para converter a String em Date, como parseData()

        // Coloca as datas no mapa de parâmetros com os nomes adequados para o JasperReports
        params.put("date1", dataInicio);
        params.put("date2", dataFim);

        return params;
    }

    // Método auxiliar para converter String em Date
    private Date parseData(String strData) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(strData);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Ou lance uma exceção adequada conforme sua necessidade
        }
    }

    public void gerarRelatorioItensComParametros(Date dataInicio, Date dataFim) {
        JasperPrint impressao;
        try {
            FileInputStream relatorio = new FileInputStream(getFileRelatorioItemCompilado());

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("date1", dataInicio);
            parametros.put("date2", dataFim);

            impressao = JasperFillManager.fillReport(
                    relatorio,
                    parametros,
                    connection);

            JasperViewer.viewReport(impressao);
        } catch (FileNotFoundException | JRException ex) {
            System.err.println("Não foi possível exportar o relatório.\n\n");
            ex.printStackTrace();
        }
    }

}
