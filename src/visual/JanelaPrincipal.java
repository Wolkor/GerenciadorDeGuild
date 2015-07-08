/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.DAOEvento;
import modelo.DAOPersonagem;
import static modelo.Dados.listaEventos;
import modelo.Evento;
import modelo.Personagem;

/**
 *
 * @author Wolkor
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    DAOPersonagem dao = new DAOPersonagem();
    DAOEvento daoE = new DAOEvento();

    //Função que vai atualizar a tabela quando abrir o programa
    public void atualizaTabela() {
        listPersonagens.clear();
        listPersonagens.addAll(dao.getLista());
        int linha = listPersonagens.size() - 1;
        if (linha >= 0) {
            tabelaPersonagens.setRowSelectionInterval(linha, linha);
            tabelaPersonagens.scrollRectToVisible(
                    tabelaPersonagens.getCellRect(linha, linha, true));
        }
    }

    public void atualizaTabelaEventos() {
        listEventos.clear();
        listEventos.addAll(daoE.getLista());
        int linha = listEventos.size() - 1;
        if (linha >= 0) {
            tabelaEventos.setRowSelectionInterval(linha, linha);
            tabelaEventos.scrollRectToVisible(tabelaEventos.getCellRect(linha, linha, true));
        }
    }

    private void trataEdicao(boolean editando) {
        btnCancelar.setEnabled(editando);
        btnSalvar.setEnabled(editando);
        btnEditar.setEnabled(!editando);
        btnExcluir.setEnabled(!editando);
        btnNovo.setEnabled(!editando);
        abaTabPersonagens.setEnabled(!editando);
        abaTabEventos.setEnabled(!editando);
        txtNomePersonagem.setEnabled(editando);
        txtNomeJogador.setEnabled(editando);
        txtLvPersonagem.setEnabled(editando);
        txtLvProfissao.setEnabled(editando);
        campoRaca.setEnabled(editando);
        campoClasse.setEnabled(editando);
        campoProfissao.setEnabled(editando);
        campoEspecialidade.setEnabled(editando);
        tabelaPersonagens.setEnabled(!editando);
        btnSalvaEvento.setEnabled(editando);
        btnExcluiEvento.setEnabled(!editando);
        btnPesquisaEvento.setEnabled(!editando);
        btnCancelaCriacao.setEnabled(editando);
        boxDiaPersonagem.setEnabled(editando);
        boxHorarioPersonagem.setEnabled(editando);
    }

    public boolean validaCampos() {
        if (!(txtNomePersonagem.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        if (!(txtNomeJogador.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        if (!(txtLvPersonagem.getText().length() > 0)) {
            try{
                Integer.parseInt(txtLvPersonagem.getText());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
                txtLvPersonagem.requestFocus();
                return false;
            }
        }
        if (!(txtLvProfissao.getText().length() > 0)) {
            try{
                Integer.parseInt(txtLvProfissao.getText());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
                txtLvProfissao.requestFocus();
                return false;
            }
        }
        if (!(campoClasse.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        if (!(campoRaca.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        if (!(campoProfissao.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        if (!(campoEspecialidade.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos do cadastro!");
            return false;
        }
        return true;
    }

    public boolean validaPesquisa() {
        if (pegaTamanhoGrupo() != (pegaTank() + pegaHealer() + pegaMdps() + pegaRdps())) {
            JOptionPane.showMessageDialog(null, "Reveja as configurações de seu evento!");
            return false;
        }
        if (!(boxTamanhoGrupo.getSelectedIndex() >= 0)){
            try{
                Integer.parseInt((String) boxTamanhoGrupo.getSelectedItem());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Reveja as configurações de seu evento!");
                trataEdicao(true);
                return false;
            }
        }
       
        try {
            Integer.parseInt(txtTankers.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Reveja as configurações de seu evento!");
            txtTankers.requestFocus();
            return false;
        }
        
        if ((txtHealers.getText().length() > 0)) {
            try{
                Integer.parseInt(txtHealers.getText());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Reveja as configurações de seu evento!");
                txtHealers.requestFocus();
                return false;
            }
        }
        if ((txtMdps.getText().length() > 0)) {
            try{
                Integer.parseInt(txtMdps.getText());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Reveja as configurações de seu evento!");
                txtMdps.requestFocus();
                return false;
            }
        }
        return true;
    }

    public int pegaTamanhoGrupo() {
        return Integer.parseInt((String) boxTamanhoGrupo.getSelectedItem());
    }

    public int pegaTank() {
        return Integer.parseInt(txtTankers.getText());
    }

    public int pegaHealer() {
        return Integer.parseInt(txtHealers.getText());
    }

    public int pegaMdps() {
        return Integer.parseInt(txtMdps.getText());
    }

    public int pegaRdps() {
        return Integer.parseInt(txtRdps.getText());
    }
    
    public int convertHorario(){
        return Integer.parseInt((String) boxHorarioPersonagem.getSelectedItem());
    }

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
        atualizaTabela();
        atualizaTabelaEventos();
        trataEdicao(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        listPersonagens = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Personagem>())
        ;
        listEventos = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Evento>())
        ;
        abaEventos = new javax.swing.JTabbedPane();
        abaTabPersonagens = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPersonagens = new javax.swing.JTable();
        abaEdicao = new javax.swing.JPanel();
        opEdicao = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNomePersonagem = new javax.swing.JTextField();
        txtNomeJogador = new javax.swing.JTextField();
        campoRaca = new javax.swing.JComboBox();
        campoClasse = new javax.swing.JComboBox();
        campoProfissao = new javax.swing.JComboBox();
        campoEspecialidade = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLvPersonagem = new javax.swing.JTextField();
        txtLvProfissao = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        boxDiaPersonagem = new javax.swing.JComboBox();
        boxHorarioPersonagem = new javax.swing.JComboBox();
        abaTabEventos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEventos = new javax.swing.JTable();
        abaCriacaoEventos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        boxTamanhoGrupo = new javax.swing.JComboBox();
        txtTankers = new javax.swing.JTextField();
        txtHealers = new javax.swing.JTextField();
        txtMdps = new javax.swing.JTextField();
        txtRdps = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnPesquisaEvento = new javax.swing.JButton();
        btnCancelaCriacao = new javax.swing.JButton();
        btnSalvaEvento = new javax.swing.JButton();
        btnExcluiEvento = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtNomeEvento = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");

        abaTabPersonagens.setLayout(new java.awt.BorderLayout());

        tabelaPersonagens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listPersonagens, tabelaPersonagens);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomePersonagem}"));
        columnBinding.setColumnName("Nome Personagem");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${levelPersonagem}"));
        columnBinding.setColumnName("Level Personagem");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${classe}"));
        columnBinding.setColumnName("Classe");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${raca}"));
        columnBinding.setColumnName("Raça");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${profissao}"));
        columnBinding.setColumnName("Profissao");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${levelEspecialidade}"));
        columnBinding.setColumnName("Level Profissão");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${especialidade}"));
        columnBinding.setColumnName("Especialidade");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeJogador}"));
        columnBinding.setColumnName("Nome Jogador");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dias}"));
        columnBinding.setColumnName("Dia");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${horario}"));
        columnBinding.setColumnName("Horario");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tabelaPersonagens);

        abaTabPersonagens.add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        abaEventos.addTab("Personagens", abaTabPersonagens);

        opEdicao.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        opEdicao.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        opEdicao.add(btnEditar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        opEdicao.add(btnCancelar);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        opEdicao.add(btnSalvar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        opEdicao.add(btnExcluir);

        jLabel1.setText("Nome do jogador");

        jLabel2.setText("Nome do Personagem");

        jLabel3.setText("Classe");

        jLabel4.setText("Profissão");

        jLabel5.setText("Raça");

        jLabel6.setText("Especialidade");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomePersonagem}"), txtNomePersonagem, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomeJogador}"), txtNomeJogador, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        campoRaca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Humano", "Elfo", "Ogro", "Anão", "Besta" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.raca}"), campoRaca, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoClasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Guerreiro", "Mago", "Assassino", "Domador", "Atirador" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.classe}"), campoClasse, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoProfissao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Armeiro", "Ferreiro", "Herbolista", "Veterinario", "Médico" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.profissao}"), campoProfissao, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoProfissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProfissaoActionPerformed(evt);
            }
        });

        campoEspecialidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "tanker", "healer", "mdps", "rdps" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.especialidade}"), campoEspecialidade, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        campoEspecialidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEspecialidadeActionPerformed(evt);
            }
        });

        jLabel7.setText("Lv");

        jLabel8.setText("Lv");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.levelPersonagem}"), txtLvPersonagem, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.levelProfissao}"), txtLvProfissao, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel17.setText("Dia da semana");

        jLabel18.setText("Horarios neste dia");

        boxDiaPersonagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domindo", " " }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.dias}"), boxDiaPersonagem, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        boxHorarioPersonagem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaPersonagens, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horario}"), boxHorarioPersonagem, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeJogador)
                    .addComponent(campoEspecialidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoProfissao, 0, 148, Short.MAX_VALUE)
                    .addComponent(campoClasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoRaca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNomePersonagem))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLvPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(txtLvProfissao))
                .addGap(66, 66, 66)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(35, 35, 35)
                        .addComponent(boxDiaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(boxHorarioPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLvPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxDiaPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(boxHorarioPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLvProfissao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout abaEdicaoLayout = new javax.swing.GroupLayout(abaEdicao);
        abaEdicao.setLayout(abaEdicaoLayout);
        abaEdicaoLayout.setHorizontalGroup(
            abaEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaEdicaoLayout.createSequentialGroup()
                .addGroup(abaEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opEdicao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(abaEdicaoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        abaEdicaoLayout.setVerticalGroup(
            abaEdicaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaEdicaoLayout.createSequentialGroup()
                .addComponent(opEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        abaEventos.addTab("Edição de personagens", abaEdicao);

        abaTabEventos.setLayout(new java.awt.BorderLayout());

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listEventos, tabelaEventos);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nomeEvento}"));
        columnBinding.setColumnName("Nome Evento");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${grupo}"));
        columnBinding.setColumnName("Grupo");
        columnBinding.setColumnClass(java.util.ArrayList.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tamanho}"));
        columnBinding.setColumnName("Tamanho");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dias}"));
        columnBinding.setColumnName("Dias");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hora}"));
        columnBinding.setColumnName("Hora");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tabelaEventos);

        abaTabEventos.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        abaEventos.addTab("Eventos", abaTabEventos);

        abaCriacaoEventos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Tamanho do grupo");

        jLabel10.setText("Número de tankers");

        jLabel11.setText("Número de healers");

        jLabel12.setText("Número de mdps");

        jLabel13.setText("Número de rdps");

        jLabel14.setText("Dia");

        jLabel15.setText("Hora");

        boxTamanhoGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "5", "10", "25" }));

        txtTankers.setText("0");

        txtHealers.setText("0");

        txtMdps.setText("0");

        txtRdps.setText("0");

        jPanel1.setLayout(new java.awt.GridLayout());

        btnPesquisaEvento.setText("Pesquisar");
        btnPesquisaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaEventoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisaEvento);

        btnCancelaCriacao.setText("Cancelar");
        btnCancelaCriacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaCriacaoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelaCriacao);

        btnSalvaEvento.setText("Salvar");
        btnSalvaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaEventoActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvaEvento);

        btnExcluiEvento.setText("Excluir");
        btnExcluiEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiEventoActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluiEvento);

        jLabel16.setText("Nome do evento");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabelaEventos, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nomeEvento}"), txtNomeEvento, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "segunda", "terça", "quarta", "quinta", "sexta", "sábado", "domindo" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));

        javax.swing.GroupLayout abaCriacaoEventosLayout = new javax.swing.GroupLayout(abaCriacaoEventos);
        abaCriacaoEventos.setLayout(abaCriacaoEventosLayout);
        abaCriacaoEventosLayout.setHorizontalGroup(
            abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel13))
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addGap(36, 36, 36)
                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addComponent(boxTamanhoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRdps, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMdps, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHealers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTankers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaCriacaoEventosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(127, 127, 127))))))
        );
        abaCriacaoEventosLayout.setVerticalGroup(
            abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(boxTamanhoGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNomeEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaCriacaoEventosLayout.createSequentialGroup()
                                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTankers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHealers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(abaCriacaoEventosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                            .addComponent(txtMdps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(abaCriacaoEventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addComponent(txtRdps, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        abaEventos.addTab("Criação de eventos", abaCriacaoEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abaEventos)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        listPersonagens.add((Personagem) new Personagem());
        int linha = listPersonagens.size() - 1;
        tabelaPersonagens.setRowSelectionInterval(linha, linha);
        trataEdicao(true);
        txtNomePersonagem.requestFocus();      
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaCampos()) {
            int linhaSelecionada = tabelaPersonagens.getSelectedRow();
            Personagem personagem = listPersonagens.get(linhaSelecionada);
            dao.salvar(personagem);
            trataEdicao(false);
            atualizaTabela();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        trataEdicao(false);
        atualizaTabela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (listPersonagens.isEmpty() == false) {
            trataEdicao(true);
            txtNomePersonagem.requestFocus();
        }
        if (listPersonagens.isEmpty() == true) {
            JOptionPane.showMessageDialog(null, "Tabela vazia! Cadastre-se!");
            trataEdicao(false);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (listPersonagens.isEmpty() == false) {
            int opcao
                    = JOptionPane.showOptionDialog(null,
                            "Corfirmar a exclusão?", "pergunta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Sim", "Não"}, null);
            if (opcao == 0) {
                int linhaSelecionada = tabelaPersonagens.getSelectedRow();
                Personagem personagem = listPersonagens.get(linhaSelecionada);
                dao.remover(personagem);
                atualizaTabela();
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void campoEspecialidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEspecialidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoEspecialidadeActionPerformed

    private void campoProfissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProfissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProfissaoActionPerformed

    private void btnPesquisaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaEventoActionPerformed
        if (validaPesquisa()) {
            Evento evento = new Evento();
            System.out.println(boxDiaPersonagem.getToolTipText());
            evento.setGrupo(daoE.geraGrupo(pegaTamanhoGrupo(), pegaTank(), pegaHealer(), pegaMdps(), pegaRdps(),
                    (String)boxDiaPersonagem.getSelectedItem(), (String)boxHorarioPersonagem.getSelectedItem()));
            evento.setTamanho(pegaTamanhoGrupo());
            evento.setQuantTankers(pegaHealer());
            evento.setQuantMdps(pegaMdps());
            evento.setQuantRdps(pegaRdps());
            listEventos.add(evento);
            int linha = listEventos.size() - 1;
            tabelaEventos.setRowSelectionInterval(linha, linha);
            trataEdicao(true);
        }
    }//GEN-LAST:event_btnPesquisaEventoActionPerformed

    private void btnSalvaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaEventoActionPerformed
        int linhaSelecionada = tabelaEventos.getSelectedRow();
            Evento evento = listEventos.get(linhaSelecionada);
            daoE.salvar(evento);
            trataEdicao(false);
            atualizaTabela();
    }//GEN-LAST:event_btnSalvaEventoActionPerformed

    private void btnCancelaCriacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaCriacaoActionPerformed
        trataEdicao(false);
        atualizaTabelaEventos();
    }//GEN-LAST:event_btnCancelaCriacaoActionPerformed

    private void btnExcluiEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiEventoActionPerformed
        if (listEventos.isEmpty() == false) {
            int opcao
                    = JOptionPane.showOptionDialog(null,
                            "Corfirmar a exclusão?", "pergunta",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            new String[]{"Sim", "Não"}, null);
            if (opcao == 0) {
                int linhaSelecionada = tabelaEventos.getSelectedRow();
                Evento evento = listEventos.get(linhaSelecionada);
                daoE.remover(evento);
                atualizaTabelaEventos();
            }
        }
    }//GEN-LAST:event_btnExcluiEventoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new JanelaPrincipal().setVisible(true);
                JanelaPrincipal form = new JanelaPrincipal();
                //inicializa o formulario no meio da tela
                form.setLocationRelativeTo(null);
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaCriacaoEventos;
    private javax.swing.JPanel abaEdicao;
    private javax.swing.JTabbedPane abaEventos;
    private javax.swing.JPanel abaTabEventos;
    private javax.swing.JPanel abaTabPersonagens;
    private javax.swing.JComboBox boxDiaPersonagem;
    private javax.swing.JComboBox boxHorarioPersonagem;
    private javax.swing.JComboBox boxTamanhoGrupo;
    private javax.swing.JButton btnCancelaCriacao;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluiEvento;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisaEvento;
    private javax.swing.JButton btnSalvaEvento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox campoClasse;
    private javax.swing.JComboBox campoEspecialidade;
    private javax.swing.JComboBox campoProfissao;
    private javax.swing.JComboBox campoRaca;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.util.List<Evento> listEventos;
    private java.util.List<Personagem> listPersonagens;
    private javax.swing.JPanel opEdicao;
    private javax.swing.JTable tabelaEventos;
    private javax.swing.JTable tabelaPersonagens;
    private javax.swing.JTextField txtHealers;
    private javax.swing.JTextField txtLvPersonagem;
    private javax.swing.JTextField txtLvProfissao;
    private javax.swing.JTextField txtMdps;
    private javax.swing.JTextField txtNomeEvento;
    private javax.swing.JTextField txtNomeJogador;
    private javax.swing.JTextField txtNomePersonagem;
    private javax.swing.JTextField txtRdps;
    private javax.swing.JTextField txtTankers;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
