package ch_1_arrays_and_strings;

import java.util.*;

public class Test {

	/* 1.1 */

	/*-public static void main(String[] args) {
		String[] words = { "abcde", "hello", "apple", "kite", "padle" };
		for (String word : words) {
			boolean wordA = isUniqueChars_A(word);
			boolean wordB = isUniqueChars_B(word);
			boolean wordmy = isUniqueChars_my(word);
			System.out.println(word + ": " + wordA);
		}
	}*/

	public static boolean isUniqueChars_B(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';

			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static boolean isUniqueChars_A(String str) {
		if (str.length() > 128)
			return false;
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) { // already found in the char string
				return false;
			} else {
				char_set[val] = true;
			}
		}
		return true;
	}

	public static boolean isUniqueChars_my(String str) {

		if (str.length() < 2)
			return true;
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				return false;
			else
				set.add(str.charAt(i));
		}
		return true;

	}

	/* 1.2 */

	/*-public static void main(String[] args) {
		String[][] pairs = { { "apple", "papel" }, { "carrot", "tarroc" }, { "hello", "llloh" } };
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation_B(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}*/

	public static boolean permutation_B(String s, String t) {
		if (s.length() != t.length())
			return false; // Permutations must be same length

		int[] letters = new int[128]; // Assumption: ASCII

		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}

		}
		return true; // letters array has no negative values, and therefore no
						// positive values either
	}

	public static String sortStr(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public static boolean permutation_A(String s, String t) {

		return sortStr(s).equals(sortStr(t));
	}

	/* 1.3 */
	public static void main(String[] args) {
		String str = "Mr John Smith    ";
		char[] arr = str.toCharArray();
		int trueLength = findLastCharacter(arr) + 1;
		replaceSpaces(arr, trueLength);
		System.out.println("\"" + new String(arr) + "\"");
	}

	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int trueLength) {
		int spaceCount = 0, index = 0, i = 0;
		for (i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if (trueLength < str.length)
			str[trueLength] = '\0';
		for (i = trueLength - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index = index - 3;
			} else {
				str[index - 1] = str[i];
				index--;
			}
		}
	}

	public static int findLastCharacter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i;
			}
		}
		return -1;
	}

}
