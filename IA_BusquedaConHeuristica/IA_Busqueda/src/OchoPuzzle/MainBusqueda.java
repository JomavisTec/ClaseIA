package OchoPuzzle;

import java.util.*;

public class MainBusqueda {

	public static void main(String[] args) {
		 Busqueda buscar = new Busqueda();
		 int[][] estadoObjetivo = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
		 
		 int[][] estadoInicial1 = {{1, 2, 3}, {4, 6, 0}, {7, 5, 8}};
		 int[][] estadoInicial2 = {{1, 2, 0}, {4, 5, 3}, {7, 8, 6}};
		 int[][] estadoInicial3 = {{0, 8, 7}, {6, 5, 4}, {3, 2, 1}};
		 
	     int Opcion;
	        
	        Scanner Leer = new Scanner(System.in);
	        
	        while(true) {
	        	System.out.println("OPCIONES:\n 1:Busqueda por anchera\n 2:Busqueda por profundidad\n 3:Busqueda por costo uniforme\n 4:Buqueda por costo uniforme con Heuristica1\n 5:Buqueda por costo uniforme con Heuristica2\n 6:Buqueda por costo uniforme con Heuristica3\n 7:Salir");
	        	Opcion=Leer.nextInt();
	        	
	        	if(Opcion==7) {break;}
	        	switch(Opcion) {
	        		case 1:{
	        	        State resultBpA = buscar.bPorAnchura(estadoInicial3, estadoObjetivo);
	        	        System.out.println("Búsqueda por Anchura:");
	        	        ImprimeSolucion(resultBpA);
	        			break;
	        		}
	        		case 2:{
	        	        State resultBpP = buscar.bPorProfundidad(estadoInicial3, estadoObjetivo);
	        	        System.out.println("Búsqueda por Profundidad:");
	        	        ImprimeSolucion(resultBpP);
	        	        break;
	        		}
	        		case 3:{	        	        
	        			State resultBpCU = buscar.bPorCostoUniforme(estadoInicial3, estadoObjetivo, 0);
	        	        ImprimeSolucion(resultBpCU);
	        	        break;
	        		}
	        		case 4:{
	        			State resultBpCU = buscar.bPorCostoUniforme(estadoInicial3, estadoObjetivo, 1);
	        	        ImprimeSolucion(resultBpCU);
	        			break;
	        		}
	        		case 5:{
	        			State resultBpCU = buscar.bPorCostoUniforme(estadoInicial3, estadoObjetivo, 2);
	        	        ImprimeSolucion(resultBpCU);
	        			break;
	        		}
	        		case 6:{
	        			State resultBpCU = buscar.bPorCostoUniforme(estadoInicial3, estadoObjetivo, 3);
	        	        ImprimeSolucion(resultBpCU);
	        			break;
	        		}
	        		default:{
	        			System.out.println("\nOpcion no disponible");
	        			break;
	        		}
	        	}
	        }  

	}
	
    private static void ImprimeSolucion(State state) {
        if (state == null) {
            System.out.println("No se encontró una solución.");
            return;
        }

        List<State> camino = new ArrayList<>();
        while (state != null) {
            camino.add(state);
            state = state.getParent();
        }

        for (int i = camino.size() - 1; i >= 0; i--) {
            State estadoActual = camino.get(i);
            System.out.println("Paso " + (camino.size() - i - 1) + ":");
            ImprimeEstado(estadoActual.getState());
            System.out.println();
        }
    }
    
    private static void ImprimeEstado(int[][] state) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }

}
