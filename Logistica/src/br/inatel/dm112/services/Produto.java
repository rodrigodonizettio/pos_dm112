package br.inatel.dm112.services;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.inatel.dm112.model.DAO.ProdutoDAO;
import br.inatel.dm112.util.request.HttpRequestError;
import br.inatel.dm112.util.request.RequestUtils;

/**
 * Servlet implementation class Produto
 */
@WebServlet("/Produto")
public class Produto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Produto() {
        super();
        // TODO Auto-generated constructor stub
    }

    //GET : THIS METHOD RETURNS ALL PRODUCTS 
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		ProdutoDAO produtoDAO = new ProdutoDAO();
  		String result = "";
  		try {
  			if(produtoDAO.selectAllProdutos().size() > 0) {
  				result = RequestUtils.mappingToJson(produtoDAO.selectAllProdutos());
  				response.getWriter().append(result);
  			}else {
  				HttpRequestError.createNoContentError(null, response);
  			}
  				
  		} catch (Exception e) {
  			HttpRequestError.createInternalServerError(null, response);
  		}
  		
  	}

	

}
