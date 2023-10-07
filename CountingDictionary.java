/**
 * @author Alex Guel
 */ 

import java.util.ArrayList;

public class CountingDictionary implements CS211CountingDictionaryInterface {
    Trie trie = new Trie();

    public void insert(String key) {
        trie.insert(key);
    }

    public boolean delete(String key) {
        return trie.delete(key);
    }

    public int find(String key) {
        return trie.find(key);
    }

    public ArrayList<Word> allKeyValue() {
        return trie.allKeyValue();
    }

    public ArrayList<Word> prefixMatch(String s) {
        return trie.prefixMatch(s);
    }

    public ArrayList<Word> spellCheck1(String aword) {
        return trie.spellCheck1(aword);
    }

    public ArrayList<Word> spellCheck2(String target, int maxDistance) {
        return trie.spellCheck2(target, maxDistance);
    }
}
