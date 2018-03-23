package br.inatel.dm112.conta.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.inatel.dm112.conta.ContaCorrente;
import br.inatel.dm112.conta.ContaPoupanca;
import br.inatel.dm112.conta.GerenteContas;

class TestGerenteContas {

	@Test
	void testGerenteContas() {
		
		ContaCorrente cc1 = new ContaCorrente(11, "cliente 1", 15);// 15 reais de manutenção
		ContaCorrente cc2 = new ContaCorrente(12, "cliente 2", 10);// 10 reais de manutenção
		ContaPoupanca cp1 = new ContaPoupanca(21, "cliente 1", 5);// 5%
		ContaPoupanca cp2 = new ContaPoupanca(22, "cliente 2", 10);// 10%
		cc1.depositar(100);
		cc2.depositar(1000);
		cp1.depositar(1000);
		cp2.depositar(3000);

		GerenteContas ger = new GerenteContas();
		ger.adicionar(cc1);
		ger.adicionar(cc2);
		ger.adicionar(cp1);
		ger.adicionar(cp2);

		ger.atualizarTodasContas();

		assertEquals(85, cc1.getSaldo(), 0.001);
		assertEquals(990, cc2.getSaldo(), 0.001);
		assertEquals(1050, cp1.getSaldo(), 0.001);
		assertEquals(3300, cp2.getSaldo(), 0.001);

		ger.removerConta(21);// removeu a cp1

		ger.atualizarTodasContas();

		assertEquals(70, cc1.getSaldo(), 0.001);
		assertEquals(980, cc2.getSaldo(), 0.001);
		assertEquals(3630, cp2.getSaldo(), 0.001);

		assertEquals(1050, cp1.getSaldo(), 0.001);// o valor da cp1 deve ficar inalterado, pois removeu ela

		// teste com conta com saldo insuficiente
		ContaCorrente cc3 = new ContaCorrente(11, "cliente 1", 15);// 15 reais de manutenção
		cc3.depositar(5);

		ger.adicionar(cc3);
		ger.atualizarTodasContas();

		assertEquals(5, cc3.getSaldo(), 0.001);// não muda o valor do saldo
		
	}

}
