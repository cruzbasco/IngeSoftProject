package ingesoftproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    static List<Integer> numerosCacho = Arrays.asList(2,3,4,6);

    int cantidadDados = 5;
    int puntaje = 0;
    int resultado;
    
    public Cacho() {
        for (int i = 0; i < cantidadDados; i++) {
            cacho.add(new Dado());
        }
    }
    
    
    
    public void lanzarDados() {
        cantidadDados = calcularDadosNoUtilizados();
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        for (int i = 0; i < cantidadDados; i++) {
            nuevoCacho.add(new Dado());
        }
        cacho.clear();
        cacho = nuevoCacho;    

    }
    
    public void lanzarDados (int numero)
    {
        cantidadDados = numero;
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        for (int i = 0; i < cantidadDados; i++) {
            nuevoCacho.add(new Dado());
        }
        cacho.clear();
        cacho = nuevoCacho;    

    }

    public void cargarDadosCon(int d1, int d2, int d3, int d4, int d5) {
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        
        nuevoCacho.add(new Dado(d1));
        nuevoCacho.add(new Dado(d2));
        nuevoCacho.add(new Dado(d3));
        nuevoCacho.add(new Dado(d4));
        nuevoCacho.add(new Dado(d5));
        cacho = nuevoCacho;
    }
    
    public int leerDadoNumero(int d) {   
        return cacho.get(d).lanzar();
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
    
    public int calcularDadosNoUtilizados()
    {
        int cont =0;
        int repeticiones;
        for (Integer numero : numerosCacho) {
            repeticiones = contarRepeticionesDe(numero);
            if (repeticiones < 3)
                cont += repeticiones;
        }
        
        return cont;
    }
    
    
    public boolean verificarDadosNoUtilizados()
    {
        if (calcularDadosNoUtilizados() == 0)
            return false;
        return true;
    }
            
    public int devolverPuntaje()
    {
        return puntaje;
    }
    
    public String mostrarCacho()
    {
        String resp =  "Dados: ";
        for (int i = 0; i < cantidadDados; i++) {
            resp += leerDadoNumero(i) + " ";
        }   
        resp += " Puntaje: " + devolverPuntaje();
        return resp;
    }
}
