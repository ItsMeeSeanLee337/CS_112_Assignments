package trie;

import java.util.ArrayList;

/**
 * This class implements a Trie. 
 * 
 * @author Sesh Venugopal
 *
 */
public class Trie {
	
	// prevent instantiation
	private Trie() { }
	
	/**
	 * Builds a trie by inserting all words in the input array, one at a time,
	 * in sequence FROM FIRST TO LAST. (The sequence is IMPORTANT!)
	 * The words in the input array are all lower case.
	 * 
	 * @param allWords Input array of words (lowercase) to be inserted.
	 * @return Root of trie with all words inserted from the input array
	 */
	public static TrieNode buildTrie(String[] allWords) 
	{
		TrieNode root = new TrieNode(null, null, null);
		if (allWords.length == 0)
		{
			return root;
		}
		root.firstChild = new TrieNode(new Indexes(0, (short) (0), (short) (allWords[0].length() - 1)), null, null);
		TrieNode pointer = root.firstChild;
		TrieNode last = root.firstChild;
		int similarUpTo = -1;
		int startIndex = -1;
		int endIndex = -1;
		int wordIndex = -1;
		for(int index = 1; index < allWords.length; index++) 
		{
			String word = allWords[index];
			while(pointer != null) 
			{
				startIndex = pointer.substr.startIndex;
				endIndex = pointer.substr.endIndex;
				wordIndex = pointer.substr.wordIndex;
				if(startIndex > word.length()) 
				{
					last = pointer;
					pointer = pointer.sibling;
					continue;
				}
				int upTo = 0;
				while(upTo < allWords[wordIndex].substring(startIndex, endIndex + 1).length() && upTo < word.substring(startIndex).length() && allWords[wordIndex].substring(startIndex, endIndex + 1).charAt(upTo) == word.substring(startIndex).charAt(upTo))
				{
					upTo++;
				}
				similarUpTo = (upTo-1);
				if(similarUpTo != -1)
				{
					similarUpTo += startIndex;
				}
				if(similarUpTo == -1) 
				{
					last = pointer;
					pointer = pointer.sibling;
				}
				else 
				{
					if(similarUpTo == endIndex) 
					{
						last = pointer;
						pointer = pointer.firstChild;
					}
					else if (similarUpTo < endIndex)
					{
						last = pointer;
						break;
					}
				}
			}
			if(pointer == null)
			{
				Indexes indexes = new Indexes(index, (short)startIndex, (short)(word.length() - 1));
				last.sibling = new TrieNode(indexes, null, null);
			} 
			else 
			{
				Indexes currIndexes = last.substr;
				TrieNode currFirstChild = last.firstChild;
				Indexes currWordNewIndexes = new Indexes(currIndexes.wordIndex, (short)(similarUpTo + 1), currIndexes.endIndex);
				currIndexes.endIndex = (short)similarUpTo;
				last.firstChild = new TrieNode(currWordNewIndexes, null, null);
				last.firstChild.firstChild = currFirstChild;
				last.firstChild.sibling = new TrieNode(new Indexes((short)index, (short)(similarUpTo + 1), (short)(word.length() - 1)), null, null);
			}
			pointer = root.firstChild;
			last = root.firstChild;
			similarUpTo = -1;
			startIndex = -1;
			endIndex = -1;
			wordIndex = -1;
		}
		return root;
	}
	
	/**
	 * Given a trie, returns the "completion list" for a prefix, i.e. all the leaf nodes in the 
	 * trie whose words start with this prefix. 
	 * For instance, if the trie had the words "bear", "bull", "stock", and "bell",
	 * the completion list for prefix "b" would be the leaf nodes that hold "bear", "bull", and "bell"; 
	 * for prefix "be", the completion would be the leaf nodes that hold "bear" and "bell", 
	 * and for prefix "bell", completion would be the leaf node that holds "bell". 
	 * (The last example shows that an input prefix can be an entire word.) 
	 * The order of returned leaf nodes DOES NOT MATTER. So, for prefix "be",
	 * the returned list of leaf nodes can be either hold [bear,bell] or [bell,bear].
	 *
	 * @param root Root of Trie that stores all words to search on for completion lists
	 * @param allWords Array of words that have been inserted into the trie
	 * @param prefix Prefix to be completed with words in trie
	 * @return List of all leaf nodes in trie that hold words that start with the prefix, 
	 * 			order of leaf nodes does not matter.
	 *         If there is no word in the tree that has this prefix, null is returned.
	 */
	public static ArrayList<TrieNode> completionList(TrieNode root, String[] allWords, String prefix) 
	{
		if(root == null) 
		{
			return null;
		}
		ArrayList<TrieNode> matches = new ArrayList<>();
		TrieNode pointer = root;
		while(pointer != null) 
		{
			if(pointer.substr == null)
			{
				pointer = pointer.firstChild;
			}
			String s = allWords[pointer.substr.wordIndex];
			String a = s.substring(0, pointer.substr.endIndex+1);
			if(s.startsWith(prefix) || prefix.startsWith(a)) 
			{
				if(pointer.firstChild != null) 
				{
					matches.addAll(completionList(pointer.firstChild, allWords, prefix));
					pointer = pointer.sibling;
				} 
				else 
				{
					matches.add(pointer);
					pointer = pointer.sibling;
				}
			} 
			else 
			{
				pointer = pointer.sibling;
			}
		}
		if (matches.isEmpty() == true)
		{
			return null;
		}
		else
		{
			return matches;
		}
	}
	
	public static void print(TrieNode root, String[] allWords) {
		System.out.println("\nTRIE\n");
		print(root, 1, allWords);
	}
	
	private static void print(TrieNode root, int indent, String[] words) {
		if (root == null) {
			return;
		}
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		
		if (root.substr != null) {
			String pre = words[root.substr.wordIndex]
							.substring(0, root.substr.endIndex+1);
			System.out.println("      " + pre);
		}
		
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		System.out.print(" ---");
		if (root.substr == null) {
			System.out.println("root");
		} else {
			System.out.println(root.substr);
		}
		
		for (TrieNode ptr=root.firstChild; ptr != null; ptr=ptr.sibling) {
			for (int i=0; i < indent-1; i++) {
				System.out.print("    ");
			}
			System.out.println("     |");
			print(ptr, indent+1, words);
		}
	}
 }
