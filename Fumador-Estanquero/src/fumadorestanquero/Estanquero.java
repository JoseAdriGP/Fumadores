/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fumadorestanquero;
/**
 *
 * @author Chess
 */
public class Estanquero implements Runnable{
    Estanco estanco;
    Thread thr;
    
    public Estanquero( Estanco p_estanco ) { 
        estanco = p_estanco;
        thr   = new Thread((Runnable) this,"Estanquero" );
    }
  
    public void run() { 
        try{  
            while(true){
                int ingrediente = (int) Math.floor(Math.random()*3) ;
                estanco.ponerIngrediente(ingrediente);
            }
        }
        catch( Exception e ) {
            System.err.println("Excepcion en main: " + e);
        }
    }
}
