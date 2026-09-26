package InterviewProgram;

public class GetSumofTwoByFirstAndLastDigit {

    //Given A = [405, 45, 300, 300], the function should return 600.
    //There are two pairs of integers that share first and last digits: (405, 45) and (300, 300). The sum of the two 300s is bigger than the sum of 405 and 45.

    static void main(String[] args) {
        //int[] numbers = {405, 45, 300, 300};
        int[] numbers = {30, 909, 3190, 99, 3990, 9009};
        System.out.println(getPairSum(numbers));
    }

    public static double getPairSum(int[] numbers) {
        int maxSum = -1;
        for(int i =0 ; i < numbers.length; i++){
            char[] ch = String.valueOf(numbers[i]).toCharArray();
            int firstVal = ch[0];
            int lastVal = ch[ch.length - 1];

            for(int j = i+1; j < numbers.length; j++){
                char[] chJ = String.valueOf(numbers[j]).toCharArray();
                int firstValJ = chJ[0];
                int lastValJ = chJ[chJ.length - 1];
                if(firstVal != firstValJ && lastVal != lastValJ){
                    continue;
                } else {
                    int sum = numbers[i] + numbers[j];
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }
}
