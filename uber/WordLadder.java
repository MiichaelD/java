/**
 Problem:		WordLadder.java
 
 Links:			https://en.wikipedia.org/wiki/Word_ladder
 				https://leetcode.com/problems/word-ladder/
 
 Description:	Given two words (beginWord and endWord), and a dictionary's word list, find the length
 of shortest transformation sequence from beginWord to endWord, such that:

	-Only one letter can be changed at a time
	-Each intermediate word must exist in the word list
	
For example, given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	
As there are 2 possible shortest transformations: ["hit" -> "hot" -> "dot" -> "dog" -> "cog"] and ["hit" -> "hot" -> "lot" -> "log" -> "cog"]
return its length: 5.

Note:		Return 0 if there is no such transformation sequence.
			All words have the same length.
			All words contain only lowercase alphabetic characters.
 */
import java.util.*;
public class WordLadder {

	boolean checkIfMatch(char[] start, String end){
		for (int i = 0; i < start.length; ++i){
			if (start[i] != end.charAt(i))
				return false;
		}
		return true;
	}
	
	class ChangeStep implements Comparable<ChangeStep>{
		String word;
		int charChanged;
		
		public ChangeStep(String word, int charIndexChanged){
			this.word = word;
			this.charChanged = charIndexChanged;
		}

		public int compareTo(ChangeStep o) {
			return word.compareTo(o.word);
		}
		
		public boolean equals(ChangeStep o){
			return word.equals(o.word);
		}
		
		public boolean equals(String s){
			return word.equals(s);
		}
	};
	
	boolean doesStackHasChange(Stack<ChangeStep> stack, ChangeStep newChange){
		for (ChangeStep change : stack){
			if (change.equals(newChange))
				return true;
		}
		return false;
	}
	
	
	Stack<ChangeStep> minimumSteps(String start, String end, HashSet<String> dictionary){
		Stack<ChangeStep> possibleChanges = new Stack<ChangeStep>();
		
		if (start == null || end == null || start.length() != end.length())
			return possibleChanges; // not possible to get to end;
		
		
		String newWord = start;
		char[] startArray = start.toCharArray();
		boolean changed = true;
		while (newWord.equals(end) == false && changed){
			changed = false;
			for (int charIndex = 0 ; charIndex < start.length(); ++charIndex){
				char letterToReplace = startArray[charIndex];
				int previousStackSize = possibleChanges.size();
				for (char replaceChar = 'a' ; replaceChar <= 'z'; ++replaceChar){
					
					//don't replace the letter we are changing with the same letter
					if (replaceChar == letterToReplace)
						continue; 

					//check if we can substitute charIndex character with any other letter;
					startArray[charIndex] = replaceChar;
					ChangeStep change = new ChangeStep(new String(startArray), charIndex);
					
					if (change.equals(end))
						return possibleChanges;
					
					//check if this new word is in the dictionary.
//					System.out.println("checking word: "+change.word);
					if (dictionary.contains(change.word) && !doesStackHasChange(possibleChanges, change)){
						changed = true;
						possibleChanges.push(change);
						//check again.
						charIndex = -1;
						newWord = change.word;
						break;
					}
				}
				if (possibleChanges.size() == previousStackSize){
					//return the string as it used to be;
					startArray[charIndex] = letterToReplace;
				}
			}
		}
		
		return possibleChanges;
	} 
	
	void firstSolution(String start, String end, HashSet<String> dictionary){
		//This doesn't give the optimal solution yet, it needs to be tuned.
		Stack<ChangeStep> stack = minimumSteps(start, end, dictionary);
		System.out.printf("Shortest path: %d. ",stack.size()+2);
		if (!stack.isEmpty()){
			System.out.print(start + " -> ");
			for (ChangeStep cs : stack){
				System.out.printf(cs.word + " -> ");
			}
			System.out.println(end);
		}
	}
	
	void optimalSolution(String start, String end, HashSet<String> dictionary){
		// TODO: This solution can be computed using trees, but due the time constraint
		// I only did the brute force solution during the interview.
	}
	
	public static void main(String args[]){
		HashSet<String> dictionary = new HashSet<String>();
		dictionary.add("hot");
		dictionary.add("dot");
		dictionary.add("dog");
		dictionary.add("lot");
		dictionary.add("log");
		
		String start = "hit";
		String end = "cog";
		WordLadder wl = new WordLadder();
		wl.firstSolution(start, end, dictionary);
		
	}
}
