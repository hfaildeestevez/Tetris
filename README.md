# Tetris

Nuestro codigo recrea el juego clasico Tetris.

El programa tiene las opciones basicas de un tetris que son que la pieza baje, y puedes desplazarla a la izquierda y a la derecha y rotar la pieza a conveniencia.
Para ello creamos una serie de clases: una clase "Pieza" en la que se establecen los parametros de la pieza, una clase "Tablero" en la que se crean los metodos referentes as fondo donde se colocan las piezas, una clase "Panel" en la que se crea la ventana que aparece al ejecutar el juego y tambien como dibujar las piezas en el tablero. Hemos empleado "JPanel" para crear la interfaz gráfica y la clase "color" de la librería "awt" para añadirle color a las piezas y también tenemos un factory recogido en la clase "PiezaFactory".

Las clases estan divididas en los paquetes "Lógica" en el cual se centra en la lógica del juego, el paquete "Interfaz" que recoge las clases que interfieren en esta y el paquete "Piezas" que recoge las clases relacionadas con la creación y desplazamiento de piezas.

Hemos empleado JPanel para crear la interfaz gráfica y la clase color de la librería awt para añadirle color a las piezas.

Dichas piezas estan declaradas en una matriz bidimensional que recoge las coordenadas de las mismas y se la transmite a los métodos pertinentes para que puedan generarlas, moverlas y rotarlas.

El juego consiste en completar líneas, cuando se completa una línea esta se elimina y se aumenta en uno la variable puntuacion. Esta variable se recoge al final de la partida (que será en cuanto una columna no sea vacía) en un fichero .txt y se pedirá el nombre del usuario para poner al lado de la puntuación, a medida que se van completando partidas las puntuaciones se irán ordenando por llegada, siendo la primera la puntuación la primera partida jugada. En el caso de no introducir nombre se guardará por defecto como null y al lado la puntuación obtenida.


Proyecto creado por Pablo Pereira Moure y Héctor Faílde Estévez.


