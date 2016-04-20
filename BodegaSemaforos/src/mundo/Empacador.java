/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author distribuidos
 */
public class Empacador extends Thread {

    private Bodega bodega;

    public Empacador(Bodega bodega) {
        this.bodega = bodega;
    }

    public void run() {
        Random aleatorio = new Random();
        while (true) {
            int tiempoEmpacando = aleatorio.nextInt(10);
            System.out.println("Empacador va a empacar en "
                    + tiempoEmpacando
                    + " segundos");
            
            try{
                sleep(tiempoEmpacando*1000);
                
            }catch(Exception e){}
            
            try {
                bodega.crearPaquete();
            } catch (InterruptedException ex) {
                Logger.getLogger(Empacador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
