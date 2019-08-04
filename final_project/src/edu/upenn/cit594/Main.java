package edu.upenn.cit594;

import java.util.ArrayList;
import java.util.HashMap;

import edu.upenn.cit594.data.ViolationData;
import edu.upenn.cit594.datamanagement.ReadData;
import edu.upenn.cit594.datamanagement.WriteData;
import edu.upenn.cit594.processor.PopProcessor;
import edu.upenn.cit594.processor.ViolationProcessor;
import edu.upenn.cit594.ui.PresentHashMap;

public class Main {
	
	protected static void checkNull (String[] args) {
		if (args == null) {
			System.out.println("The number of runtime arguments is incorrect");
			System.exit(1);
		}
	}
	
	protected static void checkLen (String[] args) {
		if (args.length !=3) {
			System.out.println("The number of runtime arguments is incorrect");
			System.exit(1);
		}
	}
	
	protected static void checkExtention (String filearg) {
		if (!(filearg.equals( "csv") | filearg.equals("json"))) {
			System.out.println("The first argument is neither csv nor json");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		// get args from config
		checkNull(args);
		checkLen(args);
		String filearg = args[0];
		checkExtention(filearg);
		String vioFileName = args[1];
		String popFileName = args[2];
		
		// read data
		ReadData d = new ReadData(filearg, vioFileName, popFileName);
		
		// write fine.txt
		ArrayList<ViolationData> vioDataList = d.getViolationDataList();
		WriteData writeD = new WriteData();
		writeD.writeFine(vioDataList);
		
		// process data
		PopProcessor popProp  = new PopProcessor(d.getPopulationDataList());
		ViolationProcessor vioProp = new ViolationProcessor(vioDataList);
		
		// write total fine per zipcode
		writeD.writeTotalFinePerZip(vioProp.getFinePerZip());
		
		// Display fine per capita in display
		HashMap<String, Integer> popZipMap = popProp.getPopPerZip();
		HashMap<String, Double> finePerCap =  vioProp.getFinePerCap(popZipMap);
		PresentHashMap pres = new PresentHashMap(finePerCap);
		pres.display();

	}

}
