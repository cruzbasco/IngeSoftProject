/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingesoftproject;

import java.util.ArrayList;

/**
 *
 * @author MauricioValdez
 */
public class Reglas {
    
    public int reglasDeTrica(ArrayList<Dado> cacho) {
        return   reglaDeUnos(cacho)
               + reglaDeSeis(cacho)
               + reglaDeCincos(cacho)
               + reglaDeCuatros(cacho)
               + reglaDeTres(cacho)
               + reglaDeDos(cacho);
    }
    
    public int reglasIndividuales(ArrayList<Dado> cacho) {
        return   reglaIndividualDeUnos(cacho)
               + reglaIndividualDeCincos(cacho);
    }

    private int reglaDeUnos(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(1,cacho) >= 3)
            return 1000;        
        return 0;
    }

    private int reglaDeSeis(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(6,cacho) >= 3)
            return 600;        
        return 0; 
    }

    private int reglaDeCincos(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(5,cacho) >= 3)
            return 500;        
        return 0; 
    }

    private int reglaDeCuatros(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(4,cacho) >= 3)
            return 400;        
        return 0;
    }

    private int reglaDeTres(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(3,cacho) >= 3)
            return 300;        
        return 0;
    }

    private int reglaDeDos(ArrayList<Dado> cacho) {
        if (contarRepeticionesDe(2,cacho) >= 3)
            return 200;        
        return 0;
    }
    
    public int contarRepeticionesDe(int valorDado, ArrayList<Dado> cacho) {
        int cont = 0;
        for (Dado dado : cacho) {
            if (dado.lanzar() == valorDado) {
               cont++;
            }
        }
        return cont;
    }

    private int reglaIndividualDeUnos(ArrayList<Dado> cacho) {
        int resultado = 0;
        if (contarRepeticionesDe(1,cacho) >= 3)
            resultado = (100 * (contarRepeticionesDe(1,cacho) - 3));
        else
            resultado = 100 * contarRepeticionesDe(1,cacho);
        return resultado;
    }

    private int reglaIndividualDeCincos(ArrayList<Dado> cacho) {
        int resultado = 0;
        if (contarRepeticionesDe(5,cacho) >= 3)
            resultado = (50 * (contarRepeticionesDe(5,cacho) - 3));
        else
            resultado = 50 * contarRepeticionesDe(5,cacho);
        return resultado;
    }
    
}
