package com.programacion;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Panel extends JPanel {

    Tablero tablero;

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i=0;i<tablero.campo.length;i++){
            for (int j=0;j <tablero.campo[0].length;j++){

            }
        }
        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
    }
}
