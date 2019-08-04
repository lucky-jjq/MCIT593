package edu.upenn.cit594.datamanagement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class WriteHashMap <E>{
	HashMap<E,E> hashM = new HashMap<E,E>();
	String fileName;
	
	public WriteHashMap(HashMap<E,E> hashM, String fileName){
		this.hashM = hashM;
		this.fileName = fileName;
	}
	
		
	public void write() {
        try {
            File file = new File(fileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (E key : hashM.keySet()) {
//            	System.out.println(key.toString());
//            	System.out.println(hashM.get(key));
            	writer.write((String) key);
            	writer.write(" ");
            	E val = hashM.get(key);
            	writer.write(val.toString());
            	writer.write("\n");
            }
            writer.close();
            
        } catch ( IOException e ) {
        	System.out.println("Somthing is wrong, unable to write to file");
            e.printStackTrace();
        }
	}
			
	
	

}
