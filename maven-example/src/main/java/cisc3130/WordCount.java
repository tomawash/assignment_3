package cisc3130;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class WordCount {

public static void main(String[] args) throws FileNotFoundException {
	
		File file00 = new File("little_dark_age\\01_she_works_out_too_much.txt");
		File file01 = new File("little_dark_age\\02_little_dark_age.txt");
		File file02 = new File("little_dark_age\\03_when_you_die.txt");
		File file03 = new File("little_dark_age\\04_me_and_michael.txt");
		File file04 = new File("little_dark_age\\05_tslamp.txt");
		File file05 = new File("little_dark_age\\06_james.txt");
		File file06 = new File("little_dark_age\\07_days_that_got_away.txt");
		File file07 = new File("little_dark_age\\08_one_thing_left_to_try.txt");
		File file08 = new File("little_dark_age\\09_when_youre_small.txt");
		File file09 = new File("little_dark_age\\10_hand_it_over.txt");
		
		final int max = 10;
		
		ArrayList<File> myFiles = new ArrayList<File>(max);
		myFiles.add(0, file00);
		myFiles.add(1, file01);
		myFiles.add(2, file02);
		myFiles.add(3, file03);
		myFiles.add(4, file04);
		myFiles.add(5, file05);
		myFiles.add(6, file06);
		myFiles.add(7, file07);
		myFiles.add(8, file08);
		myFiles.add(9, file09);
		
		ArrayList<PrintWriter> myPrints = new ArrayList<PrintWriter>(max);
		myPrints.add(0, new PrintWriter("word_counts\\01_she_works_out_too_much.txt"));
		myPrints.add(1, new PrintWriter("word_counts\\02_little_dark_age.txt"));
		myPrints.add(2, new PrintWriter("word_counts\\03_when_you_die.txt"));
		myPrints.add(3, new PrintWriter("word_counts\\04_me_and_michael.txt"));
		myPrints.add(4, new PrintWriter("word_counts\\05_tslamp.txt"));
		myPrints.add(5, new PrintWriter("word_counts\\06_james.txt"));
		myPrints.add(6, new PrintWriter("word_counts\\07_days_that_got_away.txt"));
		myPrints.add(7, new PrintWriter("word_counts\\08_one_thing_left_to_try.txt"));
		myPrints.add(8, new PrintWriter("word_counts\\09_when_youre_small.txt"));
		myPrints.add(9, new PrintWriter("word_counts\\10_hand_it_over.txt"));
		
		ArrayList<Song> Album = new ArrayList<Song>();

		for(int i = 0; i < myFiles.size(); i++) {
			
			Scanner scanner = new Scanner(myFiles.get(i));
			Song mySong = countWords(scanner);
			Album.add(mySong);
			printLyrics(Album.get(i), myPrints.get(i));
			scanner.close();
		}
		
		for(int i = 0; i < myPrints.size(); i++) {
			myPrints.get(i).close();
		}
	}
	
	public static Song countWords(Scanner scanner){
		
		Hashtable <String, Integer> words = new Hashtable <String, Integer>();
		ArrayList <String> wordBank = new ArrayList<String>();
		
		String title = scanner.nextLine();
		
		while(scanner.hasNext()) {
			
			String nextLine = scanner.nextLine();
			String[] tokens = nextLine.split(" ");
			
			for(int i = 0; i < tokens.length; i++) {
				String w = fixWord(tokens[i]);
				
				if(words.containsKey(w)) {
					words.put(w, words.get(w) + 1);
				}
				else {
					words.put(w, 1);
					wordBank.add(w);
				}
			}
		}
		
		return new Song(title, words, wordBank);
	}
	
	public static void printLyrics(Song lyrics, PrintWriter output){
		
		//System.out.println(lyrics.getTitle());
		//System.out.println("Total words = " + ((lyrics.getWordCount().size())));
		
		for(int i = 1; i < lyrics.getWordBank().size(); i++) {
			
			String word = lyrics.getWordBank().get(i);
			int num = lyrics.getWordCount().get(word);
			
			output.printf("%d: %s", num, word);
			output.println();
			}
		}
	
 	public static String fixWord(String word) {
		
		word = word.toLowerCase();
		word = word.replaceAll("\\p{Punct}", "");
		
		return word;
	}	
}