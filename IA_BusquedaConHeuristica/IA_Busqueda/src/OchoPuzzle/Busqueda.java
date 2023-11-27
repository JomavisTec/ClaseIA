package OchoPuzzle;

import java.util.*;



public class Busqueda {
	static ochoPuzzle puzzle;
	
	public Busqueda() {
		
	}
	
	 // Algoritmo de búsqueda por anchura
    public static State bPorAnchura(int[][] estadoInicial, int[][] estadoObjetivo) {
        Queue<State> queue = new LinkedList<>();
        Set<String> visitado = new HashSet<>();

        State initialStateObj = new State(estadoInicial, 0, null);
        queue.add(initialStateObj);
        visitado.add(Arrays.deepToString(estadoInicial));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (puzzle.compruebaObjetivo(currentState.getState(), estadoObjetivo)) {
                return currentState;
            }

            List<State> successors = puzzle.generaSucesor(currentState);
            for (State successor : successors) {
                if (!visitado.contains(Arrays.deepToString(successor.getState()))) {
                    queue.add(successor);
                    visitado.add(Arrays.deepToString(successor.getState()));
                }
            }
        }
        
        return null;
    }

    // Algoritmo de búsqueda por profundidad
    public static State bPorProfundidad(int[][] estadoInicial, int[][] estadoObjetivo) {
        Stack<State> stack = new Stack<>();
        Set<String> visitado = new HashSet<>();

        State initialStateObj = new State(estadoInicial, 0, null);
        stack.push(initialStateObj);
        visitado.add(Arrays.deepToString(estadoInicial));

        while (!stack.isEmpty()) {
            State currentState = stack.pop();

            if (puzzle.compruebaObjetivo(currentState.getState(), estadoObjetivo)) {
                return currentState;
            }

            List<State> successors = puzzle.generaSucesor(currentState);
            for (State successor : successors) {
                if (!visitado.contains(Arrays.deepToString(successor.getState()))) {
                    stack.push(successor);
                    visitado.add(Arrays.deepToString(successor.getState()));
                }
            }
        }

        return null;
    }

    // Algoritmo de búsqueda por costo uniforme
    public static State bPorCostoUniforme(int[][] estadoInicial, int[][] estadoObjetivo, int hSeleccionada) {
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.getCost()));
        Set<String> visitado = new HashSet<>();

        State initialStateObj = new State(estadoInicial, 0, null);
        queue.add(initialStateObj);
        visitado.add(Arrays.deepToString(estadoInicial));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (puzzle.compruebaObjetivo(currentState.getState(), estadoObjetivo)) {
                return currentState;
            }

            List<State> successors = puzzle.generaSucesor(currentState);
            for (State successor : successors) {
                if (!visitado.contains(Arrays.deepToString(successor.getState()))) {
                	
                	if(hSeleccionada==1) {
                		 int heuristicValue = bHeuristica1(successor.getState(), estadoObjetivo);
                         successor.setCost(successor.getCost() + heuristicValue);
                	}
                	if(hSeleccionada==2) {
               		 int heuristicValue = bHeuristica2(successor.getState(), estadoObjetivo);
                        successor.setCost(successor.getCost() + heuristicValue);
                	}
                	if(hSeleccionada==3) {
                  		 int heuristicValue = bHeuristica3(successor.getState(), estadoObjetivo);
                           successor.setCost(successor.getCost() + heuristicValue);
                   	}
                	
                	
                    queue.add(successor);
                    visitado.add(Arrays.deepToString(successor.getState()));
                }
            }
        }

        return null;
    }
    
    public static int bHeuristica1(int[][] currentState, int[][] goalState) {
        int heuristicValue = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                int value = currentState[i][j];
                if (value != 0) {
                    int goalRow = (value - 1) / currentState.length;
                    int goalCol = (value - 1) % currentState[i].length;
                    heuristicValue += Math.abs(i - goalRow) + Math.abs(j - goalCol);
                }
            }
        }
        return heuristicValue;
    }
    
    public static int bHeuristica2(int[][] currentState, int[][] goalState) {
        int heuristicValue = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                if (currentState[i][j] != goalState[i][j]) {
                    heuristicValue++;
                }
            }
        }
        return heuristicValue;
    }
    
    public static int bHeuristica3(int[][] currentState, int[][] goalState) {
        int heuristicValue = 0;
        for (int i = 0; i < currentState.length; i++) {
            for (int j = 0; j < currentState[i].length; j++) {
                int value = currentState[i][j];
                if (value != 0) {
                    int goalRow = (value - 1) / currentState.length;
                    int goalCol = (value - 1) % currentState[i].length;
                    heuristicValue += Math.sqrt(Math.pow(i - goalRow, 2) + Math.pow(j - goalCol, 2));
                }
            }
        }
        return heuristicValue;
    }

}