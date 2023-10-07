
/**
 * @author Alexander Guel
 * 
 * A list of functions that the Trie should be able to execute.
 * All of the methods were given, but the task was to first implement
 * the TrieNode class and then make it work with this class.
 */
import java.util.ArrayList;

public class Trie implements CS211CountingDictionaryInterface {

	TrieNode root = new TrieNode();

	public void insert(String key) {
		root.insert(key, "");
	}

	public boolean delete(String key) {
		if (root.find(key) == null)
			return false;
		else
			root.delete(key);
		return true;
	}

	public int find(String key) {
		if (root == null)
			return -1;
		else {
			Word w = root.find(key);
			if (w == null)
				return -1;
			else
				return w.getCount();
		}
	}

	/*
	 * Here, the tasks was to come up with a new method that was not given.
	 * 
	 *  Extra interesting method:
	 * Reverses a string in the Trie
	 */
	public boolean reverse(String key) {
		if (root.find(key) != null) {
			root.delete(key);
			String reversedKey = "";
			for (int i = key.length() - 1; i >= 0; i--) {
				reversedKey += key.charAt(i);
			}
			root.insert(reversedKey, "");
			return true;
		}
		return false;
	}

	public ArrayList<Word> prefixMatch(String start) {
		ArrayList<Word> v = new ArrayList<Word>();
		root.prefixMatch(v, start);
		return v;
	}

	public ArrayList<Word> spellCheck1(String start) {
		ArrayList<Word> v = new ArrayList<Word>();
		root.spellCheck1(v, start);
		return v;
	}

	@Override
	public ArrayList<Word> allKeyValue() {
		ArrayList<Word> v = new ArrayList<Word>();
		root.allKeyValue(v);
		return v;
	}

	public ArrayList<Word> spellCheck2(String key, int errs) {
		ArrayList<Word> ws = new ArrayList<Word>();
		root.spellCheck2(ws, key, errs + 1);
		return ws;
	}

	public void print() {
		root.print("");
	}
}
