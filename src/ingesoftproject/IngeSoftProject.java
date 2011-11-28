/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingesoftproject;

import java.util.Scanner;

/**
 *
 * @author cruzbasco
 */
public class IngeSoftProject {

    static Cacho cacho1;
    static Cacho cacho2;
    static int opcionMenu;
    public static void main(String[] args) {
        cacho1 = new Cacho();
        cacho2 = new Cacho();
        boolean turno = true; // true = cacho1, false = cacho2
        while (!cacho1.verificarSiExisteGanador() && !cacho2.verificarSiExisteGanador()){
            if(turno){
                System.out.println("Jugador 1");
                cacho1.lanzarDados();
                cacho1.sumarPuntaje();
                System.out.println(cacho1.mostrarCacho());
                do{    
                    opcionMenu = menu();
                    switch (opcionMenu){
                        case 1:
                            if(cacho1.verificarDadosNoUtilizados()){
                                cacho1.lanzarDados();
                                cacho1.sumarPuntaje();
                                System.out.println(cacho1.mostrarCacho());
                            }else{
                                System.out.println("No tienes mas dados para lanzar");
                                turno = false;
                            }
                            break;
                        case 2:
                                turno = false;
                            break;
                    }
                }while (turno);
                    
            }else{
                System.out.println("Jugador 2");
                cacho2.lanzarDados();
                cacho2.sumarPuntaje();
                System.out.println(cacho2.mostrarCacho());
                do{
                    switch (menu()){
                        case 1:
                            if(cacho2.verificarDadosNoUtilizados()){
                                cacho2.lanzarDados();
                                cacho2.sumarPuntaje();
                                System.out.println(cacho2.mostrarCacho());
                            }else{
                                System.out.println("No tienes mas dados para lanzar");
                                turno = true;
                            }
                            break;
                        case 2:
                                turno = true;
                            break;
                    }
                }while (!turno);

            }
                
            
        }
        
    }
    
    
    
    public static int  menu(){
        System.out.println("1. Volver a lanzar.");
        System.out.println("2. Anotar y pasar de turno.");
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }
    
}
