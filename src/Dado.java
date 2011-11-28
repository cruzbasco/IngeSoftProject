

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
    private int numero;
    Random random = new Random();
    public Dado() {
        numero = random.nextInt(6) + 1;
    }
    
    public Dado(int valorDado)
    {
        numero = valorDado;
    }

    public int lanzar() {
        return numero;
    }
    
}
