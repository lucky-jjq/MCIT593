package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.ReadData;

public class Main {
	
	
	
	public static void main(String[] args) {
		if (args == null) {
			System.out.println("The number of runtime arguments is incorrect");
			System.exit(1);
		}
		if (args.length !=3) {
			System.out.println("The number of runtime arguments is incorrect");
			System.exit(1);
		}
		
		String filearg = args[0];
		if (filearg == null) {
			System.out.println("The number of runtime arguments is incorrect");
			System.exit(1);
		}
		if (filearg != "csv" | filearg != "json") {
			System.out.println("The first argument is neither csv nor json");
			System.exit(1);
		}
		
		String vioFileName = args[1];
		String popFileName = args[2];
		
		ReadData d = new ReadData(filearg, vioFileName, popFileName);
		d.getViolationDataList();
		

	}

}
