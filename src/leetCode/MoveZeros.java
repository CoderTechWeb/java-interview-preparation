package leetCode;

import java.util.Arrays;

public class MoveZeros {
    static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        int writeIndex = 0;

        for(int i = 0 ; i<arr.length; i++) {
            if(arr[i]!=0){
                arr[writeIndex] = arr[i];
                writeIndex++;
            }
        }

        while (writeIndex < arr.length){
            arr[writeIndex++] = 0;
        }

        System.out.println(arr);
    }
}
