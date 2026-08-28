package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class GroupAnagram {

    static void main() {
        String[] arrays = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String arr : arrays) {
            char[] charArray = arr.toCharArray();
            Arrays.sort(charArray);

            String key = Arrays.toString(charArray);
            map.computeIfAbsent(key,  k -> new ArrayList<>()).add(arr);
        }

        System.out.println(map.values());
    }

}
