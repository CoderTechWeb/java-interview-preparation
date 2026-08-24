package InterviewProgram;

//Given an integer array arr and an integer k, calculate the sum of the current element and the previous k elements for every index.
//If there are fewer than k previous elements available, sum all the elements available up to that index.
class SlidingWindowSum {
     static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // Expected output: {1, 3, 6, 9, 12}
        int k = 3;

        int sum = 0;
        int[] result = new int[arr.length];
       
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(i >= k){
                sum -= arr[i-k];
            }

            result[i] = sum;
            System.out.println(result[i]);
        }  
    }
}