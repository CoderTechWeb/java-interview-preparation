package InterviewProgram;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Problem Statement:
 *
 * Given an integer array, find all values that appear more than once
 * and return their index and value for every repeated occurrence.
 *
 * Example:
 *
 * Input:
 * arr = {1, 2, 3, 1, 3}
 *
 * Output:
 * [[3, 1], [4, 3]]
 *
 * Explanation:
 * - Value 1 appears again at index 3
 * - Value 3 appears again at index 4
 *
 * Note:
 * - Array index is 0-based.
 * - Each result is represented as {index, value}.
 *
 * Approach:
 * - Use a HashSet to keep track of values already encountered.
 * - Set.add() returns false when the value already exists.
 * - Use IntStream.range() to stream the array indices.
 */
public class FindRepeatedValuesAndIndices {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 3};

        Set<Integer> set = new HashSet<>();

        List<int[]> result = IntStream.range(0, arr.length)
                // Keep only values that have already been seen
                .filter(i -> !set.add(arr[i]))
                // Create {index, value}
                .mapToObj(i -> new int[]{i, arr[i]})
                .collect(Collectors.toList());

        // Print the result
        result.forEach(a -> System.out.println(Arrays.toString(a)));
    }
}