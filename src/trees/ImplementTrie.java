package trees;

import java.util.HashMap;

/*
 * Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. 
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:
Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:
Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]
Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */

public class ImplementTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		System.out.println(trie.search("app"));
	}

}

class Trie {
	
	class Node {
		Node children[] = new Node[26];
		boolean eow = false;
		
		public Node() {
			for (int i=0; i<26; i++) {
				children[i] = null;
			}
		}
	}
	
	public Node root = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
    	Node curr = root;
    	
    	for (int level=0; level<word.length(); level++) {
    		int idx = word.charAt(level) - 'a';
    		if (curr.children[idx] == null) {
    			curr.children[idx] = new Node();
    		}
    		curr = curr.children[idx];
    	}
    	curr.eow = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for (int level=0; level<word.length(); level++) {
        	int idx = word.charAt(level) - 'a';
        	if (curr.children[idx] == null) {
        		return false;
        	}
        	curr = curr.children[idx];
        }
        
        return curr.eow == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for (int level=0; level<prefix.length(); level++) {
        	int idx = prefix.charAt(level) - 'a';
        	if (curr.children[idx] == null) {
        		return false;
        	}
        	curr = curr.children[idx];
        }
        
        return true;
    }
}
