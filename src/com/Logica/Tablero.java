package com.Logica;

import Piezas.Pieza;
import Piezas.PiezaFactory;
import Piezas.Tile;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Tablero {
    /**
     * Aqui instanciamos la tile y llamamos ala  pieza
     *Usamos un generador aleatorio para que nos vaya dando las piezas
     */
    public Tile[][] campo;
    public Pieza pieza;
    int puntuacion;
    int level;
    int delay;
    Random generadorAleatorio;

    public Tablero() {
        generadorAleatorio = new Random();
        level = 0;
        puntuacion = 0;
        campo = new Tile[10][20];
        try {
            generarNuevaPieza();

        } catch (Exception e) {
            System.out.println("A vuelto a haber un error");
        }
    }

    /**
     * Metodo generar nueva pieza que lo sacara de la clase PiezaFactory
     */
    private void generarNuevaPieza() {
        try {
            pieza = PiezaFactory.getPieza(generadorAleatorio.nextInt(6));
        } catch (Exception e) {
            System.out.println("Un error sin mas");
        }
        pieza.moverDerecha();
    }

    /**
     * Metodo colocar pieza para que la pieza se coloque en el sitio que queremos
     */
    private void colocarPieza() {
        for (var coordenada : pieza.coordenada) {
            int x = coordenada[0];
            int y = coordenada[1];
            if (y < 0) {
                partidaFinalizada();
            }
            campo[x][y] = pieza.tile;
        }
        generarNuevaPieza();
    }

    /**
     *Metodo colisionar para detectar si hay colision entre piezas y evitar que esta se salga del tablero
     */
    private boolean colisionar(int x, int y) {
        try {
            return x > campo.length - 1 || y > campo[0].length - 1 || campo[x][y] != null;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
    }

    /**
     * Con este metpdp recorre el tablero y en caso de una linea este llena la elimina y aumenta un punto
     */
    private void comprobarLinea() {
        boolean completa;
        for (int j = 0; j < campo[0].length; j++) {//numero de fila (segunda coordenada)
            completa = true;
            for (int i = 0; i < campo.length; i++) {
                if (campo[i][j] == null) {
                    completa = false;
                    break;
                }
            }
            if (completa) {
                moverPosiciones(j);
            }
        }
    }

    /**
     *Tras eliminar una fila este metodo mueve la fila superior una posicion abajo
     */
    private void moverPosiciones(int fila) {
        Tile[][] nuevoCampo = transposeArray(campo);
        for (int i =fila-1; i >0; i--) {
            nuevoCampo[i+1]=nuevoCampo[i];
            System.out.println(String.format("Fila %d movida a %d", i+1,i));
        }
        campo = transposeArray(nuevoCampo);
        puntuacion++;
    }

    /**
     * Este metodo actualiza el tablero tras mover la fila
     */
    public void update() {
        if (!colisionarPieza(0, 1)) {
            pieza.moverAbajo();
        } else {
            colocarPieza();
            comprobarLinea();
        }
    }

    private boolean colisionarPieza(int desplazamientox, int desplazamientoy) {
        boolean colisiona = false;
        for (var coordenada : pieza.coordenada) {
            if (colisionar(coordenada[0] + desplazamientox, coordenada[1] + desplazamientoy)) {
                colisiona = true;
            }
        }
        return colisiona;
    }

    public void moverPiezaDerecha() {
        if (!colisionarPieza(1, 0)) {
            pieza.moverDerecha();
        }
    }

    public void moverPiezaIzquierda() {
        if (!colisionarPieza(-1, 0)) {
            pieza.moverIzquierda();
        }
    }

    public void rotarPieza() {
        pieza.rotar();
        if (colisionarPieza(0, 0)) {
            pieza.rotar();
            pieza.rotar();
            pieza.rotar();
        }
    }

    public void moverPiezaAbajo() {
        if (!colisionarPieza(0, 1)) {
            pieza.moverAbajo();
        }
    }

    public static Tile[][] transposeArray(Tile[][] array) {
        int m = array.length;
        int n = array[0].length;

        Tile[][] transposedArray = new Tile[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                transposedArray[x][y] = array[y][x];
            }
        }

        return transposedArray;
    }

    /**
     * Delimitamos el campo sobre el que se desarrollara el juego
     */
    public  String printCampo() {
        int m = campo.length;
        int n = campo[0].length;

        String tmp = "";
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                tmp = tmp + campo[y][x] + " ";
            }
            tmp = tmp + "\n";
        }

        return tmp;
    }

    /**
     * Con este metodo finalizamos la partida tras llenar al menos una fila del tablero
     */
    private void partidaFinalizada() {
        JOptionPane.showMessageDialog(null, "GAME OVER \n \n Tu puntuación es:" + puntuacion);
        //pedir nombre
        String nombre = JOptionPane.showInputDialog(null, "Cual es tu nombre?");
        //guardar nombre a un fichero
        File ficheroRanking =new File("puntos.txt");
        try {

            if (!ficheroRanking.exists()) {
                ficheroRanking.createNewFile();
            }
            FileWriter fw = new FileWriter(ficheroRanking,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(nombre+" "+puntuacion+ "\n");
            bw.close();
            System.out.println("Puntuación escrita");
        } catch (IOException ex) {
            System.out.println("Error al escribir la puntuación en un fichero");
        }
        System.exit(0);



    }
}