package leetCode;

import java.util.Locale;

public class Palidrome {
    //amanaplanacanalpanama
    //A man, a plan, a canal: Panama
    static void main() {
        String str = "madam";

        System.out.println(isPalidrome(str));

        //ignoring case and non-alphanumeric characters
        String speChar = "A man, a 1plan, a canal: Panama";
        System.out.println(isPalidromeNonAlpaChar(speChar));
    }

    static boolean isPalidromeNonAlpaChar(String str) {
        int left = 0;
        int right = str.length() - 1;

        char[] strChar = str.toLowerCase().toCharArray();

        while(left < right) {
            while( left < right && !Character.isLetterOrDigit(strChar[left])) left++;
            while(left < right && !Character.isLetterOrDigit(strChar[right])) right--;

            if(strChar[left] != strChar[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalidrome(String str){
        int left = 0;
        int right = str.length()-1;

        while(left <right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
