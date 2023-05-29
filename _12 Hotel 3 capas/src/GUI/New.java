package GUI;

import Domain.Cliente;
import Domain.Habitacion;
import Logic.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class New extends JFrame {
    private JPanel pCenter;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton exit;
    private JButton enter;
    private JButton enter2;
    private JButton enter3;
    private JLabel cName;
    private JTextField account;
    private String tAccount;
    private JLabel lName;
    private String[] colClient, colRoom, colReservation;
    private String[] colClient1, colRoom1, colReservation1;
    JTextArea tModify;
    private String tDeposit;

    JTextArea tDelete;
    private String tWithdraw;

    private JComboBox cBox, comboBox, comboBox2;
    LogicAgenda logicAgenda;
    LogicContacto c;
    private LClientes lClientes;
    private LCliente lCliente;
    private LHabitaciones lHabitaciones;
    private LHabitacion lHabitacion;
    private LReservaciones lReservaciones;
    private LReservacion lReservacion;

    public New() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        setExtendedState(getExtendedState() | Frame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hotel");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(350, 250));
        lClientes = LClientes.getInstance();
        lHabitaciones = LHabitaciones.getInstance();
        lReservaciones = LReservaciones.getInstance();
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

        encabezado = new JPanel(new GridLayout(2, 1));
        encabezado.setBackground(Color.decode("#39454E"));
        encabezado.setBorder(BorderFactory.createEmptyBorder(0, 10, -30, 10));

        bottom = new JPanel(new GridLayout(1, 3));
        bottom.setBackground(Color.decode("#39454E"));
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));


        this.getContentPane().add(BG, BorderLayout.CENTER);
        BG.add(encabezado, BorderLayout.PAGE_START);
        BG.add(pCenter, BorderLayout.CENTER);
        BG.add(bottom, BorderLayout.PAGE_END);
    }

    private void etiquetasTop() {
        JLabel titulo = new JLabel("Hotel", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150, 65));
        titulo.setFont(new Font("Lora", Font.PLAIN, 50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("Create & Update", SwingConstants.CENTER);
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

        JLabel vDate = new JLabel("Jun 2023", SwingConstants.CENTER);
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

        String[] opciones = {"Select an option", "Clients", "Rooms", "Reservations"};
        cBox = new JComboBox(opciones);
        cBox.setPreferredSize(new Dimension(100, 40));
        cBox.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        cBox.setBorder(BorderFactory.createEmptyBorder());
        cBox.setForeground(Color.decode("#86ADA0"));
        cBox.setBackground(Color.decode("#D6D5D0"));
        pCenter.add(cBox, gbcCenter);

        gbcCenter.gridy++;
        account = new JTextField();
        account.setText("");
        tAccount = "Not found? Create it!";
        account.setFont(new Font("League Gothic Regular", Font.PLAIN, 50));
        account.setForeground(Color.decode("#86ADA0"));
        account.setOpaque(false);
        account.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        account.setAlignmentX(Component.WIDTH);
        pCenter.add(account, gbcCenter);

        gbcCenter.gridy++;
        enter3 = new JButton();
        enter3.setText("Create new record");
        enter3.setPreferredSize(new Dimension(70, 40));
        enter3.setFont(new Font("Lora", Font.PLAIN, 25));
        enter3.setForeground(Color.decode("#D6D5D0"));
        enter3.setBorder(new RoundBorder(30));
        enter3.setBackground(Color.decode("#39454E"));
        pCenter.add(enter3, gbcCenter);

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

        lName = new JLabel();
        lName.setText("");
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

        JPanel cDer = new JPanel(new GridLayout(8, 1));
        cDer.setBackground(Color.decode("#D6D5D0"));
        cDer.setBorder(BorderFactory.createEmptyBorder());
        center.add(cDer);

        JLabel lDeposit = new JLabel("Modify", SwingConstants.CENTER);
        lDeposit.setPreferredSize(new Dimension(100, 40));
        lDeposit.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        lDeposit.setBorder(BorderFactory.createEmptyBorder());
        lDeposit.setForeground(Color.decode("#86ADA0"));
        cDer.add(lDeposit);

        String[] colBlank = new String[]{"", "", "", "", ""};
        colClient = new String[]{"Name", "Cellphone", "Email"};
        colRoom = new String[]{"Room #", "Type", "Price", "Available"};
        colReservation = new String[]{"Reservation #", "Client", "Room", "Date", "Days"};


        comboBox = new JComboBox(colBlank);
        comboBox.setPreferredSize(new Dimension(100, 40));
        comboBox.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setForeground(Color.decode("#86ADA0"));
        comboBox.setBackground(Color.decode("#D6D5D0"));
        cDer.add(comboBox);


        tModify = new JTextArea();
        tModify.setText("Enter here the new value");
        tDeposit = tModify.getText();
        tModify.setFont(new Font("Lora", Font.PLAIN, 25));
        tModify.setForeground(Color.decode("#86ADA0"));
        tModify.setOpaque(false);
        tModify.setBorder(BorderFactory.createEmptyBorder());
        tModify.setAlignmentX(Component.CENTER_ALIGNMENT);
        cDer.add(tModify);

        enter = new JButton();
        enter.setText("Update");
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

        JLabel lWithdraw = new JLabel("Delete", SwingConstants.CENTER);
        lWithdraw.setPreferredSize(new Dimension(100, 40));
        lWithdraw.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        lWithdraw.setBorder(BorderFactory.createEmptyBorder());
        lWithdraw.setForeground(Color.decode("#86ADA0"));
        cDer.add(lWithdraw);

        colClient1 = new String[]{"Name", "Email", "Entire Client"};
        colRoom1 = new String[]{"Type", "Price", "Entire Room"};
        colReservation1 = new String[]{"Date", "Days", "Entire Reservation"};

        comboBox2 = new JComboBox(colBlank);
        comboBox2.setPreferredSize(new Dimension(100, 40));
        comboBox2.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        comboBox2.setBorder(BorderFactory.createEmptyBorder());
        comboBox2.setForeground(Color.decode("#86ADA0"));
        comboBox2.setBackground(Color.decode("#D6D5D0"));
        cDer.add(comboBox2);

        enter2 = new JButton();
        enter2.setText("Confirm");
        enter2.setPreferredSize(new Dimension(70, 20));
        enter2.setFont(new Font("Lora", Font.PLAIN, 15));
        enter2.setForeground(Color.decode("#D6D5D0"));
        enter2.setBorder(new RoundBorder(10));
        enter2.setBackground(Color.decode("#39454E"));
        cDer.add(enter2);

        gbcCenter.gridy++;
        JPanel empty5 = new JPanel();
        empty5.setBackground(Color.decode("#D6D5D0"));
        empty5.setPreferredSize(new Dimension(200, 70));
        pCenter.add(empty5, gbcCenter);

        gbcCenter.gridy++;
        exit = new JButton();
        exit.setText("Exit");
        exit.setPreferredSize(new Dimension(70, 40));
        exit.setFont(new Font("Lora", Font.PLAIN, 15));
        exit.setForeground(Color.decode("#D6D5D0"));
        exit.setBorder(new RoundBorder(10));
        exit.setBackground(Color.decode("#39454E"));
        pCenter.add(exit, gbcCenter);

        listener();
        kListener();
        dListener();
    }

    public void actualizarNombre() {
        String cuenta = account.getText();
        try {
            long accountLong = Long.parseLong(cuenta);
            String item = (String) cBox.getSelectedItem();
            switch (item) {
                case "Clients":
                    lCliente = lClientes.buscarClientePorTelefono(accountLong);
                    if (lCliente != null) {
                        cName.setText("<html>" + lCliente.getNombre() + "<br/>" + lCliente.getTelefono() + "<br/>" + lCliente.getEmail() + "<br/>" + "<html>");
                    } else {
                        cName.setText("");
                    }
                    break;
                case "Rooms":
                    lHabitacion = lHabitaciones.buscarPorNumero((int) accountLong);
                    if (lHabitacion != null) {
                        cName.setText("<html>" + lHabitacion.getNumeroH() + "<br/>" + lHabitacion.getTipo() + "<br/>" + (lHabitacion.getPrecio() != 0 ? lHabitacion.getPrecio() : "") + "<br/>" + lHabitacion.isDisponible() + "<br/>" + "<html>");
                    } else {
                        cName.setText("");
                    }
                    break;
                case "Reservations":
                    lReservacion = lReservaciones.buscarReservacionPorNumero((int) accountLong);
                    if (lReservacion != null) {
                        cName.setText("<html>" + lReservacion.getnReservacion() + "<br/>" + lReservacion.getCliente() + "<br/>" + lReservacion.getHabitacion() + "<br/>" + (lReservacion.getFecha() != null ? lReservacion.getFecha() : "")+ "<br/>" + (lReservacion.getDiasR() != 0 ? lReservacion.getDiasR() :"") + "<br/>" + "<html>");
                    } else {
                        cName.setText("");
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            cName.setText("");
        }
    }

    public boolean email(String email){
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(EMAIL_REGEX);
    }

    private void createNewClient () {
        String name = JOptionPane.showInputDialog(null, "Enter new name", "Creating a new Client", JOptionPane.PLAIN_MESSAGE);

        if (name == null) {
            return; // El usuario canceló la ventana
        }

        long cellphone = getInputAsLong("Enter new cellphone", "Invalid cellphone. Please try again.");
        if (cellphone == -1) {
            return; // El usuario canceló la ventana o ingresó un valor inválido
        }

        String email = getInputWithEmailValidation("Enter new mail", "Invalid email. Please try again.");
        if (email == null) {
            return; // El usuario canceló la ventana
        }

        LCliente lCliente = new LCliente(name, cellphone, email);
        lClientes.addCliente(lCliente);
        JOptionPane.showMessageDialog(null, "Client created successfully", "Creating a new Client", JOptionPane.PLAIN_MESSAGE);
    }

    private void createNewRoom () {
        int number = getInputAsInt("Enter new number Room", "Invalid number. Please try again.");
        if (number == -1) {
            return; // El usuario canceló la ventana o ingresó un valor inválido
        }

        String type = JOptionPane.showInputDialog(null, "Enter new type", "Creating a new Room", JOptionPane.PLAIN_MESSAGE);
        if (type == null) {
            return; // El usuario canceló la ventana
        }

        int price = getInputAsInt("Enter new price", "Invalid price. Please try again.");
        if (price == -1) {
            return; // El usuario canceló la ventana o ingresó un valor inválido
        }

        LHabitacion lHabitacion = new LHabitacion(number, type, price, true);
        lHabitaciones.addRoom(lHabitacion);
        JOptionPane.showMessageDialog(null, "Room created successfully", "Creating a new Room", JOptionPane.PLAIN_MESSAGE);
    }

    private void createNewReservation () {
        Cliente cliente = getSelectedCliente("Clients List");
        if (cliente == null) {
            return; // El usuario canceló la ventana o no seleccionó un cliente válido
        }

        Habitacion habitacion = getSelectedHabitacion("Rooms List");
        if (habitacion == null) {
            return; // El usuario canceló la ventana o no seleccionó una habitación válida
        }

        LocalDate date = getInputAsDate("Enter new date", "Invalid date. Please try again.");
        if (date == null) {
            return; // El usuario canceló la ventana o ingresó una fecha inválida
        }

        int days = getInputAsInt("Enter new days", "Invalid number of days. Please try again.");
        if (days == -1) {
            return; // El usuario canceló la ventana o ingresó un valor inválido
        }

        int reservationId = lReservaciones.getContador();
        LReservacion lReservacion = new LReservacion(reservationId, cliente, habitacion, date, days);
        lReservaciones.addReservacion(lReservacion);
        habitacion.setDisponible(false);
        JOptionPane.showMessageDialog(null, "Reservation created successfully", "Creating a new Reservation", JOptionPane.PLAIN_MESSAGE);
    }

    private long getInputAsLong (String message, String errorMessage){
        boolean validNumber = false;
        long number = -1;

        do {
            String input = JOptionPane.showInputDialog(null, message, "Creating", JOptionPane.PLAIN_MESSAGE);
            if (input == null) {
                break;
            }

            if (input.length() >= 10 && input.matches("\\d+")) {
                validNumber = true;
                number = Long.parseLong(input);
            } else {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validNumber);

        return number;
    }

    private String getInputWithEmailValidation (String message, String errorMessage){
        boolean validEmail = false;
        String email = null;

        do {
            String input = JOptionPane.showInputDialog(null, message, "Creating", JOptionPane.PLAIN_MESSAGE);
            if (input == null) {
                break;
            }

            if (email(input)) {
                validEmail = true;
                email = input;
            } else {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validEmail);

        return email;
    }

    private Cliente getSelectedCliente (String dialogTitle){
        Cliente[] clients = lClientes.getClientes();
        Object[] rowData = new Object[clients.length];
        int index = 0;
        for (Cliente cliente : clients) {
            if (cliente != null) {
                rowData[index++] = cliente.getNombre();
            }
        }

        String selectedOption = (String) JOptionPane.showInputDialog(null, "Select an option", dialogTitle, JOptionPane.PLAIN_MESSAGE, null, rowData, rowData[0]);
        if (selectedOption != null) {
            for (Cliente cliente : clients) {
                if (cliente != null && cliente.getNombre().equals(selectedOption)) {
                    return cliente;
                }
            }
        }

        return null;
    }

    private Habitacion getSelectedHabitacion(String dialogTitle) {
        Habitacion[] habitaciones = lHabitaciones.getHabitaciones();
        List<Habitacion> disponibles = new ArrayList<>();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion != null && habitacion.isDisponible()) {
                disponibles.add(habitacion);
            }
        }

        Object[] rowData = new Object[disponibles.size()];
        int index = 0;
        for (Habitacion habitacion : disponibles) {
            rowData[index++] = habitacion.getNumeroH();
        }

        Integer selectedOption = (Integer) JOptionPane.showInputDialog(null, "Select an option", dialogTitle, JOptionPane.PLAIN_MESSAGE, null, rowData, rowData[0]);
        if (selectedOption != null) {
            int number = selectedOption.intValue();
            for (Habitacion habitacion : disponibles) {
                if (habitacion.getNumeroH() == number) {
                    return habitacion;
                }
            }
        }

        return null;
    }


    private LocalDate getInputAsDate (String message, String errorMessage){
        LocalDate date = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            String input = JOptionPane.showInputDialog(null, message, "Creating", JOptionPane.PLAIN_MESSAGE);
            if (input == null) {
                break;
            }

            try {
                date = LocalDate.parse(input, dateFormatter);
                if (date.isAfter(LocalDate.now())) {
                    break;
                }else {JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);}
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return date;
    }

    private int getInputAsInt (String message, String errorMessage){
        boolean validNumber = false;
        int number = -1;

        do {
            String input = JOptionPane.showInputDialog(null, message, "Creating", JOptionPane.PLAIN_MESSAGE);
            if (input == null) {
                break; // El usuario canceló la ventana
            }

            if (input.matches("\\d+")) {
                validNumber = true;
                number = Integer.parseInt(input);
            } else {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validNumber);

        return number;
    }


    private void listener() {
        cBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = (String) cBox.getSelectedItem();
                switch (item) {
                    case "Clients":
                        account.setText("Enter the phone number");
                        lName.setText("<html><body>" +
                                "<p>Name</p>" +
                                "<p>Cellphone</p>" +
                                "<p>Email</p>" +
                                "</body></html>");
                        comboBox.setModel(new DefaultComboBoxModel(colClient));
                        comboBox2.setModel(new DefaultComboBoxModel(colClient1));
                        break;
                    case "Rooms":
                        account.setText("Enter the room number");
                        lName.setText("<html><body>" +
                                "<p>Room #</p>" +
                                "<p>Type</p>" +
                                "<p>Price</p>" +
                                "<p>Available</p>" +
                                "</body></html>");
                        comboBox.setModel(new DefaultComboBoxModel(colRoom));
                        comboBox2.setModel(new DefaultComboBoxModel(colRoom1));
                        break;
                    case "Reservations":
                        account.setText("Enter the reservation number");
                        lName.setText("<html><body>" +
                                "<p>Reservation #</p>" +
                                "<p>Client</p>" +
                                "<p>Room</p>" +
                                "<p>Date</p>" +
                                "<p>Days</p>" +
                                "</body></html>");
                        comboBox.setModel(new DefaultComboBoxModel(colReservation));
                        comboBox2.setModel(new DefaultComboBoxModel(colReservation1));
                        break;
                }
            }
        });

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

       tModify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tModify.setText("");
            }
        });

        tModify.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tModify.getText().equals("")) {
                    tModify.setText(tDeposit);
                }
            }
        });

    }
    public void dListener() {
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
                String cuenta = account.getText();
                long accountLong = Long.parseLong(cuenta);
                String item = (String) comboBox.getSelectedItem();
                if (cBox.getSelectedItem().equals("Clients")) {
                    switch (item) {
                        case "Name":
                            lClientes.setName(lClientes.index(accountLong), tModify.getText());
                            break;
                        case "Cellphone":
                            lClientes.setTelefono(lClientes.index(accountLong), Long.valueOf(tModify.getText()));
                            break;
                        case "Email":
                            lClientes.setEmail(lClientes.index(accountLong), tModify.getText());
                            break;
                    }
                    actualizarNombre();
                }

                if (cBox.getSelectedItem().equals("Rooms")) {
                    switch (item) {
                        case "Room #":
                            lHabitaciones.setNRoom(lHabitaciones.index((int) accountLong), Integer.parseInt(tModify.getText()));
                            break;
                        case "Type":
                            lHabitaciones.setTRoom(lHabitaciones.index((int) accountLong), tModify.getText());
                            break;
                        case "Price":
                            lHabitaciones.setPRoom(lHabitaciones.index((int) accountLong), Integer.parseInt(tModify.getText()));
                            break;
                        case "Available":
                            lHabitaciones.setARoom(lHabitaciones.index((int) accountLong), Boolean.parseBoolean(tModify.getText()));
                            break;
                    }
                    actualizarNombre();
                }

                if (cBox.getSelectedItem().equals("Reservations")) {
                    switch (item) {
                        case "Reservation #":
                            lReservaciones.setNReservation(lReservaciones.index((int) accountLong), Integer.parseInt(tModify.getText()));
                            break;
                        case "Client":
                            lReservaciones.validarCliente((int) accountLong, tModify.getText());
                            break;
                        case "Room":
                            lReservaciones.validarHabitacion((int) accountLong, Integer.parseInt(tModify.getText()));
                            break;
                        case "Date":
                            lReservaciones.validarFecha(lReservaciones.index((int) accountLong), LocalDate.parse(tModify.getText()));
                            break;
                        case "Days":
                            lReservaciones.setRDias(lReservaciones.index((int) accountLong), Integer.parseInt(tModify.getText()));
                            break;
                    }
                    actualizarNombre();
                }
            }
        });

        enter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cuenta = account.getText();
                long accountLong = Long.parseLong(cuenta);
                String item = (String) comboBox2.getSelectedItem();
                if (cBox.getSelectedItem().equals("Clients")) {
                    switch (item) {
                        case "Name":
                            lClientes.setName(lClientes.index(accountLong), "");
                            break;
                        case "Email":
                            lClientes.setEmail(lClientes.index(accountLong), "");
                            break;
                        case "Entire Client":
                            lClientes.setCNull(lClientes.index(accountLong));
                    }
                    actualizarNombre();
                }
                if (cBox.getSelectedItem().equals("Rooms")) {
                    switch (item) {
                        case "Type":
                            lHabitaciones.setTRoom(lHabitaciones.index((int) accountLong), "");
                            break;
                        case "Price":
                            lHabitaciones.setPRoom(lHabitaciones.index((int) accountLong), 0);
                            break;
                        case "Entire Room":
                            lHabitaciones.setHNull(lHabitaciones.index((int) accountLong));
                    }
                    actualizarNombre();
                }
                if (cBox.getSelectedItem().equals("Reservations")) {
                    switch (item) {
                        case "Date":
                            lReservaciones.setRFecha(lReservaciones.index((int) accountLong), null);
                            break;
                        case "Days":
                            lReservaciones.setRDias(lReservaciones.index((int) accountLong), 0);
                            break;
                        case "Entire Reservation":
                            lReservaciones.setRNull(lReservaciones.index((int) accountLong));
                    }
                    actualizarNombre();
                }

            }
        });

        enter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) JOptionPane.showInputDialog(null, "Select an option", "Creating", JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Clients", "Rooms", "Reservations"}, "Clients");

                if (selectedOption == null) {
                    return; // El usuario canceló la ventana
                }

                switch (selectedOption) {
                    case "Clients":
                        createNewClient();
                        break;
                    case "Rooms":
                        createNewRoom();
                        break;
                    case "Reservations":
                        createNewReservation();
                        break;
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

        tModify.addKeyListener(new KeyListener(){
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
