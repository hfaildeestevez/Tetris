package com.programacion;

public class Tablero {

    Tile [][] campo;
    Pieza pieza;
    int puntuacion;
    int level;
    int gravedad;

    private void colocarPieza (){
        for (var coordenada: pieza.coordenadas){
            int x=coordenada[0];
            int y=coordenada[1];
            campo [x][y]=pieza.tile;
        }
    }

    private boolean colisionar (int x,int y){
        return campo!=null;
    }

}
