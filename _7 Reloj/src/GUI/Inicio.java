package GUI;

import Logic.Hora;
import Logic.Reloj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Inicio extends JFrame {
        private JPanel panel;
        private JPanel BG;
        private JPanel encabezado;
        private JPanel bottom;
        private JButton enter;
        private JLabel digital;
        private String tUser;
        private JLabel analogic;
        private String tPass;

        public Inicio(){
            this.setSize(700,500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("Clock");
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
            JLabel titulo = new JLabel("Clock", SwingConstants.CENTER);
            titulo.setPreferredSize(new Dimension(150,65));
            titulo.setFont(new Font("Lora",Font.PLAIN,50));
            titulo.setForeground(Color.decode("#D6D5D0"));
            encabezado.add(titulo);

            JLabel subtitulo = new JLabel("Initialize the clock", SwingConstants.CENTER);
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

            JLabel forgot = new JLabel("Enterprise Clock", SwingConstants.CENTER);
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

            JPanel empty = new JPanel();
            empty.setBackground(Color.decode("#D6D5D0"));
            empty.setPreferredSize(new Dimension(200, 20));
            panel.add(empty, center);

            center.gridy++;
            digital = new JLabel();
            digital.setText("00:00:00");
            tUser = digital.getText();
            digital.setFont(new Font("League Gothic Regular", Font.PLAIN, 75));
            digital.setForeground(Color.decode("#86ADA0"));
            digital.setOpaque(false);
            digital.setBorder(BorderFactory.createEmptyBorder());
            digital.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(digital, center);

            center.gridy++;
            JPanel separator = new JPanel();
            separator.setBorder(BorderFactory.createLineBorder(Color.decode("#86ADA0"), 2, false));
            separator.setPreferredSize(new Dimension(200, 2));
            panel.add(separator, center);

            center.gridy++;
            JLabel text = new JLabel();
            text.setText("Digital clock");
            text.setFont(new Font("Lora", Font.PLAIN, 45));
            text.setForeground(Color.decode("#86ADA0"));
            text.setOpaque(false);
            text.setBorder(BorderFactory.createEmptyBorder());
            text.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(text, center);

            center.gridy++;
            JPanel empty2 = new JPanel();
            empty2.setBackground(Color.decode("#D6D5D0"));
            empty2.setPreferredSize(new Dimension(200, 20));
            panel.add(empty2, center);

            center.gridy++;
            enter = new JButton();
            enter.setText("Activate");
            enter.setPreferredSize(new Dimension(70,20));
            enter.setFont(new Font("Lora",Font.PLAIN,15));
            enter.setForeground(Color.decode("#D6D5D0"));
            enter.setBorder(new RoundBorder(10));
            enter.setBackground(Color.decode("#39454E"));
            panel.add(enter, center);

            listener();
        }

        private void listener(){
            enter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LocalTime horaActual = LocalTime.now();

                    Hora hora = new Hora(Integer.parseInt(horaActual.format(DateTimeFormatter.ofPattern("HH"))),Integer.parseInt(horaActual.format(DateTimeFormatter.ofPattern("mm"))),
                            Integer.parseInt(horaActual.format(DateTimeFormatter.ofPattern("ss"))));

                    Reloj reloj1 = new Reloj(hora,"digital");

                    digital.setText(reloj1.Start());
                }
            });

            }
    }
