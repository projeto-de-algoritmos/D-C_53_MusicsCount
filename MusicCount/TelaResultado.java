package MusicCount;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class TelaResultado {

    private static Pessoa pessoaGosto = new Pessoa();
    private static final JFrame janela = new JFrame();

    private static final JPanel salvarPanel = new JPanel();
    private static final JButton salvarButton = new JButton();

    private static final JLabel tituloLabel = new JLabel();

    private static final JSlider satisfactionSlider = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel = new JLabel("(ROCK)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider1 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel1 = new JLabel("(POP)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider2 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel2 = new JLabel("(FUNK)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider3 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel3 = new JLabel("(FORRÓ)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider4 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel4 = new JLabel("(AXÉ)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider5 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel5 = new JLabel("(COUNTRY)- Satisfação: " + satisfactionSlider.getValue());

    private static final JSlider satisfactionSlider7 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel7 = new JLabel("(MPB)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider8 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel8 = new JLabel("(PAGODE)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider9 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel9 = new JLabel("(JAZZ)- Satisfação: " + satisfactionSlider.getValue());
    private static final JSlider satisfactionSlider10 = new JSlider(0, 9); // Intervalo de 0 a 10
    private static final JLabel satisfactionLabel10 = new JLabel("(RAP)- Satisfação: " + satisfactionSlider.getValue());
    
    private static final MouseAdapter click = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {

            //SALVAR MUDANCAS EM UM CLIENTE EXISTENTE
            if (e.getSource() == salvarButton) {
                pessoaGosto.setNome("Usuario");
                pessoaGosto.setRock(satisfactionSlider.getValue());
                pessoaGosto.setPop(satisfactionSlider1.getValue());
                pessoaGosto.setFunk(satisfactionSlider2.getValue());
                pessoaGosto.setForro(satisfactionSlider3.getValue());
                pessoaGosto.setAxe(satisfactionSlider4.getValue());
                pessoaGosto.setCountry(satisfactionSlider5.getValue());
                pessoaGosto.setMpb(satisfactionSlider7.getValue());
                pessoaGosto.setPagode(satisfactionSlider8.getValue());
                pessoaGosto.setJazz(satisfactionSlider9.getValue());
                pessoaGosto.setRap(satisfactionSlider10.getValue());

                new Main(1);
                janela.dispose();
            }
        }
    };

    public TelaResultado() {

        janela.setLayout(null);
        janela.setVisible(true);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setBackground(new Color(50,200,200));
        janela.setSize(535, 565);
        janela.setLocationRelativeTo(null);

        tituloLabel.setText("DEFINA SEU GOSTO MUSICAL");
        tituloLabel.setBounds(115, 2, 430, 25);
        tituloLabel.setFont(new Font("Consolas", Font.ITALIC, 23));


        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);

        sliderConfig(satisfactionSlider, satisfactionLabel, "ROCK", 50, 40);
        sliderConfig(satisfactionSlider1, satisfactionLabel1, "POP", 275, 40);
        sliderConfig(satisfactionSlider2, satisfactionLabel2, "FUNK", 50, 120);
        sliderConfig(satisfactionSlider3, satisfactionLabel3, "FORRÓ", 275, 120);
        sliderConfig(satisfactionSlider4, satisfactionLabel4, "AXÉ", 50, 200);
        sliderConfig(satisfactionSlider5, satisfactionLabel5, "COUNTRY", 275, 200);

        sliderConfig(satisfactionSlider7, satisfactionLabel7, "MPB", 275, 280);
        sliderConfig(satisfactionSlider8, satisfactionLabel8, "PAGODE", 50, 360);
        sliderConfig(satisfactionSlider9, satisfactionLabel9, "JAZZ", 275, 360);
        sliderConfig(satisfactionSlider10, satisfactionLabel10, "RAP", 50, 440);

        salvarPanel.setBorder(BorderFactory.createLineBorder(new Color(20,1,154),3));

        salvarButton.removeMouseListener(click);
        salvarButton.setBounds(275,440, 200,50);
        salvarButton.setBackground(new Color(101, 240, 154));
        salvarButton.setFocusable(false);
        salvarButton.addMouseListener(click);
        salvarButton.setText("SALVAR");
        salvarButton.setFont(new Font("Consolas", Font.ITALIC, 23));

        janela.add(salvarButton);
        janela.add(tituloLabel);
        janela.setVisible(true);
    }

    private void sliderConfig(JSlider slider, JLabel sliderLabel, String nome, int x, int y){

        slider.setBounds(x, y, 200, 50); // Posicionamento e tamanho do slider
        sliderLabel.setBounds(x+20, y+50, 200, 30); // Posicionamento e tamanho do rótulo

        slider.setMajorTickSpacing(1); // Marcas principais a cada incremento de 1
        slider.setPaintTicks(true); // Exibe as marcas no slider
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = slider.getValue();
                sliderLabel.setText("("+nome+")Satisfação: " + value);
            }
        });

        janela.add(slider);
        janela.add(sliderLabel);
    }

    public static String[] getPessoaGosto() {
        String[] dadosPessoas = new String[11];

        dadosPessoas[0] = String.valueOf(pessoaGosto.getNome());
        dadosPessoas[1] = String.valueOf(pessoaGosto.getRock());
        dadosPessoas[2] = String.valueOf(pessoaGosto.getPop());
        dadosPessoas[3] = String.valueOf(pessoaGosto.getFunk());
        dadosPessoas[4] = String.valueOf(pessoaGosto.getForro());
        dadosPessoas[5] = String.valueOf(pessoaGosto.getAxe());
        dadosPessoas[6] = String.valueOf(pessoaGosto.getCountry());
        dadosPessoas[7] = String.valueOf(pessoaGosto.getMpb());
        dadosPessoas[8] = String.valueOf(pessoaGosto.getPagode());
        dadosPessoas[9] = String.valueOf(pessoaGosto.getJazz());
        dadosPessoas[10] = String.valueOf(pessoaGosto.getRap());

        return dadosPessoas;
    }
}
