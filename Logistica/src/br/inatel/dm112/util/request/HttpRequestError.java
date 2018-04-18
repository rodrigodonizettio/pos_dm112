package br.inatel.dm112.util.request;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public class HttpRequestError extends HTTPException{
	
	public HttpRequestError(int statusCode) {
		super(statusCode);
		// TODO Auto-generated constructor stub
	}
	static final String INTERNAL_SERVER_ERROR = "Ocorreu um erro interno";
	static final String NO_CONTENT = "Sem registro na base de dados";
	static final String BAD_REQUEST = "Faça a requisição de modo correto";
	
	public static void createInternalServerError (String message , HttpServletResponse response) throws IOException {
		String finalMessage = "";
		if (message != null) {
			finalMessage = message;
		}else {
			finalMessage = NO_CONTENT;
		}
		response.sendError(response.SC_INTERNAL_SERVER_ERROR,finalMessage);
	}
	
	public static void createNoContentError (String message , HttpServletResponse response) throws IOException {
		String finalMessage = "";
		if (message != null) {
			finalMessage = message;
		}else {
			finalMessage = NO_CONTENT;
		}
		
		response.sendError(response.SC_INTERNAL_SERVER_ERROR,finalMessage);
	}
	
	

}
