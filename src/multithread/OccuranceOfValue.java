package multithread;

import java.util.Arrays;

/**
 * Given an integer array and a target digit, find the number of elements
 * in the array where the target digit occurs exactly once.
 *
 * Input:
 * arr = {3, 12, 23, 33, 44}
 * target = 3
 *
 * Output:
 * 2
 *
 *  Explanation:
 *  3  -> target occurs once
 *  23 -> target occurs once
 *  33 -> target occurs twice, so exclude it
 *  12 -> target not present
 *  44 -> target not present
 */
public class OccuranceOfValue {

    static void main(String[] args) {
        int[] arr= {3, 12, 23, 33, 44};
        System.out.println(countOccurance(arr, String.valueOf("3")));

        //Using Stream
        long count = Arrays.stream(arr).mapToObj(String::valueOf)
                .filter(s->s.chars()
                        .filter(c -> c=='3')
                        .count() == 1).count();
    }

    static int countOccurance(int[] arr, String val) {
        int res = 0;
        for(int num:arr){
            String s = String.valueOf(num);
            int i = s.indexOf(val);
            if(i != -1 && i == s.lastIndexOf(val)){
                res++;
            }
        }
        return res;
    }
}
