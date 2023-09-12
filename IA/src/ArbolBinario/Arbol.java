package ArbolBinario;

public class Arbol extends Nodo{
	private Nodo raiz;
	
	public Arbol() {
		raiz=null;
	}
	
	public void insertaNodo(int Insercion) {
		if(Vacio(raiz)) {
			raiz=new Nodo(Insercion);
		}else {
			raiz.Insertar(Insercion);
		}
	}
	
	//El recorrido se raliza en preorden
	public void IniciaRecorrido() {
		Recorrido(raiz);
	}
	
	public void Recorrido(Nodo nodo) {
		if(Vacio(nodo)) {
			return;
		}
		System.out.print("["+nodo.getConteNodo()+"] ");
		Recorrido(nodo.getNodoIzq());
		Recorrido(nodo.getNodoDer());
	}
	
	public boolean IniciaBusqueda(int valorInsert) {
		Nodo resultado;
		resultado=buscarNodo(raiz, valorInsert);
		if(resultado==null) {
			return false;
		}else {
			if (resultado.getConteNodo()==valorInsert) {return true;}
			else {return false;}
		}
		
	}
	
	public Nodo buscarNodo(Nodo nodo, int valorInsert) {
		if(Vacio(nodo)) {
			return null;
		}else if(nodo.getConteNodo()==valorInsert ) {
			return nodo;
		}
		
		if(valorInsert<nodo.getConteNodo()) {
			System.out.println(nodo.getConteNodo());
			return buscarNodo(nodo.getNodoIzq(), valorInsert);
		}else {
			System.out.println(nodo.getConteNodo());
			return buscarNodo(nodo.getNodoDer(), valorInsert);
		}
		
	}
	
	public boolean Vacio(Nodo nodo) {
		if(nodo==null) {return true;}
		else {return false;}
	}

}
