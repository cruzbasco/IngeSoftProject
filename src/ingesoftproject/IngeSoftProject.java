/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ingesoftproject;

/**
 *
 * @author cruzbasco
 */
public class IngeSoftProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cacho cacho = new Cacho();
        System.out.println(cacho.lanzarDados());
        System.out.println(cacho.leerDadoNumero(0));
        System.out.println(cacho.leerDadoNumero(1));
        System.out.println(cacho.leerDadoNumero(2));
        System.out.println(cacho.leerDadoNumero(3));
        System.out.println(cacho.leerDadoNumero(4));

    }
}
