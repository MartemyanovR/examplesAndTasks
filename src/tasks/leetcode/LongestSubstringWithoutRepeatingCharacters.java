package tasks.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Stream;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String str = "";
		HashSet<Character> strSet = new HashSet<>();
		ArrayList<Integer> arrList = new ArrayList<>();
		
		for (int i = 0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(!strSet.contains(c)) {
				strSet.add(c);
				System.out.println(strSet);
			} else {
				arrList.add(strSet.size());
				strSet.clear();
				while(c != str.charAt(--i) && i > -1) {}
				
			}			
		}
		arrList.add(strSet.size());
		System.out.println(arrList);
		System.out.println(Collections.max(arrList));
		
	}

}
