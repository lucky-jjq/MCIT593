package edu.upenn.cit594.datamanagement;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import edu.upenn.cit594.data.ViolationData;

public class WriteData {
	
	public void writeFine(ArrayList<ViolationData> vioData) {
		String fileName = "fines.txt";
        try {
            File file = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (ViolationData vio: vioData) {
//            	System.out.println(vio.zipCode);
            	writer.write(vio.zipCode);
            	writer.write(" ");
            	writer.write(Integer.toString(vio.fine));
            	writer.write("\n");
            }
            writer.close();
            
        } catch ( IOException e ) {
        	System.out.println("Somthing is wrong, unable to write to file");
            e.printStackTrace();
        }
	}
	
	public void writeTotalFinePerZip(HashMap<String, Integer> totalFineZip) {
		String fileName = "total.txt";
		WriteHashMap totalWrite = new WriteHashMap(totalFineZip, fileName);
		totalWrite.write();
	}
	


}
