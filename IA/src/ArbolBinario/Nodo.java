package ArbolBinario;

public class Nodo {
	private Nodo nodoIzq, nodoDer;
	private int conteNodo;
	private boolean Estado;
	
	public Nodo() {}
	
	public Nodo(int conteNodo) 
	{
		this.conteNodo=conteNodo;
		nodoIzq=nodoDer=null;
	}
	
	public void Insertar(int insercion) {
		if(insercion<conteNodo) {
			if(nodoIzq==null) {
				nodoIzq=new Nodo(insercion);
			}
			else {
				nodoIzq.Insertar(insercion);
			}
		}else if(insercion>conteNodo) {
			if(nodoDer==null) {
				nodoDer = new Nodo(insercion);
			}else {
				nodoDer.Insertar(insercion);
			}
		}
	}
	
	public int getConteNodo() {
		return conteNodo;
	}

	public Nodo getNodoIzq() {
		return nodoIzq;
	}

	public Nodo getNodoDer() {
		return nodoDer;
	}
}
