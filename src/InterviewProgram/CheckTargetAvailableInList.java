package InterviewProgram;

import java.util.*;

public class CheckTargetAvailableInList {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(31, 26, 20, 1, -10, -99);
        int target = -10;
        System.out.println(checkTargetAvailableInList(arr, target));
    }

    public static int checkTargetAvailableInList(List<Integer> arr, int target){
        for(int a:arr) {
            if (a == target) {
                return a;
            }
        }
        return -1;
    }
}