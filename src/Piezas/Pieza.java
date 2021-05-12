package Piezas;


import java.util.Arrays;

public class Pieza {

    /**
     * chamamos a matriz e a clase tile
     */
    public int [][] coordenada;
    public Tile tile;
    int [][] rotacion;

    public Pieza(int[][] coordenada,Tile tile) {
        this.coordenada = copiarArray(coordenada);
        this.tile = tile;
        this.rotacion = copiarArray(coordenada);

    }
    /**
     * Implementamos o metodo rotar
     */
    public void rotar(){
        int [] desplazamiento=conseguirDesplazamiento();
        int[][] nuevaRotacion = new int[rotacion.length][rotacion[0].length];
        for (int i = 0; i < rotacion.length ; i++) {
            nuevaRotacion[i][0]=-rotacion[i][1];
            nuevaRotacion[i][1]= rotacion[i][0];
        }
        rotacion=nuevaRotacion;

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
    /**
     * Implementamos o metodo conseguir desplazamiento
     */
    private int[] conseguirDesplazamiento(){
        int x = coordenada[0][0]-rotacion[0][0];
        int y = coordenada[0][1]-rotacion[0][1];
        int[] retorno={x,y};
        return retorno;
    }
    /**
     * Implementamos o metodo para que as pezas vaian caindo cara abaixo no tableiro
     */
    public void moverAbajo(){
        for (var coordenada:coordenada){
            coordenada[1]++;
        }
    }
    /**
     * Implementamos o metodo para mover as pezas a dereita
     */
    public void moverDerecha(){
        for (var coordenada:coordenada){
            coordenada[0]++;
        }
    }
    /**
     * Implementamos o metodo para mover as pezas a esquerda
     */
    public void moverIzquierda(){
        for (var coordenada:coordenada){
            coordenada[0]--;
        }
    }

}
