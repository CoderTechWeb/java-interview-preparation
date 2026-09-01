package leetCode;

import java.util.Arrays;

public class ProductExceptSelf {

    static void main(String[] args) {
        ProductExceptSelf exceptSelf = new ProductExceptSelf();
        int[]  nums = {1,2,3,4};
        System.out.println(Arrays.toString(exceptSelf.prodSelf(nums)));
    }

    public int[] prodSelf(int[] nums) {
        int[] pf = new int[nums.length];
        int[] output = new int[nums.length];

        pf[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            pf[i] = pf[i-1] * nums[i - 1];
        }

        int sf = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = sf * pf[i];
            sf *= nums[i];
        }

        return output;
    }
}
