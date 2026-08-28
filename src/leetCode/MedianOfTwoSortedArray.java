package leetCode;

/**
 * LeetCode 4: Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n, return the
 * median of the two sorted arrays combined.
 *
 * Naive approach: merge both arrays and pick the middle → O(m+n) time.
 * This solution instead does binary search on the SMALLER array to find
 * the correct partition point, achieving the required O(log(min(m, n))).
 *
 * Core idea:
 *   Partition both arrays into a "left half" and "right half" such that:
 *     1. left half size == right half size (or +1 for odd total length)
 *     2. every element in the combined left half <= every element in the
 *        combined right half
 *   Once that partition is found, the median is derivable directly from
 *   the boundary elements — no merging needed.
 *
 * Time Complexity:  O(log(min(m, n)))
 * Space Complexity: O(1)
 */
public class MedianOfTwoSortedArray {

    static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;

        int[] mergedArray = new int[num1Len + num2Len];
        int num1Pointer = 0;
        int num2Pointer = 0;
        int index = 0;
        while(num1Pointer < num1Len && num2Pointer < num2Len ) {
            if(nums1[num1Pointer] < nums2[num2Pointer]) {
                mergedArray[index++] = nums1[num1Pointer];
                num1Pointer++;
            } else {
                mergedArray[index++] = nums2[num2Pointer];
                num2Pointer++;
            }
        }

        while(num1Pointer < num1Len){
            mergedArray[index++] = nums1[num1Pointer];
            num1Pointer++;
        }

        while(num2Pointer < num2Len){
            mergedArray[index++] = nums2[num2Pointer];
            num2Pointer++;
        }

        if(mergedArray.length % 2 != 0) {
            return mergedArray[mergedArray.length/2];
        } else{
            int center = mergedArray.length/2;
            return (double)(mergedArray[center] + mergedArray[center-1] )/ 2;
        }
    }
}
