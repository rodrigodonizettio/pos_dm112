package br.inatel.dm112.model.DAO;

import javax.persistence.EntityManager;

import org.hibernate.Hibernate;

import br.inatel.dm112.model.entity.Produto;

public class ProdutoDAO {
	
	static EntityManager produtoDao = HibernateUtil.getEntityManager();
	
	public static void insertProduto (Produto produto) {
		produtoDao.getTransaction().begin();
		produtoDao.persist(produto);
		produtoDao.getTransaction().commit();
		
	}
	
	public static void main(String[] args) {
		Produto produto = new Produto();
		produto.setCpf("cpf");
		produto.setEmail("email");
		produto.setNome("nome");
		produto.setNumero(2);
		produto.setStatus("entregue");
		
		insertProduto(produto);
		System.out.println("deu certo");
		
	}

}
