/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author distribuidos
 */
public class Bodega {

    public final static int CAPACIDAD_MAXIMA = 200;
    public final static int PRIMER_TIPO = 1;
    public final static int SEGUNDO_TIPO = 2;
    public final static int VOL_UNO = 10;
    public final static int VOL_DOS = 15;

    private int articulosTipoUno;
    private int articulosTipoDos;
    
    private Semaphore mutex;
    private Semaphore cantidadMaxima;
    private Semaphore cArtiUnos;
    private Semaphore cArtiDos;
    
    public Bodega() throws InterruptedException {
        articulosTipoUno = 0;
        articulosTipoDos = 0;
        mutex = new Semaphore(1);
        cArtiUnos = new Semaphore(3);
        cArtiDos = new Semaphore(4);
        cantidadMaxima=new Semaphore(CAPACIDAD_MAXIMA);
        cArtiUnos.acquire(3);
        cArtiDos.acquire(4);
    }

    public void descargarArticulo(int tipo) throws InterruptedException {
        if (tipo == PRIMER_TIPO) {
            cantidadMaxima.acquire(VOL_UNO);
            mutex.acquire();
            cArtiUnos.release();
            articulosTipoUno++;
        }

        if (tipo == SEGUNDO_TIPO) {
            cantidadMaxima.acquire(VOL_DOS);
            mutex.acquire();
            cArtiDos.release();
            articulosTipoDos++;
        }
        System.out.println("Paquetes: tipo 1 # " + articulosTipoUno + " tipo 2 # " + articulosTipoDos);
        mutex.release();
    }

    public void crearPaquete() throws InterruptedException {
        cArtiUnos.acquire(3);
        cArtiDos.acquire(4);
        mutex.acquire();
           articulosTipoUno-=3;
           articulosTipoDos-=4;
            cantidadMaxima.release(VOL_UNO*3 + VOL_DOS*4);
            mutex.release();
            System.out.println("Empacador crea un paquete");
             System.out.println("Paquetes: tipo 1 # " + articulosTipoUno + " tipo 2 # " + articulosTipoDos);
        
    }
}
