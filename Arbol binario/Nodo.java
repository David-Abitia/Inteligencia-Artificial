package ArbolesBinarios;

public class Nodo {
	
	int dato;
	String nombre;
	Nodo hijoizq, hijoder;
	
	public Nodo(int d, String nom)
	{
		this.dato=d;
		this.nombre=nom;
		this.hijoder=null;
		this.hijoizq=null;
	}
	
	public String toString()
	{
		return nombre+" su dato es "+dato;
	}
}
