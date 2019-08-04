package edu.upenn.cit594.ui;


import java.util.HashMap;

public class PresentHashMap <E> {
	HashMap<E,E> hashM = new HashMap<E,E>();
	
	public PresentHashMap(HashMap<E,E> hashM){
		this.hashM = hashM;
	}
	
		
	public void display() {
        for (E key : hashM.keySet()) {
        	System.out.printf("%s %.4f\n", key.toString(), hashM.get(key));
        }
	}
}
