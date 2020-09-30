package service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import service.ObjectJsonConverter;

public class ObjectJsonConverterImpl implements ObjectJsonConverter {

	public static ObjectJsonConverterImpl instance;
	private Gson gson = new Gson();

	// Singleton pattern
	public synchronized static ObjectJsonConverterImpl get() {
		if (instance == null)
			instance = new ObjectJsonConverterImpl();
		return instance;
	}

	@Override
	public String convertObjectToJson(Object object) throws Exception{
		String jsonString = gson.toJson(object);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		JsonNode tree = objectMapper.readTree(jsonString);
		String formattedJson = objectMapper.writeValueAsString(tree);
		
		return formattedJson;
	}

	@Override
	public Object convertJsonToObject(String json, Class<?> classOf) throws Exception{
		Object object = gson.fromJson(json, classOf);
		return object;
	}

}
