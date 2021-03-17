package com.programacion;

public class Pieza {


    //Declaramos matriz
    int [][] coordenada;
    Tile tile;


        public void rotar()
        {
            // Rotamos a peza
            for(var coordenada: coordenada) {
                coordenada [0]=-coordenada[1];
                coordenada [1]=coordenada[0];
            }


        }


    }


