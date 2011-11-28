

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
    Cacho cacho;
    
    @Before
    public void inicializar() 
    {
        dado = new Dado();
        cacho = new Cacho();
    }
    
    @Test
    public void alLanzarUnDadoRetornaUnValorEntreUnoYSeis ()
    {
        int lanzamiento = dado.lanzar();
        assertTrue(valorDeUnDadoEstaEntreUnoYSeis(lanzamiento));
    }
    
    @Test
    public void laSumaDeLanzarDosVecesElMismoDadosRetornaUnValorEntreDosYDoce ()
    {   
        int lanzamiento1 = dado.lanzar();
        int lanzamiento2 = dado.lanzar();
        assertTrue(valorDeUnDadoEstaEntreUnoYSeis(lanzamiento1));
        assertTrue(valorDeUnDadoEstaEntreUnoYSeis(lanzamiento2));
        assertTrue(( (lanzamiento1 + lanzamiento2) >= 2 ) && ( (lanzamiento1 + lanzamiento2) <= 12 ));
    }
    
    //probando las reglas de los dados
    @Test 
    public void cargarElCachoConLosDadosQueYoQuiero()
    {
        cacho.cargarDadosCon(4,6,3,1,2);
        assertEquals(4, cacho.leerDadoNumero(0));
        assertEquals(6, cacho.leerDadoNumero(1));
        assertEquals(3, cacho.leerDadoNumero(2));
        assertEquals(1, cacho.leerDadoNumero(3));
        assertEquals(2, cacho.leerDadoNumero(4));
    }
    
    @Test
    public void siAlLanzarElCachoSalen3UnosVale1000Puntos()
    {
        cacho.cargarDadosCon(1, 1, 3, 4, 1);
        assertEquals(1000, cacho.calcularPuntaje());
    }
    
    @Test
    public void siAlLanzarElCachoSalen3SeisVale600Puntos()
    {
        cacho.cargarDadosCon(6, 2, 6, 6, 6);
        assertEquals(600, cacho.calcularPuntaje());
    }
    
    @Test
    public void siAlLanzarElCachoSalen3CincosVale500Puntos()
    {
        cacho.cargarDadosCon(6, 5, 6, 5, 5);
        assertEquals(500, cacho.calcularPuntaje());
    }
    
    @Test
    public void siAlLanzarElCachoSalen3CuatrosVale400Puntos()
    {
        cacho.cargarDadosCon(6, 4, 4, 2, 4);
        assertEquals(400, cacho.calcularPuntaje());
    }
    
    @Test
    public void siAlLanzarElCachoSalen3TresVale300Puntos()
    {
        cacho.cargarDadosCon(3, 4, 4, 3, 3);
        assertEquals(300, cacho.calcularPuntaje());
    }
    
    @Test
    public void siAlLanzarElCachoSalen3DosVale200Puntos()
    {
        cacho.cargarDadosCon(3, 2, 2, 2, 3);
        assertEquals(200, cacho.calcularPuntaje());
    }
    
    @Test
    public void porCadaDadoUnoQueSaqueSeSuma100Puntos()
    {
        cacho.cargarDadosCon(1, 3, 1, 1, 1);
        assertEquals(1100, cacho.calcularPuntaje());
        cacho.cargarDadosCon(1, 1, 1, 1, 1);
        assertEquals(1200, cacho.calcularPuntaje());
        cacho.cargarDadosCon(1, 6, 6, 2, 1);
        assertEquals(200, cacho.calcularPuntaje());
        cacho.cargarDadosCon(1, 6, 2, 3, 4);
        assertEquals(100, cacho.calcularPuntaje());        
    }
     
    @Test
    public void porCadaDadoCincoQueSaqueSeSuma50Puntos()
    {
        cacho.cargarDadosCon(5, 5, 5, 5, 5);
        assertEquals(600, cacho.calcularPuntaje());        
        cacho.cargarDadosCon(3, 5, 5, 5, 5);
        assertEquals(550, cacho.calcularPuntaje());        
        cacho.cargarDadosCon(2, 2, 3, 5, 5);
        assertEquals(100, cacho.calcularPuntaje());        
        cacho.cargarDadosCon(5, 2, 6, 3, 4);
        assertEquals(50, cacho.calcularPuntaje());        
    }
    
    @Test
    public void cuandoAcumulas3000oMasPuntosElJuegoTermina()
    {
        cacho.cargarDadosCon(1, 1, 1, 1, 1); //1200 puntos
        cacho.sumarPuntaje();
        assertFalse(cacho.verificarSiExisteGanador());
        cacho.cargarDadosCon(1, 1, 1, 1, 1); //2400 puntos
        cacho.sumarPuntaje();
        assertFalse(cacho.verificarSiExisteGanador());
        cacho.cargarDadosCon(2, 3, 6, 6, 6); //3000 puntos
        cacho.sumarPuntaje();
        assertTrue(cacho.verificarSiExisteGanador());
    }
    
    @Test
    public void siAlLanzarLosDadosNoAlcanzasUnMinimoDe300PuntosSeAnota0Puntos()
    {
        cacho.cargarDadosCon(2, 2, 2, 2, 5);
        assertEquals(0, cacho.verificarPuntajeMinimo());
    }
    
    @Test
    public void calcularLosDadosQueNoSumanPuntos()
    {
        cacho.cargarDadosCon(2, 2, 1, 6, 4);
        assertEquals(4, cacho.calcularDadosNoUtilizados());
        cacho.cargarDadosCon(1, 2, 3, 4, 5);
        assertEquals(3, cacho.calcularDadosNoUtilizados());
        cacho.cargarDadosCon(2, 2, 6, 6, 6);
        assertEquals(2, cacho.calcularDadosNoUtilizados());
        cacho.cargarDadosCon(2, 2, 3, 6, 4);
        assertEquals(5, cacho.calcularDadosNoUtilizados());
        cacho.cargarDadosCon(2, 2, 2, 1, 4);
        assertEquals(1, cacho.calcularDadosNoUtilizados());
        cacho.cargarDadosCon(2, 2, 2, 1, 1);
        assertEquals(0, cacho.calcularDadosNoUtilizados());
    }
    
    @Test
    public void verificarSiHayDadosQueNoSumaronPuntos()
    {
        cacho.cargarDadosCon(4, 4, 4, 2, 3);  //400 puntos
        assertTrue(cacho.verificarDadosNoUtilizados());
        cacho.cargarDadosCon(1, 1, 1, 1, 1);
        assertFalse(cacho.verificarDadosNoUtilizados());
    }
    
    @Test
    public void deberiaPoderCalcularLosDadosQueNoSumaronPuntos()
    {
        cacho.cargarDadosCon(4, 4, 4, 2, 3);  //400 puntos
        
        assertTrue(cacho.verificarDadosNoUtilizados());
        assertEquals(2, cacho.calcularDadosNoUtilizados());
    }
    
    
    
    //private methods
    private boolean valorDeCincoDadosEstaEntreCincoYTreinta (int lanzamiento)
    {
        return ((lanzamiento >= 5) && (lanzamiento <= 30));
    }
    
    private boolean valorDeUnDadoEstaEntreUnoYSeis(int lanzamiento)
    {
        return ((lanzamiento >= 1) && (lanzamiento <= 6));
    }
    
 
}
