package AireAcondicionado;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.sourceforge.jFuzzyLogic.FIS;

public class AireAcondicionado {
	
	static double temperatura = 25, potencia, randomValue;
	private String fileName = "C:\\Users\\David Abitia\\Documents\\Programacion eclipse\\LogicaDifusa\\src\\AireAcondicionado\\AireAcondicionado.fcl";
	private Random r;

	    public static void main(String[] args) {
	    	new AireAcondicionado();
	    }
	    
	    public AireAcondicionado() {
	    	
	    	r = new Random();
	        Timer timer = new Timer();
	        System.out.println("Controlador de temperatura: ");
	        System.out.println();
	        
		    TimerTask task = new TimerTask() {
		    	
		      public void run() {
			       FIS fis = FIS.load(fileName, true);

			       randomValue = -0.3 + (0.3 - -0.3) * r.nextDouble();
			       temperatura += randomValue;
			       
			       // 15° - 35°
			       fis.setVariable("temperatura", temperatura);
			        
			       fis.evaluate();
			       
			       // 0% - 100%
			       potencia = ((fis.getVariable("potencia").getLatestDefuzzifiedValue() - 16.7)*1.5);
			        
			       System.out.printf("La temperatura ambiente es de %.2f", temperatura);
			       System.out.printf("°, la potencia del aire\nacondicionado esta en %.2f", potencia);
			       System.out.println("% de su capacidad\n");
		      }
		    };
		    
		    timer.schedule(task, 0, 5000);
	   }
}


