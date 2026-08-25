package leetCode;

/**
 * LeetCode 2: Add Two Numbers
 *
 * Given two non-empty linked lists representing two non-negative integers,
 * with digits stored in reverse order (least significant digit first),
 * add the two numbers and return the sum as a linked list in the same format.
 *
 * Example:
 *   l1 = 2 -> 4 -> 3   (represents 342)
 *   l2 = 5 -> 6 -> 9   (represents 965)
 *   result = 7 -> 0 -> 1 -> 1   (represents 1307)
 *
 * Time Complexity:  O(max(m, n)) where m, n are lengths of l1 and l2
 * Space Complexity: O(max(m, n)) for the result list
 */
public class AddTwoNumberLinkedList {

    static class LinkedList{
        int val;
        LinkedList next;

        LinkedList(){

        }

        LinkedList(int val){
            this.val = val;
        }

        LinkedList(int val, LinkedList next) {
            this.val = val;
            this.next = next;
        }
    }

    public LinkedList addTwoNumber(LinkedList l1, LinkedList l2) {
        LinkedList result = new LinkedList();
        LinkedList curr = result;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int sum = l1Val + l2Val + carry;
            int val = sum % 10;
            carry = sum / 10;

            curr.next = new LinkedList(val);
            curr = curr.next;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return  result.next;
    }

    static void main(String[] args) {
        AddTwoNumberLinkedList twoNumber = new AddTwoNumberLinkedList();
        LinkedList l1 = new LinkedList(2, new LinkedList(4, new LinkedList(3)));
        LinkedList l2 = new LinkedList(5, new LinkedList(6, new LinkedList(9)));
        LinkedList linkedList = twoNumber.addTwoNumber(l1, l2);
        while (linkedList != null){
            System.out.println(linkedList.val);
            linkedList = linkedList.next;
        }
    }
}
