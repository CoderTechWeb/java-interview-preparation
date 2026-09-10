package InterviewProgram;

import java.util.Arrays;

public class MaxProdByNNumber {

    static void main(String[] args) {
        int[] n = {1, 2, 3, 2, 5, 4, -1, -2};

        Arrays.sort(n);
        int prod = 1;
        int len = n.length - 1;
        for (int i = 0; i < 3; i++) {
            prod *= n[len--];
        }
        System.out.println(prod);

        //Using stream
       // Integer reduce = Arrays.stream(n).boxed().sorted(Collections.reverseOrder()).limit(3).reduce(1, (a, b) -> a * b);
        //System.out.println(reduce);
    }
}
