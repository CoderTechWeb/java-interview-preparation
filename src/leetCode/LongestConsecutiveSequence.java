package leetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {

    static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max = Math.max(max, count);

            }
        }
        System.out.println(max);
    }
}