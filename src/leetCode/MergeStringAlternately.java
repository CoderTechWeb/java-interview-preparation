package leetCode;

public class MergeStringAlternately {

    static void main(String[] args) {
        MergeStringAlternately msa = new MergeStringAlternately();
        System.out.println(msa.mergeAlternately("abc", "defghi"));

    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int word1Len = word1.length();
        int word2Len = word2.length();
        while(i < word1Len || i < word2Len) {
            if (i < word1Len) {
                sb.append(word1.charAt(i));
            }

            if(i < word2Len) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}
