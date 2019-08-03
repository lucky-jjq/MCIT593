package processor;


import java.util.HashMap;

public class FinePerCap {
	PopProcessor popPro = new PopProcessor();
	ViolationProcessor vioPro = new ViolationProcessor();
	
	HashMap<String, Integer> popZipMap = popPro.getPopPerZip();
	HashMap<String, Integer> fineZipMap = vioPro.totalFinePerZip();
	
	HashMap<String, Double> finePerCap = new HashMap<String, Double>(); 
	
	public FinePerCap() {
		
	}
	
	//Generates a hashmap of zipCode and fines per capita for that zipCode 
	public HashMap<String, Double> getFinePerCap() {
		for (String zipCode : fineZipMap.keySet()) {
			if (!fineZipMap.containsKey(zipCode)) { //Per Chris' note on Piazza, 
				continue;  // if population data doesn't exist for this zipCode in the population.txt, ignore this zipCode. 
			} else {
				Double fineValue = (double) (fineZipMap.get(zipCode)/popZipMap.get(zipCode));
				finePerCap.put(zipCode, fineValue); 
			}	
		}
		return finePerCap; 
		
	}
	
}
