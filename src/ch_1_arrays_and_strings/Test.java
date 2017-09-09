package ch_1_arrays_and_strings;

import java.util.*;

public class Test {

	/* 1.1 */

	public static void main(String[] args) {
		String[] words = { "abcde", "hello", "apple", "kite", "padle" };
		for (String word : words) {
			boolean wordA = isUniqueChars_A(word);
			boolean wordB = isUniqueChars_B(word);
			boolean wordmy = isUniqueChars_my(word);
			System.out.println(word + ": " + wordA);
		}
	}

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

}
