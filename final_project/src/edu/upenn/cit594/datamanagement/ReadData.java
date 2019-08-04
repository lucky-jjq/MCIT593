package edu.upenn.cit594.datamanagement;

import java.util.ArrayList;

import edu.upenn.cit594.data.PopData;
import edu.upenn.cit594.data.ViolationData;

public class ReadData{
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
			System.out.println("processing...");
			 ReadCSV d = new ReadCSV();
			 d.fileName = vioFileName;
			 return d.getViolationDataList();
		} else if (extension.equals("json")){
			 ReadJSON d = new ReadJSON();
			 d.fileName = vioFileName;
			 return d.getViolationDataList();
		} 
		return null;
	}
	
	
	public ArrayList<PopData> getPopulationDataList() {
		 ReadTXT d = new ReadTXT();
		 d.fileName = popFileName;
		 return d.getPopulationDataList();
	}
	
	
	public static void main(String[] args) {
		ReadData c = new ReadData("csv", "parking.csv","population.txt");
		c.getViolationDataList();

	}
}
