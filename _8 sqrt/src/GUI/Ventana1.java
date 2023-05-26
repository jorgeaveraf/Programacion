package GUI;

import Logic.Ecuacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ventana1 extends JFrame {
    private JPanel panel;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton enter;
    private JTextArea vA;
    private String tA;
    private JTextArea vB;
    private String tB;
    private JTextArea vC;
    private String tC;
    public String sRP;
    private String sRN;

    public Ventana1(){
        this.setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Math class");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(350,250));

        componentes();
    }

    private void componentes(){
        paneles();
        etiquetasTop();
        etiquetasBottom();
        etiquetasCentro();
    }

    private void paneles(){
        BG= new JPanel(new BorderLayout());
        BG.setBackground(Color.decode("#39454E"));

        panel=new JPanel(new GridBagLayout());
        panel.setBackground(Color.decode("#D6D5D0"));

        encabezado = new JPanel(new GridLayout(2, 1)); // Para que el encabezado pueda tener dos etiquetas
        encabezado.setBackground(Color.decode("#39454E"));
        encabezado.setBorder(BorderFactory.createEmptyBorder(0, 10, -30, 10));//Permite acercar las etiquetas y modificar el espacio que utiliza en la ventana

        bottom = new JPanel(new GridLayout(1, 3)); // Para que el encabezado pueda tener 4 etiquetas
        bottom.setBackground(Color.decode("#39454E"));
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        //Agregamos a la ventana
        this.getContentPane().add(BG, BorderLayout.CENTER);
        BG.add(encabezado, BorderLayout.PAGE_START);
        BG.add(panel, BorderLayout.CENTER);
        BG.add(bottom,BorderLayout.PAGE_END);
    }

    private void etiquetasTop(){
        JLabel titulo = new JLabel("Ecuación", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150,65));
        titulo.setFont(new Font("Lora",Font.PLAIN,50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("De segundo grado", SwingConstants.CENTER);
        subtitulo.setPreferredSize(new Dimension(250,0));
        subtitulo.setFont(new Font("Lora",Font.PLAIN,15));
        subtitulo.setForeground(Color.decode("#D6D5D0"));
        subtitulo.setBorder(BorderFactory.createEmptyBorder(-40, 0, 0, 0));//Acerca más a esta etiqueta con el título
        encabezado.add(subtitulo);
    }

    private void etiquetasBottom(){
        JLabel terms = new JLabel("Resolución", SwingConstants.CENTER);
        terms.setPreferredSize(new Dimension(100,15));
        terms.setFont(new Font("Lora",Font.PLAIN,15));
        terms.setForeground(Color.decode("#D6D5D0"));
        terms.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(terms);

        JLabel forgot = new JLabel("Math class", SwingConstants.CENTER);
        forgot.setPreferredSize(new Dimension(100,70));
        forgot.setFont(new Font("Lora",Font.PLAIN,15));
        forgot.setForeground(Color.decode("#D6D5D0"));
        forgot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(forgot);

        JLabel sign = new JLabel("April 2023", SwingConstants.CENTER);
        sign.setPreferredSize(new Dimension(100,70));
        sign.setFont(new Font("Lora",Font.PLAIN,15));
        sign.setForeground(Color.decode("#D6D5D0"));
        sign.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(sign);
    }

    private void etiquetasCentro(){
        GridBagConstraints center = new GridBagConstraints();
        center.gridx = 0;
        center.gridy = 0;
        center.fill = GridBagConstraints.HORIZONTAL;
        center.insets = new Insets(0, 10, 0, 10);

        vA = new JTextArea();
        vA.setText("Introduce el valor de a");
        tA = vA.getText();
        vA.setFont(new Font("League Gothic Regular", Font.PLAIN, 45));
        vA.setForeground(Color.decode("#86ADA0"));
        vA.setOpaque(false);
        vA.setBorder(BorderFactory.createEmptyBorder());
        vA.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(vA, center);

        center.gridy++;
        JPanel separator = new JPanel();
        separator.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator.setPreferredSize(new Dimension(200, 2));
        panel.add(separator, center);

        center.gridy++;
        JPanel empty = new JPanel();
        empty.setBackground(Color.decode("#D6D5D0"));
        empty.setPreferredSize(new Dimension(200, 20));
        panel.add(empty, center);

        center.gridy++;
        vB = new JTextArea();
        vB.setText("Introduce el valor de b");
        tB = vB.getText();
        vB.setFont(new Font("League Gothic Regular", Font.PLAIN, 45));
        vB.setForeground(Color.decode("#86ADA0"));
        vB.setOpaque(false);
        vB.setBorder(BorderFactory.createEmptyBorder());
        vB.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(vB, center);

        center.gridy++;
        JPanel separator2 = new JPanel();
        separator2.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator2.setPreferredSize(new Dimension(200, 2));
        panel.add(separator2, center);

        center.gridy++;
        JPanel empty2 = new JPanel();
        empty2.setBackground(Color.decode("#D6D5D0"));
        empty2.setPreferredSize(new Dimension(200, 20));
        panel.add(empty2, center);

        center.gridy++;
        vC = new JTextArea();
        vC.setText("Introduce el valor de c");
        tC = vC.getText();
        vC.setFont(new Font("League Gothic Regular", Font.PLAIN, 45));
        vC.setForeground(Color.decode("#86ADA0"));
        vC.setOpaque(false);
        vC.setBorder(BorderFactory.createEmptyBorder());
        vC.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(vC, center);

        center.gridy++;
        JPanel separator3 = new JPanel();
        separator3.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator3.setPreferredSize(new Dimension(200, 2));
        panel.add(separator3, center);

        center.gridy++;
        JPanel empty3 = new JPanel();
        empty3.setBackground(Color.decode("#D6D5D0"));
        empty3.setPreferredSize(new Dimension(200, 20));
        panel.add(empty3, center);

        center.gridy++;
        enter = new JButton();
        enter.setText("Calcular");
        enter.setPreferredSize(new Dimension(70,20));
        enter.setFont(new Font("Lora",Font.PLAIN,15));
        enter.setForeground(Color.decode("#D6D5D0"));
        enter.setBorder(new RoundBorder(10));
        enter.setBackground(Color.decode("#39454E"));
        panel.add(enter, center);


        listener();
    }

    public void raiz(){
        String sA = vA.getText();
        double a = Double.parseDouble(sA);
        String sB = vB.getText();
        double b = Double.parseDouble(sB);
        String sC = vC.getText();
        double c = Double.parseDouble(sC);

        Ecuacion ecuacion = new Ecuacion();
        double dRP=ecuacion.raizP(a,b,c);
        sRP= Double.toString(dRP);

        double dRN=ecuacion.raizN(a,b,c);
        sRN= Double.toString(dRN);
    }
    private void listener(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                raiz();
                Options options = new Options();
                options.setVisible(true);
                options.actualizarEtiquetas(sRP, sRN);
                setVisible(false);
            }
        });

        vA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vA.setText("");
            }
        });

        vB.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vB.setText("");
            }
        });
        vC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vC.setText("");
            }
        });

        vA.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Tranquilo viejo, aquí solo se usan números");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        vA.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(vA.getText().equals("")){
                    vA.setText(tA);
                }
            }
        });

        vB.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Tranquilo viejo, aquí solo se usan números");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        vB.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(vB.getText().equals("")){
                    vB.setText(tB);
                }
            }
        });

        vC.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Tranquilo viejo, aquí solo se usan números");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        vC.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(vC.getText().equals("")){
                    vC.setText(tC);
                }
            }
        });
    }

    public String getsRP() {
        return sRP;
    }

    public String getsRN() {
        return sRN;
    }
}
