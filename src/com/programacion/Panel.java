package com.programacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {
    /**
     * Implementamos o JPanel
     * Implementamos as funcions Key para asignar as teclas que realizaran os nosos movementos
     */
    Tablero tablero;

    public Panel(Tablero tablero) {
        this.tablero = tablero;
        this.setFocusable(true);
        this.requestFocusInWindow();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            tablero.moverPiezaIzquierda();
                            break;

                        case KeyEvent.VK_RIGHT:
                            tablero.moverPiezaDerecha();
                            break;

                        case KeyEvent.VK_UP:
                            tablero.rotarPieza();
                            break;
                    }
            }
        });
    }
    /**
     * Añadimoslle os graficos asi como o color de fondo do tableiro
     */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        Rectangle rect = new Rectangle(0,0,1000,1000);
        g2d.fill(rect);
        g2d.draw(rect);

        for (int i=0;i<tablero.campo.length;i++){
            for (int j=0;j <tablero.campo[0].length;j++){
                if (tablero.campo[i][j]==null){
                   continue;
                }
                g2d.setColor(tablero.campo[i][j].color);
                g2d.draw(new Rectangle(i*16,j*16,16,16));
            }
        }
        for (var coordenada:tablero.pieza.coordenada){
            g2d.setColor(tablero.pieza.tile.color);
            g2d.draw(new Rectangle(coordenada[0]*16,coordenada[1]*16,16,16));
        }
    }

}
