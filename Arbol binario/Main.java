package ArbolesBinarios;

public class Main {

	public static void main(String[] args) {
		

	        Arbol ArbolBinario = new Arbol();
	        //Insertar datos
	        System.out.println("Insertar datos:\n");
	        ArbolBinario.InsertarNodo(0,"D");
	        ArbolBinario.InsertarNodo(3,"J");
	        ArbolBinario.InsertarNodo(7,"l");
	        ArbolBinario.InsertarNodo(2,"E");
	        ArbolBinario.InsertarNodo(9,"L");
	        ArbolBinario.InsertarNodo(8,"J");
	        
	        //imprimiendo arbol
	        System.out.println("Imprimiendo arbol");
	        ArbolBinario.preorden(ArbolBinario.getRaiz());
	        
	        ArbolBinario.vacio();

	        System.out.println("Buscar Nodo: "+ArbolBinario.buscarNodo("E"));



	    
	}

}



