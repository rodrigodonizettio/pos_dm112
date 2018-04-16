package br.inatel.dm112.model.interfaces;

import java.util.List;

import br.inatel.dm112.model.entity.Produto;

public interface ProdutoInterface {
	public void insertProduto(Produto produto) throws Exception;
	public List<Produto> selectAllProdutos() throws Exception;
	public Produto selectProdutoByNumero(int numero) throws Exception;
	public void updateProdutoStatus(int numero, String status) throws Exception;
}
