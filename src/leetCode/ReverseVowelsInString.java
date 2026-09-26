package leetCode;

public class ReverseVowelsInString {

    static void main(String[] args) {
        String str = "Rohit Sharma";
        //output = RAHAT SHIRMO

        char[] strChar = str.toCharArray();
        int start = 0;
        int end = str.length()-1;
        boolean firstVowel = false;
        boolean secondVowel = false;

        while (start < end){
            if(strChar[start] == 'a' || strChar[start] == 'e' || strChar[start] == 'i' ||  strChar[start] == 'o' ||  strChar[start] == 'u' ) {
                firstVowel = true;
            }

            if(strChar[end] == 'a' || strChar[end] == 'e' || strChar[end] == 'i' ||  strChar[end] == 'o' ||  strChar[start] == 'u') {
                secondVowel = true;
            }

            if(firstVowel && secondVowel) {
                char temp = strChar[end];
                strChar[end] = strChar[start];
                strChar[start] = temp;
                firstVowel = false;
                secondVowel = false;
            }

            if(!firstVowel) {
                start++;
            }

            if(!secondVowel) {
                end--;
            }
        }

        for(char ch:strChar) {
            System.out.print(ch);
        }

    }
}