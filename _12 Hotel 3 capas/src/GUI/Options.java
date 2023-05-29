package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Options extends JFrame {
    private JPanel pCenter;
    private JPanel BG;
    private JPanel encabezado;
    private JPanel bottom;
    private JLabel nClient;
    private JLabel eClient;

    public Options(){
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

        pCenter =new JPanel(new GridLayout(1,2));
        pCenter.setBackground(Color.decode("#D6D5D0"));

        encabezado = new JPanel(new GridLayout(2, 1)); // Para que el encabezado pueda tener dos etiquetas
        encabezado.setBackground(Color.decode("#39454E"));
        encabezado.setBorder(BorderFactory.createEmptyBorder(0, 10, -30, 10));//Permite acercar las etiquetas y modificar el espacio que utiliza en la ventana

        bottom = new JPanel(new GridLayout(1, 4)); // Para que el encabezado pueda tener 4 etiquetas
        bottom.setBackground(Color.decode("#39454E"));
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        //Agregamos a la ventana
        this.getContentPane().add(BG, BorderLayout.CENTER);
        BG.add(encabezado, BorderLayout.PAGE_START);
        BG.add(pCenter, BorderLayout.CENTER);
        BG.add(bottom,BorderLayout.PAGE_END);
    }

    private void etiquetasTop(){
        JLabel titulo = new JLabel("Options", SwingConstants.CENTER);
        titulo.setPreferredSize(new Dimension(150,65));
        titulo.setFont(new Font("Lora",Font.PLAIN,50));
        titulo.setForeground(Color.decode("#D6D5D0"));
        encabezado.add(titulo);

        JLabel subtitulo = new JLabel("What do you want to do?", SwingConstants.CENTER);
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
        nClient = new JLabel("",SwingConstants.CENTER);
        nClient.setText("<html><center>VIEW ALL<br>RECORDS</center></html>");
        nClient.setPreferredSize(new Dimension(100,100));
        nClient.setFont(new Font("League Gothic Regular",Font.PLAIN,75));
        nClient.setForeground(Color.decode("#86ADA0"));
        pCenter.add(nClient);

        eClient = new JLabel("",SwingConstants.CENTER);
        eClient.setText("<html><center>ADD OR VERIFY<br>AN EXISTENT RECORD</center></html>");
        eClient.setPreferredSize(new Dimension(100,100));
        eClient.setFont(new Font("League Gothic Regular",Font.PLAIN,70));
        eClient.setForeground(Color.decode("#86ADA0"));
        pCenter.add(eClient);

        listener();
    }

    private void listener(){
        nClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Records records1 = new Records();
                records1.setVisible(true);
                setVisible(false);
            }
        });

        eClient.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                New new1 = new New();
                new1.setVisible(true);
                setVisible(false);
            }
        });
    }
}
