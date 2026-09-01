package leetCode;

public class IncreasingTriplet {

    static void main(String[] args) {
        IncreasingTriplet triplet = new IncreasingTriplet();
        int[] nums = {1,2,1,1,1};
        System.out.println(triplet.increasingTriplet(nums));
    }


    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int firstMax = Integer.MAX_VALUE;
        int secondMax = Integer.MAX_VALUE;
        for(int num:nums){
            if(num <= firstMax) {
                firstMax = num;
            } else if(num <= secondMax) {
                secondMax = num;
            } else {
                return true;
            }
        }

        return false;
    }
}
