package OchoPuzzle;

import java.util.*;



public class ochoPuzzle {
	
	public ochoPuzzle() {};

    public static List<State> generaSucesor(State estadoActual) {
        List<State> sucesores = new ArrayList<>();
        int fila = -1, columna = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (estadoActual.getState()[i][j] == 0) {
                    fila = i;
                    columna = j;
                    break;
                }
            }
        }

        // if's para mover hacia arriba, abajo, izquierda o derecha
        if (fila > 0) {
            int[][] newState = intercambia(estadoActual.getState(), fila, columna, fila - 1, columna);
            sucesores.add(new State(newState, estadoActual.getCost() + 1, estadoActual));
        }

        if (fila < 2) {
            int[][] newState = intercambia(estadoActual.getState(), fila, columna, fila + 1, columna);
            sucesores.add(new State(newState, estadoActual.getCost() + 1, estadoActual));
        }

        if (columna > 0) {
            int[][] newState = intercambia(estadoActual.getState(), fila, columna, fila, columna - 1);
            sucesores.add(new State(newState, estadoActual.getCost() + 1, estadoActual));
        }

        if (columna < 2) {
            int[][] newState = intercambia(estadoActual.getState(), fila, columna, fila, columna + 1);
            sucesores.add(new State(newState, estadoActual.getCost() + 1, estadoActual));
        }

        return sucesores;
    }

    // Función para intercambiar dos posiciones en el tablero
    public static int[][] intercambia(int[][] state, int fila1, int columna1, int fila2, int columna2) {
        int[][] newState = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newState[i][j] = state[i][j];
            }
        }
        int temp = newState[fila1][columna1];
        newState[fila1][columna1] = newState[fila2][columna2];
        newState[fila2][columna2] = temp;
        return newState;
    }

    // Función para verificar si un estado es el objetivo
    public static boolean compruebaObjetivo(int[][] state, int[][] estadoObjetivo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[i][j] != estadoObjetivo[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}