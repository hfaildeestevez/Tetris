package com.programacion;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    Tablero tablero;

    public Panel(Tablero tablero) {
        this.tablero = tablero;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i=0;i<tablero.campo.length;i++){
            for (int j=0;j <tablero.campo[0].length;j++){
                if (tablero.campo[i][j]==null){
                    break;
                }
                g2d.setColor(tablero.campo[i][j].color);
                g2d.draw(new Rectangle(i*16,j*16,16,16));
            }
        }
    }
}
