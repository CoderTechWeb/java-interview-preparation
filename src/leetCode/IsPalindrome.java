package leetCode;

public class IsPalindrome {

    static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.checkIfPalidrome("A man, a plan, a canal: Panama"));
    }

    public boolean checkIfPalidrome(String str) {
        int left = 0, right = str.length() - 1;
        char[] ch = str.toCharArray();
        while(left < right) {
            while( left < right && !Character.isLetterOrDigit(ch[left])) left++;
            while (left < right && !Character.isLetterOrDigit(ch[right])) right--;

            if(Character.toLowerCase(ch[left]) == Character.toLowerCase(ch[right]))
            {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
