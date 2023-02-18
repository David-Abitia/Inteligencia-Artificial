package ArbolesBinarios;

public class Arbol {

	Nodo raiz;
	
	public Arbol()
	{
		raiz=null;
	}
	
	//metodo para insertar un nodo en el arbol
	public void InsertarNodo(int d, String nom)
	{
		Nodo nuevo = new Nodo(d,nom);
		if(raiz==null)
		{
			raiz=nuevo;
		}
		else 
		{
			Nodo auxiliar=raiz;
			Nodo padre;
			while(true)
			{
				padre=auxiliar;
				if(d<auxiliar.dato)
				{
					auxiliar=auxiliar.hijoizq;
					if(auxiliar==null)
					{
						padre.hijoizq=nuevo;
						return;
					}
				}
				else
				{
					auxiliar=auxiliar.hijoder;
					if(auxiliar==null)
					{
						padre.hijoder=nuevo;
						return;
					}
				}
			}
		}
	}
	
	//metodo para saber si el arbol esta vacio
	public boolean vacio()
	{
		return raiz==null;
	}
	
	//metodo para recorrer el arbol inorden
	public void inorden(Nodo r)
	{
		if(r!=null)
		{
			inorden(r.hijoizq);
			System.out.println(r.dato +" - "+ r.nombre);
			inorden(r.hijoder);
		}
	}
	
	//metodo para recorrer el arbol preorden
	public void preorden(Nodo r)
	{
		if(r!=null)
		{
			System.out.println(r.dato +" - "+ r.nombre);
			preorden(r.hijoizq);
			preorden(r.hijoder);
		}
	}


		//metodo para recorrer el arbol postorden
		public void postorden(Nodo r)
		{
			if(r!=null)
			{
				postorden(r.hijoizq);
				postorden(r.hijoder);
				System.out.println(r.dato +" - "+ r.nombre);
			}
		}
		
		public Nodo getRaiz() {
			return raiz;
		}

		public void setRaiz(Nodo raiz) {
			this.raiz = raiz;
		}
	
    //metodo para buscar nodo
    public Nodo buscarNodo(String nombre) {
        if (vacio()) {
            return null;
        } else {
            Nodo nodoActual = raiz;
            while (nodoActual != null) {
                if (nombre.equalsIgnoreCase(nodoActual.nombre)) {
                    return nodoActual;
                } else if (nombre.compareToIgnoreCase(nodoActual.nombre) < 0) {
                    nodoActual = nodoActual.hijoizq;
                } else if (nombre.compareToIgnoreCase(nodoActual.nombre) > 0) {
                    nodoActual = nodoActual.hijoder;
                }else {
                    nodoActual = nodoActual.hijoder;
                }
            }
            return null;
        }
    }
	
	
}
