package com.programacion;

import javax.swing.*;

public class Tetris {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        frame.setSize(640, 480);
        frame.add(new Panel(new Tablero()));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

