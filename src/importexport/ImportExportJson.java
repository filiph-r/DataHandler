package importexport;

import java.io.IOException;

public interface ImportExportJson {

	String importJson(String sourcePath) throws IOException;

	void exportJson(String destinationPath, String json) throws IOException;

}
