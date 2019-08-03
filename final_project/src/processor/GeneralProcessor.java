package processor;
import java.util.*;
import data.PopData;
import data.ViolationData;

public class GeneralProcessor {
	String fileName; 
	String extension; 
	ArrayList<ViolationData> violationData; 
	ArrayList<PopData> popData; 
	
	GeneralProcessor(String fileName){
		this.fileName = fileName; 
	}
	
	protected void getExtention() {
		extension = "csv"; //to add
	}
	
	protected void parsing() {
		if (extension == "csv") {
			csvParser(); 	
		} else if (extension == "json"){
			jsonParser();
		} else if (extension == "txt") {
			txtParser(); 
		}
	}
	


	protected void jsonParser() {
		//update output
	}
	protected void txtParser() {
		//update output
	}
	
}
