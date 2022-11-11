package com.dsa.trie;

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode(); // root is empty
	}

	private class TrieNode {
		private TrieNode[] children;
		private boolean isWord;

		public TrieNode() {
			this.children = new TrieNode[26]; // storing english words - a -> z this.isWord = false;
		}
	}

	// Refer
	// https://www.youtube.com/watch?v=I6i4AyDsMQA&list=PL6Zs6LgrJj3uwRyATdtSua12k9EFQIW50&index=6
	// https://github.com/dinesh-varyani/ds-algos/blob/master/src/com/hubberspot/dsalgo/trie/Trie.java
	// https://www.geeksforgeeks.org/trie-insert-and-search/
	public void insert(String word) {
		if (word == null || word.isEmpty()) {
			throw new IllegalArgumentException("Invalid input");
		}

		word = word.toLowerCase();

		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (currentNode.children[index] == null) {
				TrieNode newNode = new TrieNode();
				currentNode.children[index] = newNode;
				currentNode = newNode;
			} else {
				currentNode = currentNode.children[index];
			}
		}
		currentNode.isWord = true;
	}

	// Refer
	// https://www.youtube.com/watch?v=soJgGe1CQHw
	// https://www.enjoyalgorithms.com/blog/introduction-to-trie-data-structure
	// https://www.javatpoint.com/trie-data-structure
	// https://www.geeksforgeeks.org/trie-insert-and-search/
	public boolean search(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (currentNode.children[c - 'a'] == null) {
				return false;
			}
			currentNode = currentNode.children[c - 'a'];
		}
		return currentNode.isWord;
	}

	// Refer
	// https://www.youtube.com/watch?v=T1M52UqQq3c
	// https://www.youtube.com/watch?v=BN-SUKeOYC0
	public boolean startsWith(String prefix) {
		TrieNode ws = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (ws.children[c - 'a'] == null)
				return false;
			ws = ws.children[c - 'a'];
		}
		return true;
	}

	// Refer
	// https://www.youtube.com/watch?v=p4kfbNJzftQ
	// https://www.enjoyalgorithms.com/blog/introduction-to-trie-data-structure
	// https://www.javatpoint.com/trie-data-structure
	// https://www.geeksforgeeks.org/trie-delete/
	public void delete(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			if (currentNode.children[c - 'a'] == null) {
				return;
			}
			currentNode = currentNode.children[c - 'a'];
		}
		currentNode.isWord = false;
	}

	// https://github.com/PengFTang/Data-Structures-in-Java/blob/master/Tree/Trie.java
	public static void printAllWordsInTrie(TrieNode root, String s) {

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("cat");
		trie.insert("cab");
		trie.insert("son");
		trie.insert("so");
		System.out.println("Values inserted successfully !!!");
	}
}
