package br.inatel.dm112.conta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.inatel.dm112.conta.ContaPoupanca;
import br.inatel.dm112.conta.SaldoInsuficienteException;

public class TestContaPoupanca {

	@Test
	void testContaPoupanca() {
		
		ContaPoupanca cp = new ContaPoupanca(1, "cliente 1", 10);// 10%, para ficar fácil de validar ;)
		
		///
		
		assertEquals(0, cp.getSaldo(), 0.001);// conta zerada

		cp.depositar(100);
		assertEquals(100, cp.getSaldo(), 0.001);

		try {
			
			cp.atualizarSaldo();// aumenta 10 reais
			assertEquals(110, cp.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException e) {
			
			fail("O saldo deve ser 110: " + e.getMessage());
			
		}

		try {
			
			cp.atualizarSaldo();// aumenta 11 reais
			assertEquals(121, cp.getSaldo(), 0.001);
			
		} catch (SaldoInsuficienteException e) {
			
			fail("O saldo deve ser 121: " + e.getMessage());
			
		}
		
	}

}
