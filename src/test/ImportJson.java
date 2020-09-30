package test;

import importexport.impl.ImportExportJsonImpl;
import model.Student;
import service.impl.ObjectJsonConverterImpl;
import service.impl.ValidateServiceImpl;
import utils.FileUtils;

public class ImportJson {

	public static void main(String[] args) throws Exception {

		ImportExportJsonImpl impExp = new ImportExportJsonImpl();

		// importujemo json file u string
		String json = impExp.importJson("/data/exportedJson.json");

		// ucitavamo json-meta-semu
		String jsonMetaSchema = FileUtils.fileToString("/data/JsonSchema-example.json");

		// proveravamo validnost json na osnovu meta-seme
		boolean valid = ValidateServiceImpl.get().validateJson(json, jsonMetaSchema);
		System.out.println("Is JSON valid: " + valid);

		// ako je validan ucitavamo json u java objekat
		if (valid) {
			Student student = (Student) ObjectJsonConverterImpl.get().convertJsonToObject(json, Student.class);
			System.out.println("\nIme studenta:\n" + student.getName());
		}
	}

}
