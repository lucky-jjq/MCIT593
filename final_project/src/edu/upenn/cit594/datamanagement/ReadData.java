package edu.upenn.cit594.datamanagement;

import java.util.ArrayList;

import edu.upenn.cit594.data.PopData;
import edu.upenn.cit594.data.ViolationData;

public class ReadData{
	// Read data no matter what is the extension
	protected ArrayList<ViolationData> ViolationDataList = new ArrayList<ViolationData>(); 
	protected ArrayList<PopData> PopulationDataList = new ArrayList<PopData>(); 
	String extension;
	String vioFileName;
	String popFileName;
	
	public ReadData(String fileArg, String vioFileName, String popFileName) {
		this.extension = fileArg;
		this.vioFileName = vioFileName;
		this.popFileName = popFileName;
	}
	
	
	public ArrayList<ViolationData> getViolationDataList() {
		if (extension.equals("csv")) {
			 ReadCSV d = new ReadCSV(vioFileName);
			 return d.getViolationDataList();
		} else if (extension.equals("json")){
			 ReadJSON d = new ReadJSON(vioFileName);
			 return d.getViolationDataList();
		} 
		return null;
	}
	
	
	public ArrayList<PopData> getPopulationDataList() {
		 ReadTXT d = new ReadTXT(popFileName);
		 return d.getPopulationDataList();
	}
	
	
	public static void main(String[] args) {
		ReadData c = new ReadData("csv", "parking.csv","population.txt");
		c.getViolationDataList();

	}
}
