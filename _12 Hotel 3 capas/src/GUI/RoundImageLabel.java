package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundImageLabel extends JLabel {
        private ImageIcon imageIcon;

        public RoundImageLabel(ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
            setPreferredSize(new Dimension(200, 200));
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Shape roundShape = new Ellipse2D.Float(0, 0, getWidth() - 1, getHeight() - 1);
            g2.clip(roundShape);
            g2.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), null);
            g2.dispose();
        }
    }

