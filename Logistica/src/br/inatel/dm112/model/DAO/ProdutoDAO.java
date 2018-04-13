package br.inatel.dm112.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import br.inatel.dm112.model.entity.Produto;
import br.inatel.dm112.util.db.HibernateUtil;

public class ProdutoDAO {
	
	EntityManager produtoDAO = HibernateUtil.getEntityManager();
	Query query;
	List<Produto> list;
	Produto produto;
	
	//**************
	//*** INSERT ***
	//**************
	public void insertProduto(Produto produto) {		
		produtoDAO.getTransaction().begin();
		produtoDAO.persist(produto);
		produtoDAO.getTransaction().commit();
//		query = getSession().createSQLQuery("INSERT INTO TABLA (CAMPO1, CAMPO2) VALUES (:valor1, encripta(:valor2, :key))");
//		query.setParameter("valor1", valor1);
//		query.setParameter("valor2", valor2);
//		query.setParameter("key", key);
//		query.executeUpdate();
	}
	
	
	//**************
	//*** SELECT ***
	//**************
	public List<Produto> selectAllProdutos() {
		List produtos = new ArrayList();
		//
//		produtoDao.getTransaction().begin(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		query = produtoDAO.createQuery("FROM Produto");
//		produtoDao.getTransaction().commit(); //APENAS UTILIZADO QUANDO HOUVER ALTERAÇÃO NA DB [SELECT NÃO ALTERA DB]
		produtos = query.getResultList();
		return produtos;
	}
	
	public Produto selectProdutoByNumero(int numero) {
		query = produtoDAO.createQuery("FROM Produto WHERE numero = :numero");
		query.setParameter("numero", numero);
		list = query.getResultList();
		produto = list.get(0);
		return produto;
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
		
		//
		
		try {
			produtoDAO.insertProduto(produto);
			System.out.println("PRODUTO NÚMERO-" + produto.getNumero() + " INSERIDO!");
			System.out.println("--------------------------");
			
			produto = produtoDAO.selectProdutoByNumero(5);
			System.out.println("PRODUTO-SELECT-BY-NÚMERO: " + produto);
			System.out.println("--------------------------");
			
			produtos = produtoDAO.selectAllProdutos();
			System.out.println("PRODUTO-SELECT-*: " + produtos);
			System.out.println("--------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Encerrando Sistema");
			System.exit(1);
		}
		
	}

}
