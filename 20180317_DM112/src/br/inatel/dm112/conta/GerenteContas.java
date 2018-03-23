package br.inatel.dm112.conta;

import java.util.HashMap;

public class GerenteContas {
	
//	private HashMap<K, V> contas;
	private HashMap<Integer, Atualizacao> contas = new HashMap<Integer, Atualizacao>();
	
	///
	
	public void atualizarTodasContas() {
		
		for (Atualizacao conta : contas.values()) {
			
			try {
				
				conta.atualizarSaldo();
				
			} catch (SaldoInsuficienteException e) {
				 
				System.out.println("Problema com a Conta-: " + conta.getNumero() + ". Saldo Insuficiente.");
				
			}
			
		}
		
	}
	
	public void adicionar(Atualizacao a) {
		
		this.contas.put(a.getNumero(), a);
		
	}
	
	public void removerConta(int numero) {
		
		this.contas.remove(numero);
		
	}
	
}
