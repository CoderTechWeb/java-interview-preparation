package InterviewProgram;

import java.util.*;
import java.util.stream.Collectors;

public class TopKHighestRepeated {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 1, 2, 2, 3, 4, 4, 4, 4);
        int k = 2;
        getTopKHigestCountWithoutStream(list, k);
    }

    public static void getTopKHigestCount(List<Integer> list, int k) {
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        List<Integer> result = map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(k).map(Map.Entry::getKey).toList();
        result.forEach(System.out::println);
    }

    public static void getTopKHigestCountWithoutStream(List<Integer> list, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : list) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);
        result.forEach(System.out::println);
    }
}
