package br.inatel.dm112.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.inatel.dm112.model.DAO.ProdutoDAO;
import br.inatel.dm112.model.entity.Produto;
import br.inatel.dm112.util.adapter.MailAdapter;

/**
 * Servlet implementation class ProdutoInsert
 */
@WebServlet("/ProdutoInsert")
public class ProdutoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		BufferedReader br = request.getReader();
		String qts = br.lines().collect(Collectors.joining(";"));
		String[] dados = qts.split(";");
		response.getWriter().append(qts);
		System.out.println(dados[0]);
		System.out.println(dados[1]);
		System.out.println(dados[2]);
		System.out.println(dados[3]);
		
		Produto produto = new Produto();
		produto.setNome(dados[0]);
		produto.setStatus(dados[1]);
		produto.setCpf(dados[2]);
		produto.setEmail(dados[3]);
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produtoDAO.insertProduto(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MailAdapter mailSender = new MailAdapter();
		
		//DATA TO MAILING PRODUCTS
		String from = "robertorr9@gmail.com";
		String to = produto.getEmail();
		String password = "robertodm112";
		String message = produto.toString();
		
		//SEND EMAIL
		mailSender.sendMail(from, password, to,message);
		
	}

}
