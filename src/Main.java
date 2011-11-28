/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author cruzbasco
 */
public class Main {

    static Cacho cacho1;
    static Cacho cacho2;
    static int puntajeJugador1 = 0;    
    static int puntajeJugador2 = 0;
    static int opcionMenu;
    private static boolean primerTurno;
    public static void main(String[] args) {
        cacho1 = new Cacho();
        cacho2 = new Cacho();
        boolean turno = true; // true = cacho1, false = cacho2
        while (!cacho1.verificarSiExisteGanador() && !cacho2.verificarSiExisteGanador()){
            if(turno){
                turno = turnoJugador1(turno);
                    
            }else{
                turno = turnoJugador2(turno);
            }
        }
        if(turno){
            turno = turnoJugador1(turno);
                    
        }else{
            turno = turnoJugador2(turno);
        }
        
        if (puntajeJugador1 == puntajeJugador2){
            System.out.println("Partido empatado.. puntaje final: " + puntajeJugador2);
        }else{
            if (puntajeJugador1 < puntajeJugador2){
                System.out.println("Gano Jugador 2 con puntaje final: " + puntajeJugador2);
            }else{
                System.out.println("Gano Jugador 1 con puntaje final: " + puntajeJugador1);
            }
                
        }
        
        
    
    }

    private static boolean turnoJugador2(boolean turno) {
        System.out.println("Jugador 2");
        cacho2.lanzarDados(5);
        primerTurno = true;
        if (!cacho2.verificarPuntajeMinimoEnPrimerLanzamiento())
            cacho2.sumarPuntaje();
        System.out.println("Puntaje Total: " + puntajeJugador2);
        System.out.println(cacho2.mostrarCacho());
        do{    
            opcionMenu = menu();
            switch (opcionMenu){
                case 1:
                    if (!cacho2.verificarPuntajeMinimoEnPrimerLanzamiento() && primerTurno)
                    {
                        primerTurno = false;
                        if(cacho2.verificarDadosNoUtilizados()){
                            cacho2.lanzarDados();
                            System.out.println("Puntaje Total: " + puntajeJugador2);
                            System.out.println(cacho2.mostrarCacho());
                            if (!cacho2.verificarPuntajeEnLosSiguientesLanzamientos())
                            {
                                cacho2.sumarPuntaje();
                            }else{
                                System.out.println("No cumplio con la regla de 50 pts minimo durante el lanzamiento");
                                if(!cacho2.verificarDadosNoUtilizados())
                                    puntajeJugador2 = cacho2.devolverPuntaje();
                                cacho2 = new Cacho();
                                turno = true;
                            }
                        }else{
                            System.out.println("No tienes mas dados para lanzar");
                            puntajeJugador2 = cacho2.devolverPuntaje();
                            turno = true;
                        }
                    }else{
                        System.out.println("No Cumplio con la regla de 300 pts minimo en el primer lanzamiento");
                        if(!cacho2.verificarDadosNoUtilizados())
                            puntajeJugador2 = cacho2.devolverPuntaje();
                        cacho2 = new Cacho();
                        turno = true;
                    }
                    break;
                case 2:
                        turno = true;
                        puntajeJugador2 = cacho2.devolverPuntaje();
                    break;
            }
        }while (!turno);
        return turno;
    }

    private static boolean turnoJugador1(boolean turno) {
        System.out.println("Jugador 1");
        cacho1.lanzarDados(5);
        primerTurno = true;
        if (!cacho1.verificarPuntajeMinimoEnPrimerLanzamiento())
            cacho1.sumarPuntaje();
        System.out.println("Puntaje Total: " + puntajeJugador1);
        System.out.println(cacho1.mostrarCacho());
        do{    
            opcionMenu = menu();
            switch (opcionMenu){
                case 1:
                    if (!cacho1.verificarPuntajeMinimoEnPrimerLanzamiento() && primerTurno)
                    {
                        primerTurno = false;
                        if(cacho1.verificarDadosNoUtilizados()){
                            cacho1.lanzarDados();
                            System.out.println("Puntaje Total: " + puntajeJugador1);
                            System.out.println(cacho1.mostrarCacho());
                            if (!cacho1.verificarPuntajeEnLosSiguientesLanzamientos())
                            {
                                cacho1.sumarPuntaje();
                            }else{
                                System.out.println("No cumplio con la regla de 50 pts minimo durante el lanzamiento");
                                if(!cacho1.verificarDadosNoUtilizados())
                                    puntajeJugador1 = cacho1.devolverPuntaje();
                                cacho1 = new Cacho();
                                turno = false;
                            }
                        }else{
                            System.out.println("No tienes mas dados para lanzar");
                            puntajeJugador1 = cacho1.devolverPuntaje();
                            turno = false;
                        }
                    }else{
                        System.out.println("No Cumplio con la regla de 300 pts minimo en el primer lanzamiento");
                        if(!cacho1.verificarDadosNoUtilizados())
                            puntajeJugador1 = cacho1.devolverPuntaje();
                        cacho1 = new Cacho();
                        turno = false;
                    }
                    break;
                case 2:
                        turno = false;
                        puntajeJugador1 = cacho1.devolverPuntaje();
                    break;
            }
        }while (turno);
        return turno;
    }
    
    
    
    public static int  menu(){
        System.out.println("1. Volver a lanzar.");
        System.out.println("2. Anotar y pasar de turno.");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    
}
