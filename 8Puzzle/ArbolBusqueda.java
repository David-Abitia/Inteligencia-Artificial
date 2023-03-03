package Puzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    //Busqueda por Anchura
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.imprimirSolucion());
    }
    
    //Busqueda por Profundidad 
    public void busquedaPorProfundidad()
    {
        Nodo nodoActual = raiz, nodoFinal;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(nodoActual.imprimirSolucion());
    }
    
    //primera heuristica
    public Comparator<Nodo> primeraHeuristica() 
    {
        Comparator<Nodo> com = new Comparator<Nodo>() 
        {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) 
            {
            	return primeraHeuristica(raiz.getEstado());
            }
        };
        return com;
    }
    
    public int primeraHeuristica(String est) 
    {
		
		int heuristicaVal = 0;
		
		for(int i = 0; i < est.length(); i++) 
		{
			if(est.charAt(i) != objetivo.charAt(i)) 
			{
				heuristicaVal++;
			}
		}
		return heuristicaVal;
	}
    
    
    //segunda heuristica
    public Comparator<Nodo> segundaHeuristica() 
    {
        Comparator<Nodo> com = new Comparator<Nodo>() 
        {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) 
            {
            	return segundaHeuristica(raiz.getEstado());
            }
        };
        return com;
    }
    
	private int segundaHeuristica(String est) 
	{
		
		int heuristicaVal = 0, primerCaracter = 0, segundoCaracter = 0, caracterHeuristica = 0;
		
		for(int i = 0; i < est.length(); i++) 
		{
			caracterHeuristica = 0;
			primerCaracter = (int) est.charAt(i);
			segundoCaracter = (int) objetivo.charAt(i);
			caracterHeuristica = primerCaracter - segundoCaracter;
			caracterHeuristica = Math.abs(caracterHeuristica);
			heuristicaVal = caracterHeuristica + heuristicaVal;
		}
		return heuristicaVal;
	}

	
    //tercera heuristica
    public Comparator<Nodo> terceraHeuristica() 
    {
        Comparator<Nodo> com = new Comparator<Nodo>() 
        {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) 
            {
            	return terceraHeuristica(raiz.getEstado());
            }
        };
        return com;
    }

    public int terceraHeuristica(String est) 
    {
        int horizontal = 0, vertical = 0;
        int Objhtzl = 0, Objver = 0;
        int retornar = 0;


        retornar = 0;
        horizontal =  (int)est.charAt(0)  +  (int)est.charAt(1)  +  (int) est.charAt(2);
        Objhtzl =  (int) objetivo.charAt(0)  +  (int) objetivo.charAt(1)  +  (int) objetivo.charAt(2);
        retornar += Math.abs(horizontal - Objhtzl);


        horizontal =  (int)est.charAt(3)  +  (int)est.charAt(4)  +  (int) est.charAt(5);
        Objhtzl =  (int) objetivo.charAt(3)  +  (int) objetivo.charAt(4)  +  (int) objetivo.charAt(5);
        retornar += Math.abs(horizontal - Objhtzl);

        
        horizontal =  (int)est.charAt(6)  +  (int)est.charAt(7)  +  (int) est.charAt(8);
        Objhtzl =  (int) objetivo.charAt(6)  +  (int) objetivo.charAt(7)  +  (int) objetivo.charAt(8);
        retornar += Math.abs(horizontal - Objhtzl);

        
        vertical =  (int)est.charAt(0)  +  (int)est.charAt(3)  +  (int) est.charAt(6);
        Objver =  (int)objetivo.charAt(0)  +  (int)objetivo.charAt(3)  +  (int) objetivo.charAt(6);
        retornar += Math.abs(vertical - Objver);

        
        vertical =  (int)est.charAt(1)  +  (int)est.charAt(4)  +  (int) est.charAt(7);
        Objver =  (int)objetivo.charAt(1)  +  (int)objetivo.charAt(4)  +  (int) objetivo.charAt(7);
        retornar += Math.abs(vertical - Objver);

        
        vertical =  (int)est.charAt(2)  +  (int)est.charAt(5)  +  (int) est.charAt(8);
        Objver =  (int)objetivo.charAt(2)  +  (int)objetivo.charAt(5)  +  (int) objetivo.charAt(8);
        retornar += Math.abs(vertical - Objver);

        
        return retornar;
    }
    
	//Busqueda Heuristica 
    public void heuristicaBusqueda(int Heuristica)
    {
    	Comparator<Nodo> heuristica = null;
    	switch (Heuristica) 
    	{
	    	case 1:
	    		heuristica = primeraHeuristica();
	    		break;
	    	case 2:
	    		heuristica = segundaHeuristica();
	    		break;
	    	case 3:
	    		heuristica = terceraHeuristica();
	    		break;
    	}
    	
    	
        Nodo nodo = raiz;
        Collection<String> estadosRevisado = new ArrayList();
        PriorityQueue<Nodo> estadosXRevisar = new PriorityQueue(heuristica);
        while(!nodo.getEstado().equals(objetivo))
        {
        	estadosRevisado.add(nodo.getEstado());
            Collection<String> hijos = nodo.generaHijos();	
            for (String hijo : hijos) {
                if(!estadosRevisado.contains(hijo))
                {
                    
                    Nodo nodoHijo = new Nodo(hijo);
                    nodoHijo.setPadre(nodo);
                    estadosXRevisar.add(nodoHijo);
                }
            }
            nodo = estadosXRevisar.poll();
        }
        
        System.out.println(nodo.imprimirSolucion());
    }
    
    
}