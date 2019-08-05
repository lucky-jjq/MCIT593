package edu.upenn.cit594.processor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import edu.upenn.cit594.data.ViolationData;


public class ViolationProcessor { 
	ArrayList<ViolationData> vioData;
	HashMap<String, Integer> totalFinePerZip = new HashMap<String, Integer>();
	HashMap<String, Double> finePerCap = new HashMap<String, Double>();
	SortedSet<String> sortedZipSet = new TreeSet<String>(); 
	
	public ViolationProcessor(ArrayList<ViolationData> vioData){
		this.vioData = vioData;
	}

	//Generates a hashmap of zipCode and the total fine amount in that zipCode 
	public HashMap<String, Integer> getFinePerZip(){
		
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
	
	//Generates a hashmap of zipCode and fines per capita for that zipCode 
	public HashMap<String, Double> getFinePerCap(HashMap<String, Integer> popZipMap) {
		if (totalFinePerZip.isEmpty()) {
			getFinePerZip();
		}
		for (String zipCode : totalFinePerZip.keySet()) {
			if (!totalFinePerZip.containsKey(zipCode)) { //Per Chris' note on Piazza, 
				continue;  // if population data doesn't exist for this zipCode in the population.txt, ignore this zipCode. 
			} else {
				Integer fine = totalFinePerZip.get(zipCode);
//				System.out.println("The fine for "+zipCode+"is "+fine);
				Integer pop  = popZipMap.get(zipCode);
//				System.out.println("The population for "+zipCode+"is "+pop);
				if (fine!=null && pop!=null) {
					Double fineValue = ((double) fine) / ((double) pop);
					finePerCap.put(zipCode, fineValue); 
				}
			}	
		}
		return finePerCap; 
	}

	//Builds a set that stores zipCode in order
	public SortedSet<String> getSortedZip() {
		for (String zipKey : finePerCap.keySet()) {
			sortedZipSet.add(zipKey); 
		}	
		return sortedZipSet;	
	}
	
}
