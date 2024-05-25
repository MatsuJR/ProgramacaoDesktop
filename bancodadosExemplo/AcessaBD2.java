/*
 * AcessaBD2.java
  * @author  fabricio@utfpr.edu.br
 */
package bancodados2;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;
import java.util.Vector;

public class AcessaBD2 extends javax.swing.JFrame {

    private Connection connection = null;
    private Statement stdados = null;
    private ResultSet rsdados = null;

    private PreparedStatement pstdados = null;
    private CallableStatement cstdados = null;

    private JTable tabela = null;
    private JScrollPane scroller = null;

    public AcessaBD2() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        label5 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        labelnome = new javax.swing.JLabel();
        labelidade = new javax.swing.JLabel();
        labelemail = new javax.swing.JLabel();
        labelfone = new javax.swing.JLabel();
        btn_primeiro = new javax.swing.JButton();
        btn_proximo = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        btn_ultimo = new javax.swing.JButton();
        btn_abrebanco = new javax.swing.JButton();
        btn_execultaconsulta = new javax.swing.JButton();
        btn_mostratabela = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_commit = new javax.swing.JButton();
        btn_rollback = new javax.swing.JButton();
        btn_pupdate = new javax.swing.JButton();
        btn_sp1 = new javax.swing.JButton();
        btn_sp2 = new javax.swing.JButton();
        btn_sp3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();

        setTitle("Acessando Banco de Dados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(null);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Id:");
        getContentPane().add(label1);
        label1.setBounds(0, 80, 70, 20);

        labelid.setName("labelid"); // NOI18N
        getContentPane().add(labelid);
        labelid.setBounds(80, 80, 100, 20);

        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("nome:");
        getContentPane().add(label3);
        label3.setBounds(0, 110, 70, 20);

        label4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label4.setText("Idade:");
        getContentPane().add(label4);
        label4.setBounds(0, 140, 70, 20);

        label5.setText("fone:");
        getContentPane().add(label5);
        label5.setBounds(260, 140, 32, 20);

        label6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label6.setText("e-mail:");
        getContentPane().add(label6);
        label6.setBounds(0, 170, 70, 20);

        labelnome.setName("labelnome"); // NOI18N
        getContentPane().add(labelnome);
        labelnome.setBounds(80, 110, 270, 20);

        labelidade.setName("labelidade"); // NOI18N
        getContentPane().add(labelidade);
        labelidade.setBounds(80, 140, 140, 20);

        labelemail.setName("labelemail"); // NOI18N
        getContentPane().add(labelemail);
        labelemail.setBounds(80, 170, 270, 20);

        labelfone.setName("labelfone"); // NOI18N
        getContentPane().add(labelfone);
        labelfone.setBounds(300, 140, 150, 20);

        btn_primeiro.setLabel("Primeiro");
        btn_primeiro.setName("btnprimeiro"); // NOI18N
        btn_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primeiroActionPerformed(evt);
            }
        });
        getContentPane().add(btn_primeiro);
        btn_primeiro.setBounds(40, 40, 130, 24);

        btn_proximo.setLabel("Próximo");
        btn_proximo.setName("btnproximo"); // NOI18N
        btn_proximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_proximoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_proximo);
        btn_proximo.setBounds(310, 40, 130, 24);

        btn_anterior.setLabel("Anterior");
        btn_anterior.setName("btnanterior"); // NOI18N
        btn_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btn_anterior);
        btn_anterior.setBounds(180, 40, 120, 24);

        btn_ultimo.setLabel("Último");
        btn_ultimo.setName("btnultimo"); // NOI18N
        btn_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ultimo);
        btn_ultimo.setBounds(450, 40, 120, 24);

        btn_abrebanco.setLabel("Abre BD");
        btn_abrebanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrebancoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_abrebanco);
        btn_abrebanco.setBounds(10, 290, 100, 24);

        btn_execultaconsulta.setLabel("Executa Consulta");
        btn_execultaconsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_execultaconsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_execultaconsulta);
        btn_execultaconsulta.setBounds(330, 290, 180, 24);

        btn_mostratabela.setLabel("mostra tabela");
        btn_mostratabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostratabelaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_mostratabela);
        btn_mostratabela.setBounds(120, 290, 200, 24);

        btn_update.setLabel("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_update);
        btn_update.setBounds(10, 420, 110, 24);

        btn_commit.setLabel("Commit");
        btn_commit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_commitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_commit);
        btn_commit.setBounds(280, 420, 120, 24);

        btn_rollback.setLabel("Rollback");
        btn_rollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rollbackActionPerformed(evt);
            }
        });
        getContentPane().add(btn_rollback);
        btn_rollback.setBounds(410, 420, 140, 24);

        btn_pupdate.setLabel("P-Update");
        btn_pupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pupdateActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pupdate);
        btn_pupdate.setBounds(130, 420, 140, 24);

        btn_sp1.setLabel("SP1");
        btn_sp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sp1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sp1);
        btn_sp1.setBounds(10, 470, 100, 24);

        btn_sp2.setLabel("SP2");
        btn_sp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sp2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sp2);
        btn_sp2.setBounds(120, 470, 120, 24);

        btn_sp3.setLabel("SP3");
        btn_sp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sp3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_sp3);
        btn_sp3.setBounds(250, 470, 130, 24);

        textArea2.setText("insert into clientes (nome, fone, email, idade) values ('nome3', 'fone2', 'email2', 2)");
        jScrollPane1.setViewportView(textArea2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 330, 560, 80);

        textArea1.setText("SELECT * from clientes order by idade desc");
        jScrollPane2.setViewportView(textArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 200, 560, 80);

        setSize(new java.awt.Dimension(590, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_rollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rollbackActionPerformed
        try {
            connection.rollback();
        } catch (SQLException erro) {
            System.out.println("Erro Roolback = " + erro);
        }
    }//GEN-LAST:event_btn_rollbackActionPerformed

    private void btn_commitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_commitActionPerformed
        try {
            connection.commit();
        } catch (SQLException erro) {
            System.out.println("Erro commit = " + erro);
        }
    }//GEN-LAST:event_btn_commitActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        ExecutaUpdate();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_mostratabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostratabelaActionPerformed
        try {
            ExibeTabela();
            MovPrimeiro();
        } catch (SQLException erro) {
            System.out.println("Erro Exibe Tabela = " + erro);
        }
    }//GEN-LAST:event_btn_mostratabelaActionPerformed

    private void btn_execultaconsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_execultaconsultaActionPerformed
        ExecutaQuery();
    }//GEN-LAST:event_btn_execultaconsultaActionPerformed

    private void btn_abrebancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrebancoActionPerformed
        if (AcessaBD()) {
            ExecutaQuery();
            MovPrimeiro();
            ExibeRegistro();
        }
    }//GEN-LAST:event_btn_abrebancoActionPerformed

    private void btn_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorActionPerformed
        MovAnterior();
    }//GEN-LAST:event_btn_anteriorActionPerformed

    private void btn_proximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_proximoActionPerformed
        MovProximo();
    }//GEN-LAST:event_btn_proximoActionPerformed

    private void btn_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimoActionPerformed
        MovUltimo();
    }//GEN-LAST:event_btn_ultimoActionPerformed

    private void btn_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primeiroActionPerformed
        MovPrimeiro();
    }//GEN-LAST:event_btn_primeiroActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        Sair();
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void btn_pupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pupdateActionPerformed
        ExecutaPUpdate();
    }//GEN-LAST:event_btn_pupdateActionPerformed

    private void btn_sp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sp1ActionPerformed
        ExecutaStoredProcedure1();
    }//GEN-LAST:event_btn_sp1ActionPerformed

    private void btn_sp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sp2ActionPerformed
        ExecutaStoredProcedure2();
    }//GEN-LAST:event_btn_sp2ActionPerformed

    private void btn_sp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sp3ActionPerformed
        ExecutaStoredProcedure3();
    }//GEN-LAST:event_btn_sp3ActionPerformed

    public void MovProximo() {
        try {
            if (rsdados != null) {
                if (!rsdados.isLast()) {
                    rsdados.next();
                    ExibeRegistro();
                } else {
                    JOptionPane.showMessageDialog(this, "Nao existe proximo elemento.");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

    public void MovAnterior() {
        try {
            if (rsdados != null) {
                if (!rsdados.isFirst()) {
                    rsdados.previous();
                    ExibeRegistro();
                } else {
                    JOptionPane.showMessageDialog(this, "Nao existe registro anterior.");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

    public void MovUltimo() {
        try {
            if (rsdados != null) {
                if (!rsdados.isLast()) {
                    rsdados.last();
                    ExibeRegistro();
                } else {
                    JOptionPane.showMessageDialog(this, "O ultimo registro ja esta selecionado.");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

    public void MovPrimeiro() {
        try {
            if (rsdados != null) {
                if (!rsdados.isFirst()) {
                    rsdados.first();
                    ExibeRegistro();
                } else {
                    JOptionPane.showMessageDialog(this, "O primeiro registro ja esta selecionado.");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

    public void ExibeRegistro() {
        try {
            //faz a leitura do registro corrento do ResutSet e atribui os valores lidos aos objetos visuais (Textfields)
            labelid.setText(String.valueOf(rsdados.getInt("id")));
            labelnome.setText(rsdados.getString("nome"));
            labelidade.setText(String.valueOf(rsdados.getInt("idade")));
            labelfone.setText(rsdados.getString("fone"));
            labelemail.setText(rsdados.getString("email"));
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }

    public boolean AcessaBD() {
        try {
            String path = System.getProperty("user.dir");
            File config_file = new File(path, "configuracaobd.properties");
            JDBCUtil.init(config_file);

            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);//configuracao necessaria para confirmacao ou nao de alteracoes no banco de dados.

            DatabaseMetaData dbmt = connection.getMetaData();
            System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());
            System.out.println("Versao do BD: " + dbmt.getDatabaseProductVersion());
            System.out.println("URL: " + dbmt.getURL());
            System.out.println("Driver: " + dbmt.getDriverName());
            System.out.println("Versao Driver: " + dbmt.getDriverVersion());
            System.out.println("Usuario: " + dbmt.getUserName());

        } catch (ClassNotFoundException erro) {
            System.out.println("Falha ao carregar o driver JDBC." + erro);
            return false;
        } catch (IOException erro) {
            System.out.println("Falha ao carregar o arquivo de configuração." + erro);
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha na conexao, comando sql = " + erro);
            return false;
        }
        return true;
    }

    public void ExecutaUpdate() {
        try {
            String sqldml = textArea2.getText();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stdados = connection.createStatement(tipo, concorrencia);
            int resposta = stdados.executeUpdate(sqldml);
            //String sql = "create table, drop table. alter table";
            //stdados.execute(sql);
            System.out.println("Resposta do Update = " + resposta);
            JOptionPane.showMessageDialog(this, "Resposta do Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa Update = " + erro);
        }
    }

    public void ExecutaQuery() {
        try {
            String sqldql = textArea1.getText();
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            stdados = connection.createStatement(tipo, concorrencia);
            rsdados = stdados.executeQuery(sqldql);
        } catch (SQLException erro) {
            System.out.println("Erro Executa Query = " + erro);
        }
    }

    public void ExecutaPUpdate() {
        try {
            String sqldml = "Insert into "
                    + "clientes (id, nome, fone, email, idade) "
                    + "values (?, ?, ?, ?, ?)";

            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            pstdados = connection.prepareStatement(sqldml, tipo, concorrencia);

            int id = Integer.valueOf(JOptionPane.showInputDialog("Entre com o id: "));
            pstdados.setInt(1, id);

            String nome = JOptionPane.showInputDialog("Entre com o nome: ");
            pstdados.setString(2, nome);

            String fone = JOptionPane.showInputDialog("Entre com o fone: ");
            pstdados.setString(3, fone);

            String email = JOptionPane.showInputDialog("Entre com o e-mail: ");
            pstdados.setString(4, email);

            int idade = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade: "));
            pstdados.setInt(5, idade);

            int resposta = pstdados.executeUpdate();

            System.out.println("Resposta do P-Update = " + resposta);

            JOptionPane.showMessageDialog(null, "Resposta do P-Update = " + resposta);
        } catch (SQLException erro) {
            System.out.println("Erro Executa P-Update = " + erro);
        }
    }

    public void ExecutaStoredProcedure1() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            CallableStatement cstdados = connection.prepareCall(
                    "{call consultaclientesemail()}", tipo, concorrencia);
            rsdados = cstdados.executeQuery();
            ExibeTabela();
        } catch (SQLException erro) {
            System.out.println("Erro Executa StoredProcedure = " + erro);
        }
    }

    public void ExecutaStoredProcedure2() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;
            int concorrencia = ResultSet.CONCUR_UPDATABLE;

            cstdados = connection.prepareCall(
                    "{call consultamaioridade(?)}",
                    tipo, concorrencia);

            int idademinima = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Entre com a idade minima: ", 18));

            cstdados.setInt(1, idademinima);

            rsdados = cstdados.executeQuery();
            ExibeTabela();

        } catch (SQLException erro) {
            System.out.println("Erro Executa StoredProcedure2 = " + erro);
        } catch (NumberFormatException erro) {
            System.out.println("Erro na conversão numérica = " + erro);
        }
    }

    public void ExecutaStoredProcedure3() {
        try {
            int tipo = ResultSet.TYPE_SCROLL_SENSITIVE;//(c)
            int concorrencia = ResultSet.CONCUR_UPDATABLE;
            cstdados = connection.prepareCall("{call inserecliente(?,?,?,?,?)}", tipo, concorrencia);

            int id = Integer.valueOf(JOptionPane.showInputDialog("Entre com o id: "));
            cstdados.setInt(1, id);

            String nome = JOptionPane.showInputDialog("Entre com o nome: ");
            cstdados.setString(2, nome);

            int idade = Integer.valueOf(JOptionPane.showInputDialog("Entre com a idade: "));
            cstdados.setInt(3, idade);

            String fone = JOptionPane.showInputDialog("Entre com o fone: ");
            cstdados.setString(4, fone);

            String email = JOptionPane.showInputDialog("Entre com o e-mail: ");
            cstdados.setString(5, email);

            cstdados.executeUpdate();

        } catch (NumberFormatException erro) {
            System.err.println("Erro na conversão numérica = " + erro);
        } catch (SQLException erro) {
            System.err.println("Erro Executa StoredProcedure3 = " + erro);
        }
    }

    public void Sair() {
        try {
            if (rsdados != null) {
                rsdados.close();
                stdados.close();
                connection.close();
            }
        } catch (SQLException erro) {
            System.out.println("Nao foi possivel a desconexao." + erro);
        }
    }

    private void ExibeTabela() throws SQLException {
        Vector cabecalhos = new Vector();
        Vector registros = new Vector();
        if (!rsdados.first()) {
            atualizaTabela(cabecalhos, registros);
            JOptionPane.showMessageDialog(this, "O ResultSet esta vazio.");
            return;
        }
        try {
            //obtem as informacoes sobre o banco de dados.
            DatabaseMetaData dbmt = connection.getMetaData();
            System.out.println("Nome do BD: " + dbmt.getDatabaseProductName());

            // obtem titulos de coluna
            ResultSetMetaData rsmd = rsdados.getMetaData();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                cabecalhos.addElement(rsmd.getColumnName(i));
            }
            // obtem dados da linha
            do {
                registros.addElement(ProximoRegistro(rsdados, rsmd));
            } while (rsdados.next());
            atualizaTabela(cabecalhos, registros);

        } catch (SQLException erro) {
            System.out.println("Erro Exibe Tabela = " + erro);
        }
    }

    public void atualizaTabela(Vector cabecalhos, Vector registros) {
        if (tabela != null) {
            remove(tabela);
            remove(scroller);
        }
        tabela = new JTable(registros, cabecalhos);
        // exibe a tabela com conteudos de ResultSet
        scroller = new JScrollPane(tabela);
        add(scroller);
        scroller.setBounds(10, 530, 550, 160);
        validate();
    }

    private Vector ProximoRegistro(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        Vector registro = new Vector();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            //A classe Types eh uma classo do pacote java.sql
            if (rsmd.getColumnType(i) == Types.VARCHAR
                    || rsmd.getColumnClassName(i).equalsIgnoreCase("java.lang.String")) {//para string
                registro.addElement(rs.getString(i));
            } else if (rsmd.getColumnType(i) == Types.INTEGER) {//para inteiros
                registro.addElement(new Long(rs.getLong(i)));
            } else {
                //tratamento para os tipos que serao lidos do banco de dados.
            }
        }
        return registro;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrebanco;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JButton btn_commit;
    private javax.swing.JButton btn_execultaconsulta;
    private javax.swing.JButton btn_mostratabela;
    private javax.swing.JButton btn_primeiro;
    private javax.swing.JButton btn_proximo;
    private javax.swing.JButton btn_pupdate;
    private javax.swing.JButton btn_rollback;
    private javax.swing.JButton btn_sp1;
    private javax.swing.JButton btn_sp2;
    private javax.swing.JButton btn_sp3;
    private javax.swing.JButton btn_ultimo;
    private javax.swing.JButton btn_update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel labelemail;
    private javax.swing.JLabel labelfone;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelidade;
    private javax.swing.JLabel labelnome;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textArea2;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
        new AcessaBD2().show();
    }
}
