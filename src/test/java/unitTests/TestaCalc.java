package unitTests;

import intro.Medidas;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestaCalc{
    @Test
    public void testarSomarDoisNumeros(){
    //1 - Prepara - Configurar - Given

        int num1 = 5;
        int num2 = 9;
        int resultadoEsperado = 14;

    //2 - Executar - When

        int resultadoAtual = Medidas.somarDoisNumerosCompacto(num1,num2);

    //3 - Validar - Then
        assertEquals(resultadoAtual, resultadoEsperado);

    }
}