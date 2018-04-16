package br.inatel.dm112.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.inatel.dm112.model.entity.Produto;
import br.inatel.dm112.util.db.HibernateUtil;
import br.inatel.dm112.model.interfaces.ProdutoInterface;

public class ProdutoDAO implements ProdutoInterface {
	
	int quantidadeEstoque = 100;
	//
	EntityManager produtoDAO;
	Query query;
	List<Produto> list;
	Produto produto;
	
	//***********************
	//*** OPEN CONNECTION ***
	//***********************
	private void openConnection() throws Exception {
		produtoDAO = HibernateUtil.getEntityManager();
	}
	
	//***********************
	//*** DESTROY CONNECTION ***
	//***********************
	private void  destroyConnection() {
		produtoDAO.close();
	}
	
	
	//**********************************
	//*** DECREMENT ESTOQUE QUANTITY ***
	//**********************************	
	public void decrementEstoqueQuantidade() {
		quantidadeEstoque--;
	}
	
	public int getEstoqueQuantidade() {
		return quantidadeEstoque;
	}
	
	public void setEstoqueQuantidade(int quantidade) {
		quantidadeEstoque = quantidade;
	}
	
	//**************
	//*** INSERT ***
	//**************
	public void insertProduto(Produto produto) throws Exception {	
		this.decrementEstoqueQuantidade();
		//
		this.openConnection();
		produtoDAO.getTransaction().begin();
		produtoDAO.persist(produto);
		produtoDAO.getTransaction().commit();
		this.destroyConnection();
	}
	
	
	//**************
	//*** SELECT ***
	//**************
	public List<Produto> selectAllProdutos() throws Exception {
		List produtos = new ArrayList();
		//
//		produtoDao.getTransaction().begin(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		this.openConnection();
		query = produtoDAO.createQuery("FROM Produto");
//		produtoDao.getTransaction().commit(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		produtos = query.getResultList();
		this.destroyConnection();
		return produtos;
	}
	
	public Produto selectProdutoByNumero(int numero) throws Exception {
		this.openConnection();
		query = produtoDAO.createQuery("FROM Produto WHERE numero = :numero");
		query.setParameter("numero", numero);
		list = query.getResultList();
		produto = list.get(0);
		this.destroyConnection();
		return produto;
	}
	
	
	//**************
	//*** UPDATE ***
	//**************
	public void updateProdutoStatus(int numero, String status) throws Exception {		
		this.openConnection();
		produtoDAO.getTransaction().begin();
		query = produtoDAO.createQuery("FROM Produto WHERE numero = :numero");
		query.setParameter("numero", numero);
		List<Produto> listProduto = query.getResultList();
		Produto produtoUpdate = listProduto.get(0);
		produtoUpdate.setStatus(status);
		produtoDAO.persist(produtoUpdate);
		produtoDAO.getTransaction().commit();
		this.destroyConnection();
	}
	
	
	
	public static void main(String[] args) {
		Produto produto = new Produto();
//		produto.setNumero(2); //ATRIBUTO AGORA É PK e BIG-SERIAL NA DB
		produto.setStatus("entregue");
		produto.setNome("nome");
		produto.setCpf("cpf");
		produto.setEmail("email");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos;
		int numeroUpdate = 5;
		
		//
		
		try {
			System.out.println("QUANTIDADE DE PRODUTOS EM ESTOQUE: " + produtoDAO.getEstoqueQuantidade());
			
			produtoDAO.insertProduto(produto);
			System.out.println("PRODUTO NÚMERO-" + produto.getNumero() + " INSERIDO!");
			System.out.println("--------------------------");
			
			produtoDAO.updateProdutoStatus(numeroUpdate, "extraviado");
			System.out.println("PRODUTO NÚMERO-" + numeroUpdate + " TEVE SEU STATUS ATUALIZADO!");
			System.out.println("--------------------------");
			
			produto = produtoDAO.selectProdutoByNumero(5);
			System.out.println("PRODUTO-SELECT-BY-NÚMERO: " + produto);
			System.out.println("--------------------------");
			
			produtos = produtoDAO.selectAllProdutos();
			System.out.println("PRODUTO-SELECT-*: " + produtos);
			System.out.println("--------------------------");
			
			System.out.println("QUANTIDADE DE PRODUTOS EM ESTOQUE: " + produtoDAO.getEstoqueQuantidade());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Encerrando Sistema");
			System.exit(1);
		}
		
	}

}
