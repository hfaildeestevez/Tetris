package com.Logica;


import Interfaz.Ventana;
import Piezas.LectorPuntucion;

public class Tetris {

    /**
     *
     * object Ventana para llamar a la interfaz grafica
     *Importamos la clase LectorPuntuacion para guardar las puntuaciones de los jugadores
     */
//comentario para subir
    public static void main(String[] args) {
        Ventana ventana= new Ventana();
        ventana.setVisible(true);
        LectorPuntucion.leer();
    }
}

