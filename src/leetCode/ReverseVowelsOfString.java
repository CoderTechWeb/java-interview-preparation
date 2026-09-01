package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 *
 * Input: s = "IceCreAm"
 * Output: "AceCreIm"
 */
public class ReverseVowelsOfString {

    public static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    static void main(String[] args) {
        String s = "IceCreAm";
        int left = 0;
        int right = s.length() - 1;
        char[] ch = s.toCharArray();

        while(left < right) {
            while (left < right && !vowels.contains(ch[left])) left++;
            while (left < right && !vowels.contains(ch[right])) right--;

            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;

            left++;
            right--;
        }

        System.out.println(new String(ch));
    }
}
