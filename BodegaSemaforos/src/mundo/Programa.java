/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author distribuidos
 */
public class Programa {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Bodega bodega = null;
        try {
            bodega = new Bodega();
        } catch (InterruptedException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
         Descargador procesoDescargador = new Descargador(bodega);
         Empacador procesoEmpacador = new Empacador(bodega);
         
         procesoDescargador.start();
         procesoEmpacador.start();
    }
    
}
