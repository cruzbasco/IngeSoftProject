

import ingesoftproject.Cacho;
import ingesoftproject.Dado;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cruzbasco
 */
public class GameTest {
    Dado dado;
    
    @Before
    public void inicializar() {
        dado = new Dado();

    }
    
    @Test
    public void alLanzarUnDadoRetornaUnValorEntreUnoYSeis ()
    {
        int lanzamiento = dado.lanzar();
        assertTrue(valorEntreUnoYSeis(lanzamiento));
    }
    
    @Test
    public void laSumaDeLanzarDosVecesElMismoDadosRetornaUnValorEntreDosYDoce ()
    {   
        int lanzamiento1 = dado.lanzar();
        int lanzamiento2 = dado.lanzar();
        assertTrue(valorEntreUnoYSeis(lanzamiento1));
        assertTrue(valorEntreUnoYSeis(lanzamiento2));
        assertTrue(( (lanzamiento1 + lanzamiento2) >= 2 ) && ( (lanzamiento1 + lanzamiento2) <= 12 ));
    }
    
    // el cacho esta compuesto de 5 dados
    @Test
    public void laSumaDeLanzarElCachoRetornaUnValorEntreCincoYTreinta()
    {
        Cacho cacho = new Cacho();
        int lanzamiento = cacho.lanzarDados();
        assertTrue(valorEntreCincoYTreinta(lanzamiento));
    }
    
    private boolean valorEntreCincoYTreinta (int lanzamiento)
    {
        return ((lanzamiento >= 5) && (lanzamiento <= 30));
    }
    
    private boolean valorEntreUnoYSeis(int lanzamiento)
    {
        return ((lanzamiento >= 1) && (lanzamiento <= 6));
    }
    
 
}
