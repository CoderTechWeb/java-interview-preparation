package leetCode.todo;

import java.util.*;

public class FindMissingNumber {

    static void main(String[] args) {

        int[] arr = {4,6,13,2,6,8,10};
       // Output = [3,5,7,9,11,12]

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        int next = arr[0] + 1;
        for(int i = 1; i < arr.length; i++){
            while(arr[i] != next){
                list.add(next);
                ++next;
            }
        }
        System.out.println(list);
    }
}
