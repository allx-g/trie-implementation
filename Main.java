import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		CountingDictionary dict = new CountingDictionary();

		// Note that a counting dictionary only works with input words with only alphabetic characters (a-z).
		// See CountingDictionary.java or in an IDE hover over the functions to see what they do.

		// Functions supported by the CountingDictionary class: 
		// insert, delete, find, allKeyValue, prefixMatch, spellCheck1, spellCheck2.

		fillDictionary(dict); // Also, try commenting out this line and inserting and deleting manually.
		// System.out.println(dict.allKeyValue()); // Print all the words in the dictionary.
		// System.out.println(dict.prefixMatch("yes")); // Find all the words that match the prefix.
		// System.out.println(dict.spellCheck1("pirake"));
		
		System.out.println(dict.spellCheck1("snowkng"));
		System.out.println(dict.spellCheck2("snowkng",2));
	}

	private static void fillDictionary(CountingDictionary dict) {
		try {
			File text = new File("words_alpha.txt"); // The text file contains a long list of words
			Scanner reader = new Scanner(text);
			while (reader.hasNextLine()) {
				String word = reader.nextLine();
				dict.insert(word);
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File was not found.");
			e.printStackTrace();
		}
	}
}
