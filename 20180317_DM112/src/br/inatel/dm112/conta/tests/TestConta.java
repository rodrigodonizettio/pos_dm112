package br.inatel.dm112.conta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.inatel.dm112.conta.ContaCorrente;
import br.inatel.dm112.conta.SaldoInsuficienteException;

class TestConta {

	@Test
	void testTransferirPara() {
		
		ContaCorrente cc1 = new ContaCorrente(1, "cliente-1", 15);
		assertEquals(0, cc1.getSaldo(), 0.001);
		
		///
		
		cc1.depositar(100);
		assertEquals(100, cc1.getSaldo(), 0.001);
		
		ContaCorrente cc2 = new ContaCorrente(2, "cliente-2", 15);
		assertEquals(0, cc2.getSaldo(), 0.001);
		
		cc2.depositar(100);
		assertEquals(100, cc2.getSaldo(), 0.001);
		
		try {
			
			cc1.transferirPara(cc2, 30);
			assertEquals(70, cc1.getSaldo(), 0.001);
			assertEquals(130, cc2.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException sie) {
			
			fail("Saldo Insuficiente na transferência de CC1 para CC2. Exceção: " + sie.getMessage());
			
		}
		
	}

}
