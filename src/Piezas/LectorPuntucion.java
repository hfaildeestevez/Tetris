package com.programacion;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorPuntucion {

    public static void leer() {
        File puntuacion = new File("puntos.txt");
        FileReader fr;
        String s = "Puntuaciones:\n";
        try {
            fr = new FileReader(puntuacion);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()) {
                s += br.readLine()+"\n";
            }
        } catch (IOException ex) {
            System.out.println("Error leyendo puntuación");
            return;
        }
        JOptionPane.showMessageDialog(null,s);
    }
}
