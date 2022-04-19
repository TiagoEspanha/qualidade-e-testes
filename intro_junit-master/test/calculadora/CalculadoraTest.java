package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	// soma
	@DisplayName("Testa a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int res = calc.soma(4, 5);		
		Assertions.assertEquals(9, res);	
	}

	@DisplayName("Testa a soma de dois n�meros negativos")
	@Test 
	public void testSomaDoisNumerosNegativos() {
		int res = calc.soma(-4, -5);
		Assertions.assertEquals(-9, res);
	}

	@DisplayName("Testa a soma de um numero negativo com um positivo")
	@Test 
	public void testSomaUmNumeroNegativoComUmPositivo() {
		int res = calc.soma(-4, 5);
		Assertions.assertEquals(1, res);
	}

	@DisplayName("Testa a soma de um numero positivo com um negativo")
	@Test 
	public void testSomaUmNumeroPositivoComUmNegativo() {
		int res = calc.soma(4, -5);
		Assertions.assertEquals(-1, res);
	}

	// subtracao

	@DisplayName("Testa a subtração de dois n�meros")
	@Test
	public void testSubtracaoDoisNumeros() {
		int res = calc.subtracao(4, 5);		
		Assertions.assertEquals(-1, res);		
	}

	@DisplayName("Testa a subtração de dois n�meros negativos")
	@Test 
	public void testSubtracaoDoisNumerosNegativos() {
		int res = calc.subtracao(-4, -5);
		Assertions.assertEquals(1, res);
	}

	@DisplayName("Testa a subtração de um numero negativo com um positivo")
	@Test 
	public void testSubtracaoUmNumeroNegativoComUmPositivo() {
		int res = calc.subtracao(-4, 5);
		Assertions.assertEquals(-9, res);
	}

	@DisplayName("Testa a subtração de um numero positivo com um negativo")
	@Test 
	public void testSubtracaoUmNumeroPositivoComUmNegativo() {
		int res = calc.subtracao(4, -5);
		Assertions.assertEquals(9, res);
	}

	// divisao
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}

	@DisplayName("Testa a divisao de dois n�meros negativos")
	@Test 
	public void testDivisaoDoisNumerosNegativos() {
		int res = calc.divisao(-40, -5);
		Assertions.assertEquals(8, res);
	}

	@DisplayName("Testa a divisao de um numero negativo com um positivo")
	@Test 
	public void testDivisaoUmNumeroNegativoComUmPositivo() {
		int res = calc.divisao(-40, 5);
		Assertions.assertEquals(-8, res);
	}

	@DisplayName("Testa a divisao de um numero positivo com um negativo")
	@Test 
	public void testDivisaoUmNumeroPositivoComUmNegativo() {
		int res = calc.divisao(40, -5);
		Assertions.assertEquals(-8, res);
	}
	
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}

	// multiplicação
	@DisplayName("Testa a multiplicação de dois n�meros positivos")
	@Test
	public void testMultiplicacaoDoisNumeros() {
		int res = calc.multiplicacao(8, 5);
		Assertions.assertEquals(40, res);
	}

	@DisplayName("Testa a multiplicação de dois n�meros negativos")
	@Test 
	public void testMultiplicacaoDoisNumerosNegativos() {
		int res = calc.multiplicacao(-8, -5);
		Assertions.assertEquals(40, res);
	}

	@DisplayName("Testa a multiplicação de um numero negativo com um positivo")
	@Test 
	public void testMultiplicacaoUmNumeroNegativoComUmPositivo() {
		int res = calc.multiplicacao(-8, 5);
		Assertions.assertEquals(-40, res);
	}

	@DisplayName("Testa a multiplicação de um numero positivo com um negativo")
	@Test 
	public void testMultiplicacaoUmNumeroPositivoComUmNegativo() {
		int res = calc.multiplicacao(8, -5);
		Assertions.assertEquals(-40, res);
	}

	// somatorio

	@DisplayName("Testa a somatoria de um numero positivo")
	@Test 
	public void testSomatorioUmNumeroPositivo() {
		int res = calc.somatoria(8);
		Assertions.assertEquals(36, res);
	}

	@DisplayName("Testa a somatoria de um numero negativo")
	@Test 
	public void testSomatorioUmNumeroNegativo() {
		int res = calc.somatoria(-8);
		Assertions.assertEquals(0, res);
	}

	// ehPositivo

	@DisplayName("Testa se numero é positivo de um numero positvo")
	@Test 
	public void testEhPositivoDeNumeroPositivo() {
		boolean res = calc.ehPositivo(8);
		Assertions.assertEquals(true, res);
	}

	@DisplayName("Testa se numero é positivo de um numero negativo")
	@Test 
	public void testEhPositivoDeNumeroNegativo() {
		boolean res = calc.ehPositivo(-8);
		Assertions.assertEquals(false, res);
	}

	@DisplayName("Testa se numero é positivo de zero")
	@Test 
	public void testEhPositivoDeZero() {
		boolean res = calc.ehPositivo(0);
		Assertions.assertEquals(true, res);
	}

	// compara

	@DisplayName("Compara dois numeros iguais")
	@Test 
	public void testComparaDoisIguais() {
		int res = calc.compara(8,8);
		Assertions.assertEquals(0, res);
	}

	@DisplayName("Compara com um numero maior")
	@Test 
	public void testComparaPrimeiroMenor() {
		int res = calc.compara(1,8);
		Assertions.assertEquals(-1, res);
	}

	@DisplayName("Compara com um numero menor")
	@Test 
	public void testComparaPrimeiroMaior() {
		int res = calc.compara(8,1);
		Assertions.assertEquals(1, res);
	}

}
