package leetCode;

import java.util.Arrays;

public class IsAnagram {

    static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        System.out.println(isAnagram.checkIsAnagaram1("listen", "silent"));
    }

    public boolean checkIsAnagaram1(String first, String second) {
        if(first == null || second == null || first.length() != second.length()) return  false;

        int[] freq = new int[27];

        for(int i = 0; i < first.length(); i++){
            freq[first.charAt(i) - 'a']++;
            freq[second.charAt(i) - 'a']--;
        }

        for(int count : freq){
            if(count!=0) return false;
        }

        return true;
    }
    public boolean checkIsAnagram(String first, String second) {
        if(first == null || second == null || first.length() != second.length()) return  false;


        char[] firstCh = first.toCharArray();
        char[] secondCh = second.toCharArray();

        Arrays.sort(firstCh);
        Arrays.sort(secondCh);

        return Arrays.equals(firstCh, secondCh);
    }
}
