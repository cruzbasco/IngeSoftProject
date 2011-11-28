

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

    int cantidadDados = 5;
    int puntaje = 0;
    
    Regla regla;
    
    public Cacho() {
        for (int i = 0; i < cantidadDados; i++) {
            cacho.add(new Dado());
        }
    }
    
    
    
    public void lanzarDados() {
        cantidadDados = regla.calcularDadosNoUtilizados();
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        for (int i = 0; i < cantidadDados; i++) {
            nuevoCacho.add(new Dado());
        }
        cacho.clear();
        cacho = nuevoCacho; 
        regla = new Regla(cacho);
    }
    
    public void lanzarDados (int numero)
    {
        regla = new Regla(cacho);
        cantidadDados = numero;
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        for (int i = 0; i < cantidadDados; i++) {
            nuevoCacho.add(new Dado());
        }
        cacho.clear();
        cacho = nuevoCacho;  
        regla = new Regla(cacho);
    }
    
    

    public void cargarDadosCon(int d1, int d2, int d3, int d4, int d5) {
        ArrayList<Dado> nuevoCacho = new ArrayList<Dado>();
        
        nuevoCacho.add(new Dado(d1));
        nuevoCacho.add(new Dado(d2));
        nuevoCacho.add(new Dado(d3));
        nuevoCacho.add(new Dado(d4));
        nuevoCacho.add(new Dado(d5));
        cacho = nuevoCacho;
        regla = new Regla(cacho);
    }
    
    public int leerDadoNumero(int d) {   
        return cacho.get(d).lanzar();
    }
    
    public int calcularPuntaje()
    {
        return regla.calcularPuntaje();
    }

    public void sumarPuntaje() {
        puntaje += regla.calcularPuntaje();
    }
    
    public String mostrarCacho()
    {
        String resp = "Puntaje inicial: " 
                    + puntaje
                    + "\nDados: ";
        for (int i = 0; i < cantidadDados; i++) {
            resp += leerDadoNumero(i) + " ";
        }   
        resp += " Puntaje parcial: " + calcularPuntaje();
        return resp;
    }
    
    public boolean verificarSiExisteGanador()
    {
        if (puntaje >= 3000)
            return true;
        else
            return false;
    }
    
    public int calcularDadosNoUtilizados()
    {
        cantidadDados = regla.calcularDadosNoUtilizados();
        return cantidadDados;
    }
    
    public boolean verificarDadosNoUtilizados()
    {
        if (regla.calcularDadosNoUtilizados() == 0)
            return false;
        return true;
    }
    
    public ArrayList<Dado> devolverCacho()
    {
        return cacho;
    }
    
    public int devolverPuntaje()
    {
        return puntaje;
    }
    
    public boolean verificarPuntajeMinimoEnPrimerLanzamiento()
    {
        return regla.verificarPuntajeMinimoEnPrimerLanzamiento();
    }
    
    public boolean verificarPuntajeEnLosSiguientesLanzamientos()
    {
        return regla.verificarPuntajeEnLosSiguientesLanzamientos();
    }
    
    public int verificarSiTodosLosDadosSonIguales()
    {
        return regla.verificarSiTodosLosDadosSonIguales();
    }

}
