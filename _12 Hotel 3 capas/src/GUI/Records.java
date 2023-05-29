package GUI;

import Logic.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Records extends JFrame {
    private JPanel pCenter;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JButton enter;
    private JComboBox comboBox;
    DefaultTableModel model;
    private String[] columnNames;
    private String[] colClient;
    private String[] colRoom;
    private String[] colReservation;
    private JTable table;
    private LClientes lClientes;
    private LHabitaciones lHabitaciones;
    private LReservaciones lReservaciones;

    public Records(){
        this.setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hotel");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(350,250));
        lClientes = LClientes.getInstance();
        lHabitaciones = LHabitaciones.getInstance();
        lReservaciones = LReservaciones.getInstance();

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
        JLabel titulo = new JLabel("Records", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150,65));
        titulo.setFont(new Font("Lora",Font.PLAIN,50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("only for viewing", SwingConstants.CENTER);
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

        JLabel sign = new JLabel("Jun 2023", SwingConstants.CENTER);
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

        String [] opciones = {"Select an option","Clients", "Rooms", "Reservations"};
        comboBox = new JComboBox(opciones);
        comboBox.setPreferredSize(new Dimension(100, 40));
        comboBox.setFont(new Font("League Gothic Regular", Font.PLAIN, 40));
        comboBox.setBorder(BorderFactory.createEmptyBorder());
        comboBox.setForeground(Color.decode("#86ADA0"));
        comboBox.setBackground(Color.decode("#D6D5D0"));
        pCenter.add(comboBox, center);

        center.gridy++;
        JPanel empty = new JPanel();
        empty.setBackground(Color.decode("#D6D5D0"));
        empty.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty, center);

        center.gridy++;
        JPanel empty2 = new JPanel();
        empty2.setBackground(Color.decode("#D6D5D0"));
        empty2.setPreferredSize(new Dimension(200, 10));
        pCenter.add(empty2, center);

        colClient= new String[]{"Name", "Cellphone", "Email"};
        colRoom = new String[]{"Número", "Tipo", "Precio", "Disponible"};
        colReservation = new String[]{"Número", "Cliente", "Habitación", "Fecha", "Días Reservados"};
        String[] colBlank = new String[]{"","", "", "", ""};

        columnNames = colBlank;
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);


        center.gridy++;
        table = new JTable(model);
        table.setEnabled(false);
        table.setFont(new Font("Lora", Font.PLAIN, 15));
        table.setBorder(BorderFactory.createEmptyBorder());
        table.setForeground(Color.decode("#86ADA0"));
        table.setBackground(Color.decode("#D6D5D0"));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setForeground(Color.decode("#86ADA0"));
        scrollPane.setBackground(Color.decode("#D6D5D0"));
        scrollPane.setPreferredSize(new Dimension(450, 200));
        pCenter.add(scrollPane, center);

        center.gridy++;
        enter = new JButton();
        enter.setText("Exit");
        enter.setPreferredSize(new Dimension(70,20));
        enter.setFont(new Font("Lora",Font.PLAIN,15));
        enter.setForeground(Color.decode("#D6D5D0"));
        enter.setBorder(new RoundBorder(10));
        enter.setBackground(Color.decode("#39454E"));
        pCenter.add(enter, center);

        listener();
    }

 private void listener(){
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
            String item = (String) comboBox.getSelectedItem();
                        switch (item) {
                case "Clients":
                    model.setRowCount(0);
                    columnNames = colClient;
                    model.setColumnIdentifiers(columnNames);
                    lClientes.clienteTable(model);
                    break;
                case "Rooms":
                    model.setRowCount(0);
                    columnNames = colRoom;
                    model.setColumnIdentifiers(columnNames);
                    lHabitaciones.habitacionTable(model);
                    break;
                case "Reservations":
                    model.setRowCount(0);
                    columnNames = colReservation;
                    model.setColumnIdentifiers(columnNames);
                    lReservaciones.reservacionTable(model);
                    break;
            }
                model.fireTableStructureChanged();
        }
 });

     enter.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             Options options = new Options();
             options.setVisible(true);
             setVisible(false);
         }
         });
    }
}

