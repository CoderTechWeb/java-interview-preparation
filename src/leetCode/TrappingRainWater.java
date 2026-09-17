package leetCode;

public class TrappingRainWater {

    static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int left = 0, right = height.length - 1;
        int maxL = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        int water = 0;
        while (left < right) {
            if(height[left] < height[right]){
                maxL = Math.max(maxL, height[left]);
                water += maxL - height[left];
                left++;
            } else {
                maxR = Math.max(maxR, height[right]);
                water += maxR - height[right];
                right--;
            }
        }

        System.out.println(water);
    }
}
