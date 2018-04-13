package br.inatel.dm112.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import br.inatel.dm112.model.entity.Produto;
import br.inatel.dm112.util.db.HibernateUtil;

public class ProdutoDAO {
	
	EntityManager produtoDao = HibernateUtil.getEntityManager();
	Query query;
	List<Produto> list;
	Produto produto;
	
	//**************
	//*** INSERT ***
	//**************
	public void insertProduto(Produto produto) {		
		produtoDao.getTransaction().begin();
		produtoDao.persist(produto);
		produtoDao.getTransaction().commit();
	}
	
	
	//**************
	//*** SELECT ***
	//**************
	public List<Produto> selectAllProdutos() {
		List produtos = new ArrayList();
		//
//		produtoDao.getTransaction().begin(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		query = produtoDao.createQuery("FROM Produto");
//		produtoDao.getTransaction().commit(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		produtos = query.getResultList();
		return produtos;
	}
	
	public Produto selectProdutoByNumero(int numero) {
		query = produtoDao.createQuery("FROM Produto WHERE numero = :numero");
		query.setParameter("numero", numero);
		list = query.getResultList();
		produto = list.get(0);
		return produto;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Produto produto = new Produto();
		produto.setCpf("cpf");
		produto.setEmail("email");
		produto.setNome("nome");
		produto.setNumero(1);
		produto.setStatus("entregue");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos;
		
		produtoDAO.insertProduto(produto);
		System.out.println("PRODUTO NÚMERO-" + produto.getNumero() + " INSERIDO!");
		
		produto = produtoDAO.selectProdutoByNumero(1);
		System.out.println("PRODUTO-SELECT-BY-NÚMERO: " + produto);
		
		produtos = produtoDAO.selectAllProdutos();
		System.out.println("PRODUTO-SELECT-*: " + produtos);
	}

}
