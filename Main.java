import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		CountingDictionary dict = new CountingDictionary();

		// Functions supported by the CountingDictionary class: insert,
		// delete, find, allKeyValue, prefixMatch, spellCheck1, spellCheck2.
		fillDictionary(dict);
		System.out.println(dict.allKeyValue());
		System.out.println(dict.prefixMatch("th"));
		System.out.println(dict.spellCheck1("hr"));
		System.out.println(dict.spellCheck2("hezzo", 2));

	}

	private static void fillDictionary(CountingDictionary dict) {
		try {
			File text = new File("sample-words.txt");
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
