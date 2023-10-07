/**
 * @author Alexander Guel
 */
import java.util.ArrayList;

public class TrieNode {

	private Word wordHere;

	private TrieNode[] links;

	public TrieNode() {
		wordHere = null;
		links = new TrieNode[26];
	}

	//Convert a letter to a number
	private int let(char c) {
		return c - 'a';
	}

	private char firstChar(String key) {
		return key.charAt(0);
	}
	
	private String rest(String key) {
		return key.substring(1,key.length());
	}
	
	private TrieNode linkWordStart(String start) {
		return links[let(firstChar(start))];
	}

	public Word find(String key) {
		if (key.length() == 0) { // Handle end of word
			if (wordHere==null)
				return null;
			else return wordHere;
		}
		else {
			if (linkWordStart(key) == null)
				return null;
			else return linkWordStart(key).find(rest(key));
		}
	}

	public void insert(String key, String toHere) {
		if (key.length() == 0) { // Handle end of word
			if (wordHere == null)
				wordHere = new Word(toHere, 1);
			else wordHere.incrementCount();
		}
		else {
			if (linkWordStart(key) == null) // If no node exists for the current letter, make one
				links[let(firstChar(key))] = new TrieNode();
			linkWordStart(key).insert(rest(key), toHere + firstChar(key)); // Move to the next node
		}
	}

	public boolean anyKids() {
		for (TrieNode child : links) {
			if (child != null) {
				return true;
			}
		}
		return false;
	}

	public boolean delete(String key) {
		if (key.length() == 0) { // Reached the end of the word
			if (wordHere == null) // No word found: deletion unsuccessful
				return false;
			else {
				wordHere = null;
			}
		}
		else {
			if (linkWordStart(key) == null)
				return false;
			else {
				linkWordStart(key).delete(rest(key)); // Move inside next node
			}
		}
		// After deleting the word, delete any remaining references while 
		if (key.length() > 0) {
			if (!linkWordStart(key).anyKids() && wordHere == null) {
				links[let(firstChar(key))] = null;
			}
		}
		return true; // Deletion was successful!
	}

	public void allKeyValue(ArrayList<Word> v) {
		for (TrieNode child : links) { // Count up all key values of any existing child nodes
			if (child != null) {
				child.allKeyValue(v);
			}
		}
		if (wordHere != null) {
			v.add(wordHere);
		}
	}

	public void prefixMatch(ArrayList<Word> v, String start) {
		if (start.length() == 0) {
			allKeyValue(v);
		}
		else if (linkWordStart(start) != null) {
				linkWordStart(start).prefixMatch(v, rest(start));
		}

	}

	public void spellCheck1(ArrayList<Word> v, String start) {
		if (start.length() != 0) {
			if (linkWordStart(start) == null) {
				this.allKeyValue(v);
			}
			else {
				linkWordStart(start).spellCheck1(v, rest(start));
			}
		}
		else {
			if (wordHere != null) {
				v.add(wordHere);
			}
		}
	}

	public void gatherSuggestions(ArrayList<Word> ws, String key, int errs) {
		for (int i = 0; i < 26; i++) {
			if (i != let(firstChar(key)) && links[i] != null) {
				links[i].spellCheck2(ws, rest(key), errs);
			}
		}
	}

	public void spellCheck2(ArrayList<Word> ws, String key, int errs) {
		if (errs > 0) {
			if (key.length() == 0 && wordHere != null) {
				ws.add(wordHere);
			}
			else {
				if (linkWordStart(key) != null) {
					linkWordStart(key).spellCheck2(ws, rest(key), errs);
				}
				gatherSuggestions(ws, key, errs - 1);
			}
		}
	}

	public void print(String string) {
		if (wordHere != null)
			System.out.println(string+" "+wordHere);
		else System.out.println(string+" empty");
		for (int i =0; i<26; i++) {
			if (links[i]!=null){
				links[i].print(string+"-");
			}
		}
	}


}

