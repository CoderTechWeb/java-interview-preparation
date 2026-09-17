package InterviewProgram;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class sortByOccurence {
    static void main(String[] args) {
        int[] n = {1, 3,2, 1, 3, 5, 3,2,1, 1,2, 5,4};

        //Using stream
       /* Map<Integer, Long> collect = Arrays.stream(n).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> list = collect.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey).toList();
        System.out.println(list);*/

        Map<Integer, Integer> map = new HashMap<>();

        for(int i:n){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        ArrayList<Integer> result = new ArrayList<>(map.keySet());
        result.sort((a,b)->map.get(b) - map.get(a));
        System.out.println(result);

    }
}
