package leetCode;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2= {2,5,6};
        int m= 3, n = 3;

        int i = m - 1;
        int j = n -1;
        int k = m + n - 1;

        while(j >= 0) {
            if(i >= 0 && num1[i] > num2[j]){
                num1[k] = num1[i];
                i--;
            } else {
                num1[k] = num2[j];
                j--;
            }
            k--;
        }

        Arrays.stream(num1).forEach(System.out::println);
        System.out.println(num1);
    }
}
