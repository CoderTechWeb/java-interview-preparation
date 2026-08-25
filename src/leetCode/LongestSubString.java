package leetCode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */
public class LongestSubString {

    public static int longestNonRepeatedString(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int maxLength = 0;

        for(int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            while(set.contains(current)) {
               set.remove(s.charAt(start));
               start++;
            }

            set.add(current);
            maxLength = Math.max(maxLength, end-start+1);
        }

        return maxLength;
    }

    static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestNonRepeatedString(s));
    }
}
