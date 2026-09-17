package InterviewProgram;

import java.util.HashMap;
import java.util.Map;

public class Test {

    static void main(String[] args) {
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1 == s2);
        Map<String, Integer> map = new HashMap<>();
        map.put(s1, 1);
        //map.put(s2, 2);
        System.out.println(map.get(s2));
    }
}
