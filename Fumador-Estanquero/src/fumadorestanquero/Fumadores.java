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
public class Fumadores implements Runnable{
    Estanco estanco;
    int ingrediente;
    Thread thr;
    
    public Fumadores( Estanco p_estanco, int p_ingrediente ) { 
        estanco = p_estanco;
        ingrediente = p_ingrediente;
        thr = new Thread(this,"Fumador " + ingrediente);
    }
  
    public void run() { 
        try { 
            while(true){
                estanco.obtenerIngrediente(ingrediente);
            }
        }
        catch( Exception e ) { 
            System.err.println("Excepcion en main: " + e);
        }
    }
}
