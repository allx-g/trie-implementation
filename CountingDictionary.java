/**
 * @author Alexander Guel
 */ 

import java.util.ArrayList;

public class CountingDictionary implements CS211CountingDictionaryInterface {
    Trie trie = new Trie();

    /**
     * Inserts a given word into the dictionary.
     * 
     * @param key the word to insert.
     */
    public void insert(String key) {
        trie.insert(key);
    }

    /**
     * Deletes the given word from the dictionary. Returns true if the item was
     * deleted and false if the word was not found and therefore couldn't be deleted.
     * 
     * @param key the word to delete.
     */
    public boolean delete(String key) {
        return trie.delete(key);
    }

    /**
     * Returns the number of occurrences of the given word. If not found, it returns -1.
     * 
     * @param key the word to find.
     */
    public int find(String key) {
        return trie.find(key);
    }

    /**
     * Returns a list of all the words in the dictionary and the counts of each.
     */
    public ArrayList<Word> allKeyValue() {
        return trie.allKeyValue();
    }

    /**
     * Returns a list of all the words which match the given prefix.
     * 
     * @param s the prefix to match.
     */
    public ArrayList<Word> prefixMatch(String s) {
        return trie.prefixMatch(s);
    }

    /**
     * If the word does not exist in the dictionary, spellCheck returns
     * a list of all words that have some portion of the mispelled word.
     * 
     * @param aword the word to spell-check.
     */
    public ArrayList<Word> spellCheck1(String aword) {
        return trie.spellCheck1(aword);
    }

    /**
     * Returns a list of all words that match the word up to a certain number
     * of errors. For example, "errkr" with a maxDistance of 1 might output
     * "error" as part of the list since it has a one character difference to
     * the given word.
     * 
     * @param target the word to spell-check.
     * @param maxDistance the number of errors a suggested word is allowed to have.
     */
    public ArrayList<Word> spellCheck2(String target, int maxDistance) {
        return trie.spellCheck2(target, maxDistance);
    }
}
