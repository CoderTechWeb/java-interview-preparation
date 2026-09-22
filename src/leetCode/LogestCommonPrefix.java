package leetCode;

public class LogestCommonPrefix {

    static void main(String[] args) {
        String[] inputs = {"flower","flow","flight"};
        System.out.println(commonPrefix(inputs));

    }

    public static String commonPrefix(String[] words) {
        if (words == null || words.length == 0) return "";

        String prefix = words[0];

        for (int i = 1; i < words.length; i++) {
            while (!words[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }
}
