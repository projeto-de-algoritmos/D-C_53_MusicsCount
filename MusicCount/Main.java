package MusicCount;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    private static final Dados dados = new Dados();
    private static final JFrame janela = new JFrame();
    //BOTOES
    private static final JPanel botao1Panel = new JPanel();
    private static final JButton botao1Button = new JButton();
    private static final JLabel botao1Label = new JLabel();

    private static final JLabel labelPessoa = new JLabel();
    private static final JScrollPane scroll = new JScrollPane();
    private static final JTable tabelaPessoas = new JTable();
    
    private static final JPanel painel = new JPanel();
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            //evento clique no botao cliente
            if(e.getSource() == botao1Button){
                new TelaResultado();
                janela.dispose();
            }
        }
    };

    public static void main(String[] args) {
        new Main(0);
    }
    public Main(int num){

        janela.setLayout(null);

        //definicoes da janela
        janela.setSize(1000,700);
        janela.setLocationRelativeTo(null);
        janela.setTitle("Menu Principal");
        janela.getContentPane().setBackground(new Color(50,200,200));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setVisible(true);
        janela.add(labelPessoa);
        janela.add(painel);
        janela.add(botao1Panel);

        //CRIANDO INSTANCIAS

        ModelTablePessoas dadosTabela;

        if(num == 0){
            dados.autoCadastro();
            dadosTabela = new ModelTablePessoas(Controlador.dadosTabela(dados));
            tabelaPessoas.setModel(dadosTabela);
        }
        else{
            dadosTabela = new ModelTablePessoas(Controlador.dadosTabelaInverscoes(dados));
            tabelaPessoas.setModel(dadosTabela);
        }

        //CONFIGURAÇÕES DA TABELA

        scroll.setViewportView(tabelaPessoas);
        painel.add(scroll);

        //PANEL DA TABELA
        painel.setLayout(new GridLayout());
        painel.setBorder(BorderFactory.createLineBorder(new Color(20,1,154), 5));
        painel.setBounds(25, 25, 935, 515);

        //DEFINIÇÕES DA TABELA
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabelaPessoas.removeMouseListener(click);
        tabelaPessoas.getTableHeader().setReorderingAllowed(false);
        tabelaPessoas.getTableHeader().setResizingAllowed(false);
        tabelaPessoas.getTableHeader().setBackground(new Color(101, 240, 154));
        tabelaPessoas.getTableHeader().setForeground(Color.black);
        tabelaPessoas.getTableHeader().setFont(new Font("Consolas", Font.BOLD, 15));
        tabelaPessoas.setSelectionBackground(new Color(250, 244, 154));
        tabelaPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaPessoas.setFont(new Font("Consolas", Font.BOLD, 11));
        tabelaPessoas.setBackground(new Color(218, 230, 233));
        tabelaPessoas.setRowHeight(22);
        tabelaPessoas.getColumnModel().getColumn(1).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(5).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(7).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(8).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(9).setCellRenderer(cellRenderer);
        tabelaPessoas.getColumnModel().getColumn(10).setCellRenderer(cellRenderer);

        tabelaPessoas.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(2).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(3).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(4).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(5).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(6).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(7).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(8).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(9).setPreferredWidth(10);
        tabelaPessoas.getColumnModel().getColumn(10).setPreferredWidth(10);

        tabelaPessoas.setFocusable(false);
        tabelaPessoas.addMouseListener(click);

        //TITULO DA LISTA
        labelPessoa.setText("LISTA DE PESSOAS");
        labelPessoa.setBounds(395, 2, 230, 25);
        labelPessoa.setFont(new Font("Consolas", Font.ITALIC, 23));

        painelBotoes();
    }

    public void painelBotoes(){


        botao1Panel.setLayout(null);
        botao1Panel.setBackground(new Color(9,176,255));
        botao1Panel.setBounds(225,565, 500,72);
        botaoConfig(botao1Panel, botao1Button, botao1Label);

    }

    public static void botaoConfig(JPanel botaoPanel, JButton botaoButton, JLabel botaoLabel) {
        botaoPanel.setBorder(BorderFactory.createLineBorder(new Color(20,1,154),3));

        botaoButton.removeMouseListener(click);
        botaoButton.setBounds(6,6, 488,60);
        botaoButton.setBackground(new Color(101, 240, 154));
        botaoButton.setFocusable(false);
        botaoButton.addMouseListener(click);
        botaoButton.setText("ACHAR PESSOAS SIMILARES");
        botaoButton.setToolTipText("Clique para encontrar pessoas com gostos musicais parecidos com o seu!");
        botaoButton.setFont(new Font("Consolas", Font.ITALIC, 23));

        botaoPanel.setVisible(true);
        botaoPanel.add(botaoLabel);
        botaoPanel.add(botaoButton);
    }
}