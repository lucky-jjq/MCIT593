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
		if (extension == "csv") {
			 ReadCSV d = new ReadCSV();
			 d.fileName = vioFileName;
			 return d.getViolationDataList();
		} else if (extension == "json"){
			 ReadJSON d = new ReadJSON();
			 d.fileName = vioFileName;
			 return d.getViolationDataList();
		} 
		return null;
	}
	
	
	
	
}
