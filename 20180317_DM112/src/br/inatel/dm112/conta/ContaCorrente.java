package br.inatel.dm112.conta;

public class ContaCorrente extends Conta {

	private float manutencaoMensal;
	
	///
	
	public ContaCorrente(int numero, String cliente, float manutencaoMensal) {
		
		super(numero, cliente);
		this.manutencaoMensal = manutencaoMensal;
		
	}
	
	///
	
	@Override
	public void atualizarSaldo() throws SaldoInsuficienteException {

//		float saldo = this.getSaldo() - manutencaoMensal;
//		if(saldo < 0) throw new SaldoInsuficienteException("Saldo Insuficiente para Manutenção");
		
		//Sugestão Prof. Roberto
		super.sacar(manutencaoMensal);
		
	}

}
