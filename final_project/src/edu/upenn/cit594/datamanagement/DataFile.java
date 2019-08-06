package edu.upenn.cit594.datamanagement;

public abstract class DataFile {
	// abstract super class that houses info about filename for all read related classes
	protected String fileName; 

	public DataFile(String filename) {
		this.fileName = filename;
	}
}
