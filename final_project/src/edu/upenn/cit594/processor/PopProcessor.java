package edu.upenn.cit594.processor;
import java.util.*;

import edu.upenn.cit594.data.PopData;

public class PopProcessor {
	ArrayList<PopData> popData;
	HashMap<String, Integer> popPerZip = new HashMap<String, Integer>();
	
	public PopProcessor(ArrayList<PopData> popData){
		this.popData=popData;
	}
	
	//Generates a hashmap of zipCode and the total population in that zipCode. 
	public HashMap<String, Integer> getPopPerZip(){
		for (int i = 0; i < popData.size(); i++) {
			String zipCode = popData.get(i).getZipCode(); 
			int population = popData.get(i).getPopulation();
			
			if (!popPerZip.containsKey(zipCode)) {
				popPerZip.put(zipCode, population);
			} else {
				population = popPerZip.get(zipCode) + population; 
				popPerZip.put(zipCode, population);
			}
		}
		return popPerZip;
	}
	
	////// Should probably move this to data management package? 
	//void writeHash(HashMap<String, Integer> p) {
		// write hashmap
	//}
	
    //////Should probably move this to data management package? 
	//void writePopPerZip() {
	//	writeHash(popPerZip);
	//}

}
