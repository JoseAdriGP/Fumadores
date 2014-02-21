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
public class FumadorEstanquero {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // leer parametros, crear vectores y buffer intermedio
        Estanco estanco = new Estanco();
        Fumadores[] fumador = new Fumadores[3];
           
    // crear hebras
        Estanquero estanquero = new Estanquero(estanco);
        for(int i = 0; i < fumador.length; i++) 
            fumador[i] = new Fumadores(estanco,i) ;
    // poner en marcha las hebras
        for(int i = 0; i < fumador.length; i++) 
            fumador[i].thr.start();
        estanquero.thr.start();
    }
}


