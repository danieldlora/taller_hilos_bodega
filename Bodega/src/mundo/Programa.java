/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

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
        
         Bodega bodega = new Bodega();
         Descargador procesoDescargador = new Descargador(bodega);
         Empacador procesoEmpacador = new Empacador(bodega);
         
         procesoDescargador.start();
         procesoEmpacador.start();
    }
    
}
