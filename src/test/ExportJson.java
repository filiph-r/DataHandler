package test;

import importexport.impl.ImportExportJsonImpl;
import model.Student;
import service.impl.ObjectJsonConverterImpl;
import service.impl.ValidateServiceImpl;
import utils.FileUtils;

public class ExportJson {

	public static void main(String[] args) throws Exception {
		Student student = new Student("Marko Markovic", 22, "RN 007/20");

		// convertujemo java objekat u string koj je u json data-formatu
		String json = ObjectJsonConverterImpl.get().convertObjectToJson(student);

		// ucitavamo json-meta-semu
		String jsonMetaSchema = FileUtils.fileToString("/data/JsonSchema-example.json");

		// ispisujemo objekat u json formatu
		System.out.println("JSON:\n" + json);

		// proveravamo validnost json na osnovu meta-seme
		boolean valid = ValidateServiceImpl.get().validateJson(json, jsonMetaSchema);

		System.out.println("\nIs JSON valid: " + valid);

		// ako je json validan exportujemo ga u file
		if (valid) {
			ImportExportJsonImpl impExp = new ImportExportJsonImpl();
			impExp.exportJson("/data/exportedJson.json", json);
		}
	}

}
