package br.com.lab;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CalculadoraTest {
    @Test public void deveSomarDoisNumeros() { assertEquals(5, new Calculadora().somar(2, 3)); }
}
