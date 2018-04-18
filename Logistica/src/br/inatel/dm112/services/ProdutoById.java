package br.inatel.dm112.services;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.inatel.dm112.model.DAO.ProdutoDAO;
import br.inatel.dm112.util.request.HttpRequestError;

/**
 * Servlet implementation class ProdutoById
 */
@WebServlet("/ProdutoById")
public class ProdutoById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
			int numero = Integer.parseInt(request.getParameter("numero"));
			ProdutoDAO produtoDAO = new ProdutoDAO();
			response.getWriter().append(produtoDAO.selectProdutoByNumero(numero).toString());
		} catch (Exception e) {
			HttpRequestError.createInternalServerError(null, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
