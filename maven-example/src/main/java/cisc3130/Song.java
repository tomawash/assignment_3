package cisc3130;

import java.util.ArrayList;
import java.util.Hashtable;

public class Song {

	private String title;
	private Hashtable <String, Integer> wordCount = new Hashtable <String, Integer>();
	private ArrayList <String> wordBank = new ArrayList<String>();
	
	public Song() {
		title = new String("Placeholder");
	}
	
	public Song(String t, Hashtable <String, Integer> c, ArrayList <String> b) {
		title = new String(t);
		wordCount = new Hashtable <String, Integer>(c);
		wordBank = new ArrayList <String>(b);
	}
	
	public void setTitle(String t) {
		title = new String(t);
	}
	
	public String getTitle() {
		return new String(title);
	}
	
	public void setWordCount(Hashtable <String, Integer> c) {
		wordCount = new Hashtable <String, Integer>(c);
	}
	
	public Hashtable <String, Integer> getWordCount() {
		return new Hashtable <String, Integer>(wordCount);
	}
	
	public void setWordBank(ArrayList <String> b) {
		wordBank = new ArrayList <String>(b);
	}
	
	public ArrayList <String> getWordBank() {
		return new ArrayList <String>(wordBank);
	}
}
