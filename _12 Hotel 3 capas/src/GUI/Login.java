package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JPanel panel;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton enter;
    private JTextArea user;
    private String tUser;
    private JPasswordField pass;
    private String tPass;

    public Login(){
        this.setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hotel");
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
        JLabel titulo = new JLabel("Login", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150,65));
        titulo.setFont(new Font("Lora",Font.PLAIN,50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("Enter your user and password credentials", SwingConstants.CENTER);
        subtitulo.setPreferredSize(new Dimension(250,0));
        subtitulo.setFont(new Font("Lora",Font.PLAIN,15));
        subtitulo.setForeground(Color.decode("#D6D5D0"));
        subtitulo.setBorder(BorderFactory.createEmptyBorder(-40, 0, 0, 0));//Acerca más a esta etiqueta con el título
        encabezado.add(subtitulo);
    }

    private void etiquetasBottom(){
        JLabel terms = new JLabel("Terms & Conditions", SwingConstants.CENTER);
        terms.setPreferredSize(new Dimension(100,15));
        terms.setFont(new Font("Lora",Font.PLAIN,15));
        terms.setForeground(Color.decode("#D6D5D0"));
        terms.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(terms);

        JLabel forgot = new JLabel("Forgot Password", SwingConstants.CENTER);
        forgot.setPreferredSize(new Dimension(100,70));
        forgot.setFont(new Font("Lora",Font.PLAIN,15));
        forgot.setForeground(Color.decode("#D6D5D0"));
        forgot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(forgot);

        JLabel sign = new JLabel("Sign up", SwingConstants.CENTER);
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

        user = new JTextArea();
        user.setText("User");
        tUser = user.getText();
        user.setFont(new Font("League Gothic Regular", Font.PLAIN, 75));
        user.setForeground(Color.decode("#86ADA0"));
        user.setOpaque(false);
        user.setBorder(BorderFactory.createEmptyBorder());
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user, center);

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
        pass = new JPasswordField(8);
        pass.setEchoChar('•');
        pass.setText("••••••••");
        tPass = pass.getText();
        pass.setFont(new Font("League Gothic Regular", Font.PLAIN, 75));
        pass.setForeground(Color.decode("#86ADA0"));
        pass.setOpaque(false);
        pass.setBorder(BorderFactory.createEmptyBorder());
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(pass, center);

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
        enter = new JButton();
        enter.setText("Sign in");
        enter.setPreferredSize(new Dimension(70,30));
        enter.setFont(new Font("Lora",Font.PLAIN,15));
        enter.setForeground(Color.decode("#D6D5D0"));
        enter.setBorder(new RoundBorder(10));
        enter.setBackground(Color.decode("#39454E"));
        //enter.setContentAreaFilled(false); // Aquí eliminamos el relleno del botón
        panel.add(enter, center);

        listener();
    }

    private void listener(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Options options = new Options();
                options.setVisible(true);
                setVisible(false);
            }
        });

        user.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                user.setText("");
            }
        });

        pass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pass.setText("");
            }
        });

        user.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        user.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(user.getText().equals("")){
                    user.setText(tUser);
                }
            }
        });

        pass.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_TAB) {
                    e.consume();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        pass.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(pass.getText().equals("")){
                    pass.setText(tPass);
                }
            }
        });
    }
}
