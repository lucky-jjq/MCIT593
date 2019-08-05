package edu.upenn.cit594.ui;


import java.util.HashMap;
import java.util.SortedSet;

public class PresentHashMap<E,V> {
	HashMap<E, V> hashM;
	SortedSet<E> zipSet; 
	
	
	public PresentHashMap(HashMap<E, V> hashM, SortedSet<E> zipSet){
		this.hashM = hashM;
		this.zipSet = zipSet; 
	}
	
	public void display() {
		System.out.println("Fines per capita in each zip code (ascending order):");
		for (E key: zipSet) {
			System.out.printf("%s %.4f\n", key, hashM.get(key));
		}
	}
}
