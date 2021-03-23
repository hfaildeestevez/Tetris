package com.programacion;


import java.util.Arrays;

public class Pieza {


    //Declaramos matriz
    int [][] coordenada;
    Tile tile;
    int [][] rotacion;

    public Pieza(int[][] coordenada,Tile tile) {
        this.coordenada = copiarArray(coordenada);
        this.tile = tile;
        this.rotacion = copiarArray(coordenada);

    }

    public void rotar(){
        int [] desplazamiento=conseguirDesplazamiento();
        int[][] nuevaRotacion = new int[rotacion.length][rotacion[0].length];
        for (int i = 0; i < rotacion.length ; i++) {
            nuevaRotacion[i][0]=-rotacion[i][1];
            nuevaRotacion[i][1]= rotacion[i][0];
        }
        rotacion=nuevaRotacion;
        System.out.println("rotado");

        for (int i = 0; i < coordenada.length; i++) {
            coordenada[i][0]=rotacion[i][0]+desplazamiento[0];
            coordenada[i][1]=rotacion[i][1]+desplazamiento[1];
        }
    }

    public static int[][] copiarArray(int[][] original) {
        int[][] nuevoArray = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            nuevoArray[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return nuevoArray;
    }

    private int[] conseguirDesplazamiento(){
        int x = coordenada[0][0]-rotacion[0][0];
        int y = coordenada[0][1]-rotacion[0][1];
        int[] retorno={x,y};
        return retorno;
    }

    public void moverAbajo(){
        for (var coordenada:coordenada){
            coordenada[1]++;
        }
    }

    public void moverDerecha(){
        for (var coordenada:coordenada){
            coordenada[0]++;
        }
    }

    public void moverIzquierda(){
        for (var coordenada:coordenada){
            coordenada[0]--;
        }
    }

}
