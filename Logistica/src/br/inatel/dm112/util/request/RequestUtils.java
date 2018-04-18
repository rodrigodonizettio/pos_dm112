package br.inatel.dm112.util.request;

import java.util.List;

import com.google.gson.Gson;

import br.inatel.dm112.model.entity.Produto;

public class RequestUtils {
	
	
	//Converts a list of products to Json String 
	public static String mappingToJson(List<Produto> listProduto) {
		StringBuffer result = new StringBuffer();
		for(Produto prod : listProduto) {
			result.append(new Gson().toJson(prod).toString());
		}
		return result.toString();
	}
	
	

}
