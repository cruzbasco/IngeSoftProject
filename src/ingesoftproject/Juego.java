/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingesoftproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author MauricioValdez
 */
public class Juego {
    
    static Cacho cacho1;
    static Cacho cacho2;
    static int opcionMenu;
    static Reglas reglas = new Reglas();
    static List<Integer> numerosCacho = Arrays.asList(2,3,4,6);
    
    public boolean verificarSiExisteGanador(int puntaje)
    {
        if (puntaje >= 3000)
            return true;
        else
            return false;
    }
    
    public boolean verificarPuntajeMinimoParaElPrimerLanzamiento(ArrayList<Dado> cacho)
    {
        int resultadoParcial = calcularPuntaje(cacho);
        if(resultadoParcial>=300)
            return true;
        else return false;
    }
    
    public int calcularPuntaje(ArrayList<Dado> cacho) {
        int resultado = 0;
        resultado = reglas.reglasDeTrica(cacho)
                  + reglas.reglasIndividuales(cacho);
        return resultado;
    }

    public int sumarPuntaje(int puntaje, int resultadoParcial) {
        puntaje += resultadoParcial;
        return puntaje;
    }
    
    public int calcularDadosNoUtilizados(ArrayList<Dado> cacho)
    {
        int cont =0;
        int repeticiones;
        for (Integer numero : numerosCacho) {
            repeticiones = reglas.contarRepeticionesDe(numero,cacho);
            if (repeticiones < 3)
                cont += repeticiones;
        }
        
        return cont;
    }  
    
    public boolean verificarDadosNoUtilizados(ArrayList<Dado> cacho)
    {
        if (calcularDadosNoUtilizados(cacho) == 0)
            return false;
        return true;
    }
    
    private boolean verificarSiSacoPuntaje(ArrayList<Dado> cacho) {
        int resultadoParcial = calcularPuntaje(cacho);
        if(resultadoParcial==0)
            return false;
        else return true;
    }
    
    
    public void jugar3000() {
        cacho1 = new Cacho();
        cacho2 = new Cacho();
        boolean turno = true; // true = cacho1, false = cacho2
        int resultadoTurno1 =0;
        int resultadoTurno2 =0;
        int resultadoParcial1 =0;
        int resultadoParcial2 =0;
        
        while (!verificarSiExisteGanador(cacho1.getPuntaje()) && !verificarSiExisteGanador(cacho2.getPuntaje()))
        {
            resultadoTurno1=0;
            resultadoTurno2=0;
            resultadoParcial1 =0;
            resultadoParcial2 =0;
            if(turno)
            {
                System.out.println("Jugador 1");
                cacho1.lanzarDados(5);
                if(verificarPuntajeMinimoParaElPrimerLanzamiento(cacho1.getCacho()))
                {
                    resultadoTurno1+=sumarPuntaje(cacho1.getPuntaje(),calcularPuntaje(cacho1.getCacho()));
                    resultadoParcial1+=calcularPuntaje(cacho1.getCacho());
                }
                else
                {
                    resultadoTurno1=sumarPuntaje(cacho1.getPuntaje(),0);
                    turno = false;
                }
                System.out.println(cacho1.mostrarCacho());
                System.out.println("Puntaje parcial del turno: "+resultadoParcial1);
                while (turno)
                {    
                    opcionMenu = menu();
                    switch (opcionMenu)
                    {
                        case 1:
                            if(verificarDadosNoUtilizados(cacho1.getCacho()))
                            {
                                cacho1.lanzarDados(calcularDadosNoUtilizados(cacho1.getCacho()));
                                if(verificarSiSacoPuntaje(cacho1.getCacho()))
                                {
                                    resultadoTurno1+=sumarPuntaje(cacho1.getPuntaje(),calcularPuntaje(cacho1.getCacho()));
                                    resultadoParcial1+=calcularPuntaje(cacho1.getCacho());
                                }
                                else
                                {
                                    resultadoTurno1=0;
                                    turno=false;
                                }
                                System.out.println(cacho1.mostrarCacho());
                                System.out.println("Puntaje parcial del turno: "+resultadoParcial1);
                            }else
                            {
                                System.out.println("No tienes mas dados para lanzar");
                                turno = false;
                            }
                            break;
                        case 2:
                                turno = false;
                            break;
                    }
                }
                cacho1.setPuntaje(resultadoTurno1);
                    
            }else
            {
                System.out.println("Jugador 2");
                cacho2.lanzarDados(5);
                if(verificarPuntajeMinimoParaElPrimerLanzamiento(cacho2.getCacho()))
                {
                    resultadoTurno2+=sumarPuntaje(cacho2.getPuntaje(),calcularPuntaje(cacho2.getCacho()));
                    resultadoParcial2+=calcularPuntaje(cacho2.getCacho());
                }
                else
                {
                    resultadoTurno2=sumarPuntaje(cacho2.getPuntaje(),0);
                    turno=true;
                }
                System.out.println(cacho2.mostrarCacho());
                System.out.println("Puntaje parcial del turno: "+resultadoParcial2);
                while (!turno)
                {
                    switch (menu())
                    {
                        case 1:
                            if(verificarDadosNoUtilizados(cacho2.getCacho()))
                            {
                                cacho2.lanzarDados(calcularDadosNoUtilizados(cacho2.getCacho()));
                                if(verificarSiSacoPuntaje(cacho2.getCacho()))
                                {
                                    resultadoTurno2+=sumarPuntaje(cacho2.getPuntaje(),calcularPuntaje(cacho2.getCacho()));
                                    resultadoParcial2+=calcularPuntaje(cacho2.getCacho());
                                }
                                else
                                {
                                    resultadoTurno2=0;
                                    turno=true;
                                }
                                System.out.println(cacho2.mostrarCacho());
                                System.out.println("Puntaje parcial del turno: "+resultadoParcial2);
                                
                            }else
                            {
                                System.out.println("No tienes mas dados para lanzar");
                                turno = true;
                            }
                            break;
                        case 2:
                                turno = true;
                            break;
                    }
                }
                cacho2.setPuntaje(resultadoTurno2);
            }          
        }
    }
    
    public static int menu(){
        System.out.println("1. Volver a lanzar.");
        System.out.println("2. Anotar y pasar de turno.");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
}
