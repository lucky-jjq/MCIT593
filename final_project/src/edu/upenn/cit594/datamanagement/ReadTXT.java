package edu.upenn.cit594.datamanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.upenn.cit594.data.PopData;

public class ReadTXT extends DataFile{
	// Read TXT files
	public ReadTXT(String filename) {
		super(filename);
	}

	protected ArrayList<PopData> popDataList = new ArrayList<PopData>(); 
	
	private static boolean checkValid(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0 ) {
			return false;
		}
		return true;
	}
	

	protected boolean filterZipMissing(String[] sSplit) {
		return sSplit.length < 2;
	}
	
	protected PopData txtParser(String s) {
		String[] sSplit = s.split(" ");
		
		if (filterZipMissing(sSplit)) {
			return null;
		}
		
//		System.out.println("String length is : "+sSplit.length);
		PopData pop = new PopData();
		pop.zipCode = sSplit[0];
		pop.population = Integer.parseInt(sSplit[1]);
//		System.out.println(pop);
		return pop;
	}
	
	public void readCSVFile() {		
		if (fileName == null) {
			System.out.println("Population file does not exist");
			popDataList = null;
		}
		File reviewFile = new File(fileName);
		try {
			Scanner population = new Scanner(reviewFile);
			while (population.hasNextLine()) {
				String s = population.nextLine();
//				System.out.println(s);
				if (s!=null & checkValid(s)) {
					PopData pop = txtParser(s);
//					System.out.println(pop);
					if (pop == null) {
						continue;
					}
					popDataList.add(pop);
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("Error: the specified input file does not exist or cannot be opened for reading!");
			System.exit(1);
		}
	}
	
	public ArrayList<PopData> getPopulationDataList() {
		if (popDataList.isEmpty()) {
			readCSVFile();
		}
		return popDataList;
	}

}
