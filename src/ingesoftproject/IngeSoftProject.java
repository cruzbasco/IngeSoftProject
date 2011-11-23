/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingesoftproject;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cruzbasco
 */
public class IngeSoftProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cacho cacho1 = new Cacho();
        Cacho cacho2 = new Cacho();
        
        
        
    }
    
    public int menu() throws IOException{
        System.out.println("1. Volver a lanzar.");
        System.out.println("2. Anotar y pasar de turno.");
        int opcion = (int)System.in.read();
        return opcion;
    }
    
}
