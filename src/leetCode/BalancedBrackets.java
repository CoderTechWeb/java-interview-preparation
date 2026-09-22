package leetCode;

import java.util.*;

public class BalancedBrackets {

    static void main(String[] args) {
        String[] inputs = {"[{]", "[{}]", "{{]]", "{}[]"};
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        System.out.println(balancedBrackets.check(inputs));
    }

    public List<Boolean> check(String[] inputs) {
        List<Boolean> res = new ArrayList<>();

        for (String input : inputs){
            res.add(isBalanced(input));
        }
        return res;
    }

    private boolean isBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(']','[', '}', '{', ')', '(');

        for(char ch:input.toCharArray()) {
            if(ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if(map.containsKey(ch)) {
                if(stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
