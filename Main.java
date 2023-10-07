import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		CountingDictionary dict = new CountingDictionary();
		
		// Functions supported by the CountingDictionary class: insert, delete, find, allKeyValue, prefixMatch, spellCheck1, spellCheck2.
		try {
			File text = new File("sample-words.txt");
			Scanner reader = new Scanner(text);
			while (reader.hasNextLine()) {
				String word = reader.nextLine();
				System.out.println(word);
			}
			reader.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("File was not found.");
			e.printStackTrace();
		}
	}
}