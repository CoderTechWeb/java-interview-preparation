package leetCode;

import java.util.List;
import java.util.Arrays;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubarray {

    static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};
        int cur = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i<arr.length; i++){
            cur = Math.max( arr[i], cur+arr[i]);
            maxSum=Math.max(cur, maxSum);
        }
        System.out.println(maxSum);
    }
}
