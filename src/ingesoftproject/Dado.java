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
    private int numero = 0;
    Random random = new Random();
    public Dado() {
    }
    
    public Dado(int valorDado)
    {
        numero = valorDado;
    }

    public int lanzar() {
        if (numero == 0)
            numero = random.nextInt(6) + 1; 
        return numero;
    }
    
}
