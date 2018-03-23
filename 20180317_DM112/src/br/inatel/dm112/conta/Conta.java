package br.inatel.dm112.conta;

public abstract class Conta implements Atualizacao {

	private int numero;
	private String cliente;
	private float saldo = 0f;
	
	///
	
	public Conta(int numero, String cliente) {
		
		this.numero = numero;
		this.cliente = cliente;
		
	}
	
	///
	
	public void sacar(float valor) throws SaldoInsuficienteException {
		
		if((this.saldo < valor) || (valor == 0)) throw new SaldoInsuficienteException("Saldo Insuficiente para Sacar ou Valor de Saque Nulo");
		else this.saldo -= valor;
		
	}
	
	public boolean depositar(float valor) {
		
		if(valor <= 0) {
			
			System.out.println("Não é possível depositar Valor Negativo ou Nulo");
			return false;
			
		} else this.saldo += valor;
		return true;
		
	}
	
	public void transferirPara(Conta c, float valor) throws SaldoInsuficienteException {
		
//		if(this.saldo < valor) throw new SaldoInsuficienteException("Saldo Insuficiente para Transferência");
//		else {
//			
//			this.saldo -= valor;
//			c.saldo += valor;
//			
//		}
		
		//Sugestão do prof. Roberto
		this.sacar(valor);
		c.depositar(valor);
		
	}
	
	public float getSaldo() {
		
		return this.saldo;
		
	}
	
	public int getNumero() {
		
		return this.numero;
		
	}
	
}
