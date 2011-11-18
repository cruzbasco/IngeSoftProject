package ingesoftproject;

import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cruzbasco
 */
public class Dado {

    Random numero = new Random();
    public Dado() {
    }

    public int lanzar() {
        return numero.nextInt(5)+1;
    }
    
}
