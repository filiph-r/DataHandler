package service;

public interface ObjectJsonConverter {

	String convertObjectToJson(Object object) throws Exception;

	Object convertJsonToObject(String json, Class<?> classOf) throws Exception;
}
