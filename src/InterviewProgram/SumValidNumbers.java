package InterviewProgram;

//Given a list of strings representing numbers (some invalid), write a method that sums all valid integers, skips invalid ones
// (catch NumberFormatException), and returns the total without stopping on bad input.

//sumValidNumbers(["10", "abc", "20", "xyz", "5"])
public class SumValidNumbers {

    static void main(String[] args) {
        String[] arr = {"10", "abc", "20", "xyz", "5"};
        int sum = 0;

        for (String a:arr){
            try {
                sum += Integer.parseInt(a);
            } catch(NumberFormatException e){

            }
        }
        System.out.println(sum);
    }
}
