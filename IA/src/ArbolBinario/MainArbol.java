package ArbolBinario;

import java.util.*;

public class MainArbol {
		
	public static void main(String[] args) {
		Scanner Lee = new Scanner(System.in);
		Arbol arbol = new Arbol();
		int valorInsert, valorBuscar;
		
		System.out.println("Ingrese valores al arbol");
		for(int i = 0; i < 9; i++) {
			System.out.print("Valor "+ (i+1)+": ");
			valorInsert = Lee.nextInt();
			arbol.insertaNodo(valorInsert);
		}
		arbol.IniciaRecorrido();
		
		System.out.println("\n\nIngrese el valor que desea buscar: ");
		valorBuscar=Lee.nextInt();
		if(arbol.IniciaBusqueda(valorBuscar)) {
			System.out.println("Se encontro el nodo");
		}else {
			System.out.println("no se encontro el nodo");
		}
	}

}
