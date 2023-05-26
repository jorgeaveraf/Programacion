package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import Domain.Database;
import Logic.Ccuenta;

import java.awt.event.*;
import java.util.ArrayList;

public class EClient extends JFrame {
    private JPanel pCenter;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton exit;
    private JButton enter;
    private JButton enter2;
    private JLabel cName;
    private JTextArea account;
    private String tAccount;
    JTextArea aDeposit;
    private String tDeposit;
    JTextArea aWithdraw;
    private String tWithdraw;

    public EClient() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Ccuenta");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(350, 250));

        componentes();
    }

    private void componentes() {
        paneles();
        etiquetasTop();
        etiquetasBottom();
        etiquetasCentro();
    }

    private void paneles() {
        BG = new JPanel(new BorderLayout());
        BG.setBackground(Color.decode("#39454E"));

        pCenter = new JPanel(new GridBagLayout());
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
        BG.add(bottom, BorderLayout.PAGE_END);
    }

    private void etiquetasTop() {
        JLabel titulo = new JLabel("Clients", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150, 65));
        titulo.setFont(new Font("Lora", Font.PLAIN, 50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("Verify & Update", SwingConstants.CENTER);
        subtitulo.setPreferredSize(new Dimension(250, 0));
        subtitulo.setFont(new Font("Lora", Font.PLAIN, 15));
        subtitulo.setForeground(Color.decode("#D6D5D0"));
        subtitulo.setBorder(BorderFactory.createEmptyBorder(-40, 0, 0, 0));//Acerca más a esta etiqueta con el título
        encabezado.add(subtitulo);
    }

    private void etiquetasBottom() {
        JLabel terms = new JLabel("Terms & Conditions", SwingConstants.CENTER);
        terms.setPreferredSize(new Dimension(100, 15));
        terms.setFont(new Font("Lora", Font.PLAIN, 15));
        terms.setForeground(Color.decode("#D6D5D0"));
        terms.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(terms);

        JLabel edition = new JLabel("Enterprise Edition", SwingConstants.CENTER);
        edition.setPreferredSize(new Dimension(100, 70));
        edition.setFont(new Font("Lora", Font.PLAIN, 15));
        edition.setForeground(Color.decode("#D6D5D0"));
        edition.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(edition);

        JLabel vDate = new JLabel("April 2023", SwingConstants.CENTER);
        vDate.setPreferredSize(new Dimension(100, 70));
        vDate.setFont(new Font("Lora", Font.PLAIN, 15));
        vDate.setForeground(Color.decode("#D6D5D0"));
        vDate.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom.add(vDate);
    }

    private void etiquetasCentro() {
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 0;
        gbcCenter.fill = GridBagConstraints.HORIZONTAL;
        gbcCenter.anchor = GridBagConstraints.NORTHWEST;
        gbcCenter.insets = new Insets(0, 0, 0, 0);

        account = new JTextArea();
        account.setText("Enter here the account number");
        tAccount = account.getText();
        account.setFont(new Font("League Gothic Regular", Font.PLAIN, 55));
        account.setForeground(Color.decode("#86ADA0"));
        account.setOpaque(false);
        account.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        account.setAlignmentX(Component.CENTER_ALIGNMENT);
        pCenter.add(account, gbcCenter);

        gbcCenter.gridy++;
        JPanel empty = new JPanel();
        empty.setBackground(Color.decode("#D6D5D0"));
        empty.setPreferredSize(new Dimension(100, 40));
        pCenter.add(empty, gbcCenter);

        gbcCenter.gridy++;
        JPanel center = new JPanel(new GridLayout(1, 3));
        center.setBackground(Color.decode("#D6D5D0"));
        center.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pCenter.add(center, gbcCenter);

        JLabel lName = new JLabel();
        lName.setText("<html><body>" +
                "<p>Name</p>" +
                "<p>Account</p>" +
                "<p>Balance</p>" +
                "<p>Interest</p>" +
                "</body></html>");
        lName.setPreferredSize(new Dimension(100, 40));
        lName.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        lName.setBorder(BorderFactory.createEmptyBorder());
        lName.setForeground(Color.decode("#86ADA0"));
        center.add(lName);

        cName = new JLabel();
        cName.setPreferredSize(new Dimension(100, 40));
        cName.setFont(new Font("Lora", Font.PLAIN, 35));
        cName.setForeground(Color.decode("#86ADA0"));
        cName.setBorder(BorderFactory.createEmptyBorder());
        center.add(cName);

        JPanel cDer = new JPanel(new GridLayout(7, 1));
        cDer.setBackground(Color.decode("#D6D5D0"));
        cDer.setBorder(BorderFactory.createEmptyBorder());
        center.add(cDer);

        JLabel lDeposit = new JLabel("Deposits", SwingConstants.CENTER);
        lDeposit.setPreferredSize(new Dimension(100, 40));
        lDeposit.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        lDeposit.setBorder(BorderFactory.createEmptyBorder());
        lDeposit.setForeground(Color.decode("#86ADA0"));
        cDer.add(lDeposit);

        aDeposit = new JTextArea();
        aDeposit.setText("Enter here the amount to be deposit");
        tDeposit = aDeposit.getText();
        aDeposit.setFont(new Font("Lora", Font.PLAIN, 25));
        aDeposit.setForeground(Color.decode("#86ADA0"));
        aDeposit.setOpaque(false);
        aDeposit.setBorder(BorderFactory.createEmptyBorder());
        aDeposit.setAlignmentX(Component.CENTER_ALIGNMENT);
        cDer.add(aDeposit);

        enter = new JButton();
        enter.setText("Deposit");
        enter.setPreferredSize(new Dimension(100, 40));
        enter.setFont(new Font("Lora", Font.PLAIN, 15));
        enter.setForeground(Color.decode("#D6D5D0"));
        enter.setBorder(new RoundBorder(10));
        enter.setBackground(Color.decode("#39454E"));
        cDer.add(enter);

        JPanel empty4 = new JPanel();
        empty4.setBackground(Color.decode("#D6D5D0"));
        empty4.setPreferredSize(new Dimension(200, 10));
        cDer.add(empty4);

        JLabel lWithdraw = new JLabel("Withdrawals", SwingConstants.CENTER);
        lWithdraw.setPreferredSize(new Dimension(100, 40));
        lWithdraw.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        lWithdraw.setBorder(BorderFactory.createEmptyBorder());
        lWithdraw.setForeground(Color.decode("#86ADA0"));
        cDer.add(lWithdraw);

        aWithdraw = new JTextArea();
        aWithdraw.setText("Enter here the amount to be withdrawal");
        tWithdraw = aWithdraw.getText();
        aWithdraw.setFont(new Font("Lora", Font.PLAIN, 25));
        aWithdraw.setForeground(Color.decode("#86ADA0"));
        aWithdraw.setOpaque(false);
        aWithdraw.setBorder(BorderFactory.createEmptyBorder());
        aWithdraw.setAlignmentX(Component.CENTER_ALIGNMENT);
        cDer.add(aWithdraw);

        enter2 = new JButton();
        enter2.setText("Withdraw");
        enter2.setPreferredSize(new Dimension(70, 20));
        enter2.setFont(new Font("Lora", Font.PLAIN, 15));
        enter2.setForeground(Color.decode("#D6D5D0"));
        enter2.setBorder(new RoundBorder(10));
        enter2.setBackground(Color.decode("#39454E"));
        cDer.add(enter2);

        gbcCenter.gridy++;
        JPanel empty3 = new JPanel();
        empty3.setBackground(Color.decode("#D6D5D0"));
        empty3.setPreferredSize(new Dimension(200, 70));
        pCenter.add(empty3, gbcCenter);

        gbcCenter.gridy++;
        exit = new JButton();
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(70, 40));
        exit.setFont(new Font("Lora", Font.PLAIN, 15));
        exit.setForeground(Color.decode("#D6D5D0"));
        exit.setBorder(new RoundBorder(10));
        exit.setBackground(Color.decode("#39454E"));
        pCenter.add(exit,gbcCenter);

        listener();
        kListener();
        dListener();
    }
    private void listener() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Options options = new Options();
                options.setVisible(true);
                setVisible(false);
            }
        });

        account.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                account.setText("");
            }
        });

        account.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (account.getText().equals("")) {
                    account.setText(tAccount);
                }
            }
        });

        aDeposit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aDeposit.setText("");
            }
        });

        aDeposit.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (aDeposit.getText().equals("")) {
                    aDeposit.setText(tDeposit);
                }
            }
        });

        aWithdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aWithdraw.setText("");
            }
        });

        aWithdraw.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (aWithdraw.getText().equals("")) {
                    aWithdraw.setText(tWithdraw);
                }
            }
        });
    }
    // Método para buscar una coincidencia en el array cuentas y actualizar la etiqueta cName
    public void actualizarNombre () {
        Database db = Database.getInstance();
        ArrayList<Ccuenta> cuentas = db.getCuentas();

        String cuenta = account.getText();
        int accountInt = Integer.parseInt(cuenta);
        for (Ccuenta c : cuentas) {
            int Compare = c.getCuenta();
            if (Compare==accountInt) {
                cName.setText("<html>" + c.getNombre() + "<br/>" +c.getCuenta()+ "<br/>"+c.getSaldo()+ "<br/>"+c.getTipo_De_Interes()+"<html>");
                return;
            }
        }
        cName.setText("");
    }


    public void dListener(){
        account.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarNombre();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarNombre();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database db = Database.getInstance();
                ArrayList<Ccuenta> cuentas = db.getCuentas();
                String cuenta = account.getText();
                int accountInt = Integer.parseInt(cuenta);

                for (Ccuenta c : cuentas) {
                    int Compare = c.getCuenta();
                    if (Compare==accountInt) {
                        c.Ingreso(Double.parseDouble(aDeposit.getText()));
                        actualizarNombre();
                        return;
                    }
                }
            }
        });

        enter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Database db = Database.getInstance();
                ArrayList<Ccuenta> cuentas = db.getCuentas();
                String cuenta = account.getText();
                int accountInt = Integer.parseInt(cuenta);

                for (Ccuenta c : cuentas) {
                    int Compare = c.getCuenta();
                    if (Compare==accountInt) {
                        c.Retiro(Double.parseDouble(aWithdraw.getText()));
                        actualizarNombre();
                        return;
                    }
                }
            }
        });

    }

    private void kListener(){
        account.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c =='.')) {
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

        aDeposit.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c =='.')) {
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

        aWithdraw.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0' && c <= '9') || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c =='.')) {
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
    }
}
