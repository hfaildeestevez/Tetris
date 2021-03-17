package com.programacion;

public class Piezas {


    //Declaramos matriz
    int [][] coordenada;
    Tile tl;


        public void rotar()
        {
            // Rotamos a peza
            for(var coordenada: coordenada) {
                coordenada [0]=-coordenada[1];
                coordenada [1]=coordenada[0]
            }


        }


    }

}
