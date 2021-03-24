package Interfaz;

import com.Logica.Tablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        Rectangle background = new Rectangle(0,0,1000,1000);
        g2d.fill(background);
        g2d.draw(background);

        for (int i=0;i<tablero.campo.length;i++){
            for (int j=0;j <tablero.campo[0].length;j++){
                if (tablero.campo[i][j]==null){
                   continue;
                }
                g2d.setColor(tablero.campo[i][j].color);
                dibujarRectangulo(i, j, g2d);
            }
        }
        for (var coordenada:tablero.pieza.coordenada){
            g2d.setColor(tablero.pieza.tile.color);
            dibujarRectangulo(coordenada[0], coordenada[1], g2d);
        }
    }

    private void dibujarRectangulo(int i, int j, Graphics2D g2d) {
        Rectangle rect = new Rectangle(i*16,j*16,16,16);
        g2d.fill(rect);
        g2d.setColor(tablero.pieza.tile.color.darker());
        g2d.draw(rect);
    }

}
