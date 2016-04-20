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
public class Descargador extends Thread {

    Bodega bodega;

    public Descargador(Bodega bodega) {
        this.bodega = bodega;
    }

    public void run() {
        Random aleatorio = new Random();
        Random itemAleatorio = new Random();
        int tipo = 0;
        while (true) {
            int tiempoDescarga = aleatorio.nextInt(10);
            tipo = itemAleatorio.nextInt(2) + 1;
            System.out.println("Tiempo Descargando articulo de tipo" + "-" + tipo + "- En "  + tiempoDescarga + " Segundos");
            try {
                sleep(tiempoDescarga * 1000);
            } catch (Exception e) {
            }

            System.out.println("Se trae un nuevo articulo de tipo " + tipo);
            try {
                bodega.descargarArticulo(tipo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Descargador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
