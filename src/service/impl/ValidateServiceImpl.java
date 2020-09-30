package service.impl;

import service.ValidateService;
import utils.JsonValidationUtils;

public class ValidateServiceImpl implements ValidateService {

	public static ValidateServiceImpl instance;

	// Singleton pattern
	public synchronized static ValidateServiceImpl get() {
		if (instance == null)
			instance = new ValidateServiceImpl();
		return instance;
	}

	@Override
	public boolean validateJson(String json, String jsonMetaSchema) throws Exception {
		boolean isValid = JsonValidationUtils.isJsonValid(jsonMetaSchema, json);
		return isValid;
	}

}
