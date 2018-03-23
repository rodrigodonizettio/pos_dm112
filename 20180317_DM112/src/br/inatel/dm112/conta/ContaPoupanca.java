package br.inatel.dm112.conta;

public class ContaPoupanca extends Conta {

	private float taxaDeJuros;
//	private float saldo;
	
	///
	
	public ContaPoupanca(int numero, String cliente, float taxaDeJuros) {
		super(numero, cliente);
		this.taxaDeJuros = taxaDeJuros;

	}

	///

	@Override
	public void atualizarSaldo() throws SaldoInsuficienteException {

		//float saldo = this.getSaldo() + (this.getSaldo() * taxaDeJuros);
		//saldo = saldo + (saldo * taxaDeJuros);
		
		//Sugestão Prof. Roberto
		super.depositar(this.getSaldo() * (this.taxaDeJuros / 100));
		
	}
	
}
