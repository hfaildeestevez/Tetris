package com.programacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {

        /**
         * Variable que controla los eventos temporales del juego
         */
        private Timer Temporizador;

        /**
         * Donde discurre toda la logica del juego
         */

        private Tablero tablero;
        private int delay;
        private int numFrames;

        /**
         * Constructor
         */

        public Ventana()
        {
            setSize(180, 360);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            delay = 3;
            numFrames = 0;

            tablero = new Tablero();
            Panel panel = new Panel(tablero);
            add(panel);

            // Creamos el temporizador
            Temporizador = new Timer(1000/7, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    numFrames++;
                    if (numFrames%delay==0){
                    tablero.update();
                    }
                    panel.repaint();

                }
            });

            // Iniciamos el juego
            Temporizador.start();
        }

    }

