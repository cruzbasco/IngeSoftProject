package ingesoftproject;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cruzbasco
 */
public class Cacho {

    ArrayList<Dado> cacho = new ArrayList<Dado>();
    
    public Cacho()
    {
        Dado dado = new Dado();
        cacho.add(dado);
        cacho.add(dado);
        cacho.add(dado);
        cacho.add(dado);
        cacho.add(dado);
    }
    
    public int lanzarDados() {
        int suma = 0;
        for(Dado dado:cacho)
        {
            suma += dado.lanzar();
        }
        return suma;
    }
    
}
