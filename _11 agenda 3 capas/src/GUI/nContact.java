package GUI;

import Logic.LogicAgenda;
import Logic.LogicContacto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class nContact extends JFrame {
    private JPanel pCenter;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton enter;
    private JTextArea cName;
    private String tName;
    private JTextArea cCellphone;
    private String tAccount;
    private JTextArea cEmail;
    private String tBalance;
    private JTextArea cBirthday;
    private String tInterest;

    public nContact(){
        this.setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agenda");
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

        pCenter =new JPanel(new GridBagLayout());
        pCenter.setBackground(Color.decode("#D6D5D0"));

        encabezado = new JPanel(new GridLayout(2, 1)); // Para que el encabezado pueda tener dos etiquetas
        encabezado.setBackground(Color.decode("#39454E"));
        encabezado.setBorder(BorderFactory.createEmptyBorder(0, 10, -30, 10));//Permite acercar las etiquetas y modificar el espacio que utiliza en la ventana

        bottom = new JPanel(new GridLayout(1, 3)); // Para que el encabezado pueda tener 4 etiquetas
        bottom.setBackground(Color.decode("#39454E"));
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        //Agregamos a la ventana
        this.getContentPane().add(BG, BorderLayout.CENTER);
        BG.add(encabezado, BorderLayout.PAGE_START);
        BG.add(pCenter, BorderLayout.CENTER);
        BG.add(bottom,BorderLayout.PAGE_END);
    }

    private void etiquetasTop(){
        JLabel titulo = new JLabel("New Contact", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150,65));
        titulo.setFont(new Font("Lora",Font.PLAIN,50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("Enter the following data", SwingConstants.CENTER);
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

        JLabel forgot = new JLabel("Enterprise Edition", SwingConstants.CENTER);
        forgot.setPreferredSize(new Dimension(100,70));
        forgot.setFont(new Font("Lora",Font.PLAIN,15));
        forgot.setForeground(Color.decode("#D6D5D0"));
        forgot.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(forgot);

        JLabel sign = new JLabel("May 2023", SwingConstants.CENTER);
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
        center.insets = new Insets(0, 10, 0, 0);

        cName = new JTextArea();
        cName.setText("Name");
        tName = cName.getText();
        cName.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        cName.setForeground(Color.decode("#86ADA0"));
        cName.setOpaque(false);
        cName.setBorder(BorderFactory.createEmptyBorder());
        cName.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCenter.add(cName, center);

        center.gridy++;
        JPanel separator = new JPanel();
        separator.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator.setPreferredSize(new Dimension(200, 2));
        pCenter.add(separator, center);

        center.gridy++;
        JPanel empty = new JPanel();
        empty.setBackground(Color.decode("#D6D5D0"));
        empty.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty, center);

        center.gridy++;
        cCellphone = new JTextArea();
        cCellphone.setText("Cellphone Number");
        tAccount = cCellphone.getText();
        cCellphone.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        cCellphone.setForeground(Color.decode("#86ADA0"));
        cCellphone.setOpaque(false);
        cCellphone.setBorder(BorderFactory.createEmptyBorder());
        cCellphone.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCenter.add(cCellphone, center);

        center.gridy++;
        JPanel separator2 = new JPanel();
        separator2.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator2.setPreferredSize(new Dimension(200, 2));
        pCenter.add(separator2, center);

        center.gridy++;
        JPanel empty2 = new JPanel();
        empty2.setBackground(Color.decode("#D6D5D0"));
        empty2.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty2, center);

        center.gridy++;
        cEmail = new JTextArea();
        cEmail.setText("Email");
        tBalance = cEmail.getText();
        cEmail.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        cEmail.setForeground(Color.decode("#86ADA0"));
        cEmail.setOpaque(false);
        cEmail.setBorder(BorderFactory.createEmptyBorder());
        cEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCenter.add(cEmail, center);

        center.gridy++;
        JPanel separator3 = new JPanel();
        separator3.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator3.setPreferredSize(new Dimension(200, 2));
        pCenter.add(separator3, center);

        center.gridy++;
        JPanel empty3 = new JPanel();
        empty3.setBackground(Color.decode("#D6D5D0"));
        empty3.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty3, center);

        center.gridy++;
        cBirthday = new JTextArea();
        cBirthday.setText("Birthday");
        tInterest = cBirthday.getText();
        cBirthday.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        cBirthday.setForeground(Color.decode("#86ADA0"));
        cBirthday.setOpaque(false);
        cBirthday.setBorder(BorderFactory.createEmptyBorder());
        cBirthday.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCenter.add(cBirthday, center);

        center.gridy++;
        JPanel separator4 = new JPanel();
        separator4.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
        separator4.setPreferredSize(new Dimension(200, 2));
        pCenter.add(separator4, center);

        center.gridy++;
        JPanel empty4 = new JPanel();
        empty4.setBackground(Color.decode("#D6D5D0"));
        empty4.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty4, center);

        center.gridy++;
        enter = new JButton();
        enter.setText("Register");
        enter.setPreferredSize(new Dimension(70,20));
        enter.setFont(new Font("Lora",Font.PLAIN,15));
        enter.setForeground(Color.decode("#D6D5D0"));
        enter.setBorder(new RoundBorder(10));
        enter.setBackground(Color.decode("#39454E"));
        //enter.setContentAreaFilled(false); // Aquí eliminamos el relleno del botón
        pCenter.add(enter, center);

        listener();
        kListener();
    }
public boolean email(String email){
    String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(EMAIL_REGEX);
    }

    public boolean birthday(String fechaString){
            try {
                LocalDate.parse(fechaString);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
    }
    private void listener(){
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cName.getText().length() == 0 ||cEmail.getText().length() == 0 || cBirthday.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "There can't be any blank fields");
                } else if (!email(cEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Introduce a valid email");
                } else if (!birthday(cBirthday.getText())) {
                    JOptionPane.showMessageDialog(null, "Introduce a valid date\nej. 2023-10-15");
                } else if (cCellphone.getText().length() < 10) {
                    JOptionPane.showMessageDialog(null, "Introduce a valid cellphone number");
                }else {
                    String nombre = cName.getText();
                    String telefono = cCellphone.getText();
                    String mail = cEmail.getText();
                    String cumple = cBirthday.getText();

                    long tel = Long.parseLong(telefono);
                    LocalDate cumpleanos = LocalDate.parse(cumple);

                    LogicAgenda logicAgenda = LogicAgenda.getInstance();
                    LogicContacto logicContacto = new LogicContacto(nombre,tel,mail,cumpleanos);
                    logicAgenda.addContact(logicContacto);

                    JOptionPane.showMessageDialog(null, "Contact successfully saved");
                    Options options = new Options();
                    options.setVisible(true);
                    setVisible(false);
                }
            }
        });

        cName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cName.setText("");
            }
        });

        cName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(cName.getText().equals("")){
                    cName.setText(tName);
                }
            }
        });

        cCellphone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cCellphone.setText("");
            }
        });

        cCellphone.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(cCellphone.getText().equals("")){
                    cCellphone.setText(tAccount);
                }
            }
        });

        cEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cEmail.setText("");
            }
        });

        cEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(cEmail.getText().equals("")){
                    cEmail.setText(tBalance);
                }
            }
        });

        cBirthday.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cBirthday.setText("");
            }
        });

        cBirthday.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if(cBirthday.getText().equals("")){
                    cBirthday.setText(tInterest);
                }
            }
        });
    }

    private void kListener(){
        cName.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Tranquilo viejo, aquí no se usan números");
                }
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

        cCellphone.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null,"Tranquilo viejo, aquí solo se usan números");
                }
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

        cEmail.addKeyListener(new KeyListener(){
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
        cBirthday.addKeyListener(new KeyListener(){
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
    }
}
