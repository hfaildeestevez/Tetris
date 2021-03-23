package com.programacion;

import java.util.Random;

public class Tablero {
    /**
     * Declaramos o tableiro cos seguintes parametros
     * @param puntuacion
     * @param level
     * @param delay
     * ademais damoslle a funcion random
     */
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
            generarNuevaPieza();

        } catch (Exception e) {
            System.out.println("A vuelto a haber un error");
        }

    }
    /**
     * Chamamos ao metodo generarNuevaPieza e añadimoslle unha excepcion para que o limite sea un 6
       xa que as nosas pezas van enumeradas do 0 ao 6
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
     * Chamamos ao metodo colocarPieza e facemos que un foreach recorra o array
     */
    private void colocarPieza (){
        for (var coordenada: pieza.coordenada){
            int x=coordenada[0];
            int y=coordenada[1];
            campo [x][y]=pieza.tile;
        }
        generarNuevaPieza();
    }
    /**
     * Chamamos ao metodo colisionar e aañdimoslle unha excepcion
     */
    private boolean colisionar (int x,int y){
        try{
            return x> campo.length-1 || y>campo[0].length-1  || campo[x][y] !=null;
        }catch(IndexOutOfBoundsException e){
            return true;
        }
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
        else{
            colocarPieza();
            comprobarLinea();
            //generarNuevaPieza();
        }
    }
    /**
     * Chamamos ao metodo colisionarPieza
     */
    private boolean colisionarPieza(int desplazamientox, int desplazamientoy) {
        boolean colisiona = false;
        for (var coordenada:pieza.coordenada) {
            if (colisionar(coordenada[0]+desplazamientox,coordenada[1]+desplazamientoy))
                colisiona=true;
        }
        return colisiona;
    }
    /**
     * Chamamos ao metodo moverPiezaDerecha
     */
    public void moverPiezaDerecha(){
        if (!colisionarPieza(1,0)){
            pieza.moverDerecha();
        }
    }
    /**
     * Chamamos ao metodo moverPiezaIzquierda
     */
    public void moverPiezaIzquierda(){
        if (!colisionarPieza(-1,0)){
            pieza.moverIzquierda();
        }
    }
    /**
     * Chamamos ao metodo RotarPieza
     */
    public void rotarPieza(){
        pieza.rotar();
        if (colisionarPieza(0, 0)) {
            pieza.rotar();
            pieza.rotar();
            pieza.rotar();
        }
    }
   /**
 * Chamamos ao metodo moverabajo
 */
    public void moverPiezaAbajo(){
        if (!colisionarPieza(0,1)){
            pieza.moverAbajo();
        }
    }
}

