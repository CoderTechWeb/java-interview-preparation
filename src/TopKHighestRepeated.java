import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKHighestRepeated {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,1,2,2,3,4,4,4,4);
        int k = 2;
        getTopKHigestCount(list, k);
    }

    public static void getTopKHigestCount(List<Integer> list, int k) {
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));

        List<Integer> result = map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed()).limit(k).map(Map.Entry::getKey).toList();
        result.forEach(System.out::println);
    }
}
