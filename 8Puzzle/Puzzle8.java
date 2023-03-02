package Puzzle;

import java.util.Collection;

public class Puzzle8 {

    public static String estadoInicial = "41275386 "; 
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
//        //Instanciar el arbol
    	  ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
//        //Ejecuta la busqueda
    	  
    	  System.out.println("Busqueda por Anchura");
    	  a.busquedaPorAnchura();
    	  System.out.println("Busqueda por Profundidad");
    	  a.busquedaPorProfundidad();
        
    	  System.out.println("Busqueda por Heuristica");
        	a.heuristicaBusqueda(1);
        	System.out.println("Termina heurística  1 \n");
        	a.heuristicaBusqueda(2);
        	System.out.println("Termina heurística  2 \n");
        
//        //Imprime movimientos
//        
//        /*
//        Nodo n = new Nodo(estadoInicial);
//        Collection<String> c = n.generaHijos();
//        c = c;
//        */
        
    }
        
    }
    