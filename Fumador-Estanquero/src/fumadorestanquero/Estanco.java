/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fumadorestanquero;

import java.util.ArrayList;
import monitor.AbstractMonitor;
import monitor.Condition;
/**
 *
 * @author Chess
 */
public class Estanco extends AbstractMonitor{   
    private Condition condicionFumador[];
    private Condition condicionEstanquero;
    private boolean hayIngrediente = false;
    private int ingreV;
    private ArrayList<String> ingredientes;
    
    public Estanco() { 
        this.ingredientes = new ArrayList<String>();
        ingredientes.add("TABACO");
        ingredientes.add("PAPEL");
        ingredientes.add("CERILLAS");
        condicionFumador = new Condition[3];
        for(int i=0; i<3; i++)
            condicionFumador[i] = makeCondition();
        condicionEstanquero = makeCondition();
    }
    
    public void ponerIngrediente(int ingre) /*throws InterruptedException*/ {
        enter();
        while( hayIngrediente ) 
            condicionEstanquero.await();
        System.out.println("El estanquero ha colocado " + ingredientes.get(ingre) + " a un precio de escandalo.");
        hayIngrediente = true;
        this.ingreV = ingre;
        condicionFumador[ingre].signal();
        leave();
    }
    
    public void obtenerIngrediente( int ingre ) throws InterruptedException /*throws InterruptedException*/ { 
        enter();
        System.out.println("El fumador al que le falta " + ingredientes.get(ingre) + " está esperando para fumar.");
        while( !hayIngrediente || ingreV != ingre ) 
            condicionFumador[ingre].await();
        System.out.println("El fumador al que le faltaba " + ingredientes.get(ingre) + " está fumando.");
        Thread.sleep(2000);
        hayIngrediente = false;       
        condicionEstanquero.signal();
        leave();
    }
  

}
