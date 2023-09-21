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
    public static State bPorCostoUniforme(int[][] estadoInicial, int[][] estadoObjetivo) {
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
                    queue.add(successor);
                    visitado.add(Arrays.deepToString(successor.getState()));
                }
            }
        }

        return null;
    }

}