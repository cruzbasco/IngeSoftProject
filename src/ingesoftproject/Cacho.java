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
    ArrayList<Integer> numerosCacho = new ArrayList<Integer>();

    Dado dado1 = new Dado();
    Dado dado2 = new Dado();
    Dado dado3 = new Dado();
    Dado dado4 = new Dado();
    Dado dado5 = new Dado();
    int puntaje = 0;
    int resultado;
    
    public Cacho() {
        cacho.add(dado1);
        cacho.add(dado2);
        cacho.add(dado3);
        cacho.add(dado4);
        cacho.add(dado5);
    }
    
    public int lanzarDados() {
        int suma = 0;
        for(Dado dado:cacho)
        {
            suma += dado.lanzar();
        }
        return suma;
    }

    public void cargarDadosCon(int d1, int d2, int d3, int d4, int d5) {
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        
        dado1.cargarDadoCon(d1);
        nuevoCacho.add(dado1);
        dado2.cargarDadoCon(d2);
        nuevoCacho.add(dado2);
        dado3.cargarDadoCon(d3);
        nuevoCacho.add(dado3);
        dado4.cargarDadoCon(d4);
        nuevoCacho.add(dado4);
        dado5.cargarDadoCon(d5);
        nuevoCacho.add(dado5);
        cacho = nuevoCacho;
    }
    
    public int leerDadoNumero(int d) {   
        dado1 = cacho.get(d);
        return dado1.lanzar();
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

    public void sumarPuntaje() {
        puntaje += calcularPuntaje();
    }
    
    public boolean verificarSiExisteGanador()
    {
        if (puntaje >= 3000)
            return true;
        else
            return false;
    }
    
    public int verificarPuntajeMinimo()
    {
        sumarPuntaje();
        if (puntaje < 300)
            puntaje = 0;
        return puntaje;
    }
    
    
    
}
