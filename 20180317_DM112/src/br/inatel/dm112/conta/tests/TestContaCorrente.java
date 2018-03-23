package br.inatel.dm112.conta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.inatel.dm112.conta.ContaCorrente;
import br.inatel.dm112.conta.SaldoInsuficienteException;

class TestContaCorrente {

	@Test
	void testcontaCorrente() {
		
		ContaCorrente cc = new ContaCorrente(1, "cliente 1", 15);// 15 reais de manutenção
		
		///
		
		assertEquals(0, cc.getSaldo(), 0.001);// conta zerada
		assertEquals(1, cc.getNumero());
		
		cc.depositar(100);
		assertEquals(100, cc.getSaldo(), 0.001);

		try {
			
			cc.sacar(30);
			assertEquals(70, cc.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException e) {
			
			fail("O saldo deve ser 70: " + e.getMessage());
			
		}
		
		try {
			
			cc.sacar(80);
			fail("O saldo deve ser 70");
			
		} catch (SaldoInsuficienteException e) {
			
			// ok. Realmente deveria dar exceção e manter os 70 reais
			assertEquals(70, cc.getSaldo(), 0.001);
			
		}
		
		try {
			
			cc.atualizarSaldo();// desconta 15 reais
			assertEquals(55, cc.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException e) {
			
			fail("O saldo deve ser 55: " + e.getMessage());
			
		}

		try {
			
			cc.sacar(50);
			assertEquals(5, cc.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException e) {
			
			fail("O saldo deve ser 5: " + e.getMessage());
			
		}
		
		try {
			
			cc.atualizarSaldo();// desconta 15 reais
			fail("Não deveria ter atualizado, pois não tem saldo.");
			
		} catch (SaldoInsuficienteException e) {
			
			assertEquals(5, cc.getSaldo(), 0.001);
			
		}
		
	}

}
