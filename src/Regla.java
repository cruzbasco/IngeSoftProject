/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author cruzbasco
 */
public class Regla {
    
    private final ArrayList<Dado> cacho;
    static List<Integer> numerosCacho = Arrays.asList(2,3,4,6);
    boolean resp;
    int resultado;

    public Regla(ArrayList<Dado> nuevoCacho) {
        cacho = nuevoCacho;
    }

    public Regla() {
        cacho = new ArrayList<Dado>();
    }
    

    public int calcularPuntaje() {
        resultado = 0;
        resultado = reglasDeTrica()
                  + reglasIndividuales();
        return resultado;
    }

    private int contarRepeticionesDe(int valorDado) {
        int cont = 0;
        for (Dado dado : cacho) {
            if (dado.lanzar() == valorDado) {
               cont++;
            }
        }
        return cont;
    }

    private int reglasDeTrica() {
        return   reglaDeUnos()
               + reglaDeSeis()
               + reglaDeCincos()
               + reglaDeCuatros()
               + reglaDeTres()
               + reglaDeDos();
    }

    private int reglaDeUnos() {
        if (contarRepeticionesDe(1) >= 3)
            return 1000;        
        return 0;
    }

    private int reglaDeSeis() {
        if (contarRepeticionesDe(6) >= 3)
            return 600;        
        return 0; 
    }

    private int reglaDeCincos() {
        if (contarRepeticionesDe(5) >= 3)
            return 500;        
        return 0; 
    }

    private int reglaDeCuatros() {
        if (contarRepeticionesDe(4) >= 3)
            return 400;        
        return 0;
    }

    private int reglaDeTres() {
        if (contarRepeticionesDe(3) >= 3)
            return 300;        
        return 0;
    }

    private int reglaDeDos() {
        if (contarRepeticionesDe(2) >= 3)
            return 200;        
        return 0;
    }

    private int reglasIndividuales() {
        return   reglaIndividualDeUnos()
               + reglaIndividualDeCincos();
    }

    private int reglaIndividualDeUnos() {
        resultado = 0;
        if (contarRepeticionesDe(1) >= 3)
            resultado = (100 * (contarRepeticionesDe(1) - 3));
        else
            resultado = 100 * contarRepeticionesDe(1);
        return resultado;
    }

    private int reglaIndividualDeCincos() {
        resultado = 0;
        if (contarRepeticionesDe(5) >= 3)
            resultado = (50 * (contarRepeticionesDe(5) - 3));
        else
            resultado = 50 * contarRepeticionesDe(5);
        return resultado;
    }
    

    
    public int calcularDadosNoUtilizados()
    {
        int cont =0;
        int repeticiones;
        for (Integer numero : numerosCacho) {
            repeticiones = contarRepeticionesDe(numero);
            if (repeticiones >= 3)
                cont += repeticiones - 3;
            else
                cont += repeticiones;
        }
        
        return cont;
    }
    
    public boolean verificarPuntajeMinimoEnPrimerLanzamiento()
    {
        resp = false;
        resultado = calcularPuntaje();
        if (resultado < 300)
            resp = true;
        return resp;
    }
    
    public boolean verificarPuntajeEnLosSiguientesLanzamientos()
    {
        resultado = calcularPuntaje();
        if (resultado < 50)
            resp = true;
        return resp;
    }
    
    public int verificarSiTodosLosDadosSonIguales()
    {
        resultado =0;
        int repeticiones;
        for (int numero = 1; numero <= 6; numero++) {
            repeticiones = contarRepeticionesDe(numero);
            if (repeticiones == 5)
                resultado = numero;
        }
        return resultado;
    }
}
