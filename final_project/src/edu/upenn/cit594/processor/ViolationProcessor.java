package edu.upenn.cit594.processor;


import java.util.ArrayList;
import java.util.HashMap;

import edu.upenn.cit594.data.ViolationData;


public class ViolationProcessor {
	ArrayList<ViolationData> vioData;
	HashMap<String, Integer> totalFinePerZip = new HashMap<String, Integer>();
	
	ViolationProcessor(){

	}
	
	///////Should move this to data managment package
	void writeFine () {
		// iterate array of viodata, 
		// write viodata.zip, viodata.fine
		// to a txt file
	}
	

	//Generates a hashmap of zipCode and the total fine amount in that zipCode 
	HashMap<String, Integer> totalFinePerZip(){
		
		for (int i = 0; i < vioData.size(); i++) {
			String zipCode = vioData.get(i).getZipCode(); 
			int fines = vioData.get(i).getFine();
			
			if (!totalFinePerZip.containsKey(zipCode)) {
				totalFinePerZip.put(zipCode, fines);
			} else {
				fines = totalFinePerZip.get(zipCode) + fines; 
				totalFinePerZip.put(zipCode, fines);
			}
		}
		return totalFinePerZip;
	}

	
}
