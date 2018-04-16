

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.inatel.dm112.model.DAO.ProdutoDAO;
import br.inatel.dm112.model.entity.Produto;

/**
 * Servlet implementation class ProdutoUpdate
 */
@WebServlet("/ProdutoUpdate")
public class ProdutoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdutoUpdate() {
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
		int numero = Integer.parseInt(dados[0]);
		//
		ProdutoDAO produtoDAO = new ProdutoDAO();
		try {
			produtoDAO.updateProdutoStatus(numero, dados[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
