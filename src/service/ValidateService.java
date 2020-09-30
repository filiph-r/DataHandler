package service;

public interface ValidateService {

	boolean validateJson(String json, String jsonMetaSchema) throws Exception;
	
	// na raspolaganju stoji da se prosiri interface za druge data file formate
	// xml,yaml..

}
