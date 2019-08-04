package edu.upenn.cit594.datamanagement;

import java.io.*;
import java.util.*;

import edu.upenn.cit594.data.ViolationData;

public class ReadCSV extends DataFile {
	public ReadCSV(String filename) {
		super(filename);
	}

	protected ArrayList<ViolationData> ViolationDataList = new ArrayList<ViolationData>(); 
	
	
	private static boolean checkValid(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() == 0 ) {
			return false;
		}
		return true;
	}
	
	protected boolean filterState(String state) {
		return state.toUpperCase().equals( "PA");
	}
	
	protected boolean filterZipMissing(String[] sSplit) {
		return sSplit.length < 7;
	}
	
	protected ViolationData csvParser(String s) {
		String[] sSplit = s.split(",");
		
		if (filterZipMissing(sSplit)) {
			return null;
		}
		
//		System.out.println("String length is : "+sSplit.length);
		ViolationData vio = new ViolationData();
		vio.date = sSplit[0];
		vio.fine = Integer.parseInt(sSplit[1]);
		vio.reason = sSplit[2];
		vio.plateNum = sSplit[3];
		vio.violationID = sSplit[5];
		vio.state = sSplit[4];
		vio.zipCode = sSplit[6];
		
		if (!filterState(vio.state)) {
//			System.out.printf("%s is not PA\n",vio.state);
			return null;
		}
		
		vio.zipCode = sSplit[6];
//		System.out.println(vio);
		return vio;
	}
	
	public void readCSVFile() {		
		if (fileName == null) {
			ViolationDataList = null;
		}
//		System.out.println(fileName);
		File reviewFile = new File(fileName);
		try {
			Scanner violation = new Scanner(reviewFile);
			while (violation.hasNextLine()) {
				String s = violation.nextLine();
//				System.out.println(s);
				if (s!=null & checkValid(s)) {
					ViolationData vio = csvParser(s);
//					System.out.println(vio);
					if (vio == null) {
						continue;
					}
					ViolationDataList.add(vio);
				}
			}
		}catch (FileNotFoundException e) {
			System.out.println("Error: the specified input file does not exist or cannot be opened for reading!");
			System.exit(1);
		}
	}
	
	public ArrayList<ViolationData> getViolationDataList() {
		if (ViolationDataList.isEmpty()) {
			readCSVFile();
		}
		return ViolationDataList;
	}
	


}
