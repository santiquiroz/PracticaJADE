/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actores;

/**
 *
 * @author santi
 */
public class Regadera {
    private boolean activado = false;
    public void activar(boolean v){
        if (v) {
            activado=true;
            System.out.println("La regadera se a activado.");
        }
        else if(activado){
            activado=false;
            System.out.println("La regadera se a desactivado.");
        }
    }
}
