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
public class Bodega {

    public final static int CAPACIDAD_MAXIMA = 200;
    public final static int PRIMER_TIPO = 1;
    public final static int SEGUNDO_TIPO = 2;
    public final static int VOL_UNO = 10;
    public final static int VOL_DOS = 15;

    private int capacidad;
    private int articulosTipoUno;
    private int articulosTipoDos;

    public Bodega() {
        capacidad = 0;
        articulosTipoUno = 0;
        articulosTipoDos = 0;
    }

    public void descargarArticulo(int tipo) {
        if (tipo == PRIMER_TIPO) {
            while (capacidad + VOL_UNO > CAPACIDAD_MAXIMA)
                ;
            capacidad += VOL_UNO;
            articulosTipoUno++;

        }

        if (tipo == SEGUNDO_TIPO) {
            while (capacidad + VOL_DOS > CAPACIDAD_MAXIMA) 
               ;

            capacidad += VOL_DOS;
            articulosTipoDos++;
        }
    }

    public void crearPaquete() {
        while(articulosTipoUno < 3 || articulosTipoDos < 4)
            ;
        
            articulosTipoUno -= 3;
            articulosTipoDos -= 4;
            capacidad -= (VOL_UNO * 3 + VOL_DOS * 4);
            System.out.println("Empacador crea un paquete");
        
    }
}
