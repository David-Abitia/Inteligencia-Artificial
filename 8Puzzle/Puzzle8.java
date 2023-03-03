package Puzzle;

import java.util.Collection;

public class Puzzle8 {

    public static String estadoInicial = "12 453786"; 
    public static String estadofinal = "12345678 ";
    
    public static void main(String[] args) {

    			//----------------Estado Rapido-------------------
    			System.out.println("Estado rapido \n");
                ArbolBusqueda arbol = new ArbolBusqueda(new Nodo(estadoInicial), estadofinal);
                
                // Mide algoritmo por anchura

                long comienza = System.nanoTime();

                arbol.busquedaPorAnchura();

                long finaliza = System.nanoTime();

                double TiempoPorAnchura = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo por profundidad 

                comienza = System.nanoTime();

                arbol.busquedaPorProfundidad();

                finaliza = System.nanoTime();

                double TiempoPorProfundidad = (double) (finaliza - comienza) / 1000000000;


                // Mide algoritmo heuristica 1

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(1);
            	System.out.println("Termina heurística  1 \n");

                
                finaliza = System.nanoTime();

                double TiempoPrimerHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 2

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(2);
            	System.out.println("Termina heurística  2 \n");

                
                finaliza = System.nanoTime();

                double TiempoSegundaHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 3

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(3);
            	System.out.println("Termina heurística  3 \n");

                
                finaliza = System.nanoTime();

                double TiempoTerceraHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Imprime

                System.out.println("Anchura: " + TiempoPorAnchura);
                System.out.println("Profundidad: " + TiempoPorProfundidad);
                System.out.println("Heuristica 1: " + TiempoPrimerHeuristica);
                System.out.println("Heuristica 2: " + TiempoSegundaHeuristica);
                System.out.println("Heuristica 3: " + TiempoTerceraHeuristica);

    			//----------------Estado Medio-------------------
    			System.out.println("\nEstado medio \n");

                estadoInicial = "41275386 ";
                arbol = new ArbolBusqueda(new Nodo(estadoInicial), estadofinal);
                
                // Mide algoritmo por anchura

                 comienza = System.nanoTime();

                arbol.busquedaPorAnchura();

                 finaliza = System.nanoTime();

                 TiempoPorAnchura = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo por profundidad 

                comienza = System.nanoTime();

                arbol.busquedaPorProfundidad();

                finaliza = System.nanoTime();

                 TiempoPorProfundidad = (double) (finaliza - comienza) / 1000000000;


                // Mide algoritmo heuristica 1

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(1);
            	System.out.println("Termina heurística  1 \n");

                
                finaliza = System.nanoTime();

                 TiempoPrimerHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 2

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(2);
            	System.out.println("Termina heurística  2 \n");

                
                finaliza = System.nanoTime();

                 TiempoSegundaHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 3

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(3);
            	System.out.println("Termina heurística  3 \n");

                
                finaliza = System.nanoTime();

                 TiempoTerceraHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Imprime

                System.out.println("Anchura: " + TiempoPorAnchura);
                System.out.println("Profundidad: " + TiempoPorProfundidad);
                System.out.println("Heuristica 1: " + TiempoPrimerHeuristica);
                System.out.println("Heuristica 2: " + TiempoSegundaHeuristica);
                System.out.println("Heuristica 3: " + TiempoTerceraHeuristica);

                
    			//----------------Estado Lento-------------------
    			System.out.println("\nEstado lento \n");

                estadoInicial = "865723 41";
                arbol = new ArbolBusqueda(new Nodo(estadoInicial), estadofinal);
                
                // Mide algoritmo por anchura

                comienza = System.nanoTime();

                arbol.busquedaPorAnchura();

                finaliza = System.nanoTime();

                TiempoPorAnchura = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo por profundidad 

                comienza = System.nanoTime();

                arbol.busquedaPorProfundidad();

                finaliza = System.nanoTime();

                TiempoPorProfundidad = (double) (finaliza - comienza) / 1000000000;


                // Mide algoritmo heuristica 1

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(1);
            	System.out.println("Termina heurística  1 \n");

                
                finaliza = System.nanoTime();

                TiempoPrimerHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 2

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(2);
            	System.out.println("Termina heurística  2 \n");

                
                finaliza = System.nanoTime();

                TiempoSegundaHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Mide algoritmo heuristica 3

                comienza = System.nanoTime();

                arbol.heuristicaBusqueda(3);
            	System.out.println("Termina heurística  3 \n");

                
                finaliza = System.nanoTime();

                TiempoTerceraHeuristica = (double) (finaliza - comienza) / 1000000000;

                // Imprime

                System.out.println("Anchura: " + TiempoPorAnchura);
                System.out.println("Profundidad: " + TiempoPorProfundidad);
                System.out.println("Heuristica 1: " + TiempoPrimerHeuristica);
                System.out.println("Heuristica 2: " + TiempoSegundaHeuristica);
                System.out.println("Heuristica 3: " + TiempoTerceraHeuristica);

            }
    
//        //Imprime movimientos
//        
//        /*
//        Nodo n = new Nodo(estadoInicial);
//        Collection<String> c = n.generaHijos();
//        c = c;
//        */
        
    }
        
    
    