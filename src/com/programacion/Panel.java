package com.programacion;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    Tablero tablero;

    public Panel(Tablero tablero) {
        this.tablero = tablero;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            g2d.drawImage(cargarImagen("E:\\Sistema\\Escritorio\\F.jpg"), 20, 20, null);
        } catch (IOException e) {
            System.out.println("Error al cargar la imagen");
        }
        for (int i=0;i<tablero.campo.length;i++){
            for (int j=0;j <tablero.campo[0].length;j++){
                if (tablero.campo[i][j]==null){
                    break;
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

    public static Image cargarImagen (String ruta) throws IOException {
        BufferedImage img = null;
            img = ImageIO.read(new File(ruta));
            return img;
    }
}
