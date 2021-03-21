package com.programacion;

import java.util.Random;

public class Tablero {

    Tile [][] campo;
    Pieza pieza;
    int puntuacion;
    int level;
    int delay;
    Random generadorAleatorio;

    public Tablero() {
        generadorAleatorio =new Random();
        level = 0;
        puntuacion = 0;
        campo = new Tile[10][20];
        try {
            pieza = PiezaFactory.getPieza(generadorAleatorio.nextInt(6));
            pieza.moverDerecha();
            pieza.moverDerecha();
            pieza.moverDerecha();
            pieza.moverDerecha();

        } catch (Exception e) {
            System.out.println("A vuelto a avidar un eeror");
        }

    }

    private void colocarPieza (){
        for (var coordenada: pieza.coordenada){
            int x=coordenada[0];
            int y=coordenada[1];
            campo [x][y]=pieza.tile;
        }
        try {
            pieza = PiezaFactory.getPieza(generadorAleatorio.nextInt(6));
        } catch (Exception e) {
            System.out.println("A avido un eeror");
        }

    }

    private boolean colisionar (int x,int y){

        return campo[x][y]!=null;

    }

    private void comprobarLinea (){
        for (int i =0;i<campo.length;i++){
            boolean completado=true;
            for (int j =0; j<campo[0].length;j++){
                if (campo[i][j]==null){
                    completado=false;
                }
            }
            if (completado){
                moverPosiciones(i);
            }
        }
    }

    private void moverPosiciones(int columna){
        for (int i =0;i<columna;i++){
            campo [i+1] = campo[i];
        }
    }

    public void update (){
        if (!colisionarPieza(0,1)){
            pieza.moverAbajo();
        }
    }

    private boolean colisionarPieza(int desplazamientox, int desplazamientoy) {
        boolean colisiona = false;
        for (var coordenada:pieza.coordenada) {
            if (colisionar(coordenada[0]+desplazamientox,coordenada[1]+desplazamientoy))
                colisiona=true;
        }
        return colisiona;
    }
}
