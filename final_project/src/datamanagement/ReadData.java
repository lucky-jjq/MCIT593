package datamanagement;

public class ReadData extends DataFile{
	
	
	protected String getExtention(String fileName) {
		return "csv"; //to add
	}
	
	
	protected void parsing() {
		String extension = getExtention(fileName);
		if (extension == "csv") {
			 	
		} else if (extension == "json"){
			jsonParser();
		} else if (extension == "txt") {
			txtParser(); 
		}
	}
	
	
}
