package leetcode._0001_0100.seq0041_0050;

public class Trap {

    // time out
    public int trap1(int[] height) {
        int max = Integer.MIN_VALUE;
        for(int num : height){
            max = Math.max(max, num);
        }
        int sum = 0;
        for(int i = 1; i <= max; i++){
            boolean isStart = false;
            int tempSum = 0;
            for(int j = 0; j < height.length; j++){
                if(isStart && height[j] < i){
                    tempSum++;
                }
                if(height[j] >= i){
                    sum += tempSum;
                    tempSum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    // 5 percent
    public int trap2(int[] height) {
        int sum = 0;
        for(int i = 1; i < height.length-1; i++){
            int maxLeft = 0;
            for(int j = i-1; j >= 0; j--){
                maxLeft = Math.max(maxLeft, height[j]);
            }

            int maxRight = 0;
            for(int j = i+1; j < height.length; j++){
                maxRight = Math.max(maxRight, height[j]);
            }
            int min = Math.min(maxLeft, maxRight);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;
    }

    // 75.72 percent
    public int trap3(int[] height) {
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        for(int i = 1; i < height.length-1; i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for(int i = height.length-2; i > 0; i--){
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            int min = Math.min(maxLeft[i], maxRight[i]);
            if(min > height[i]){
                sum += min - height[i];
            }
        }
        return sum;
    }

    // 100 percent
    public int trap4(int[] height) {
        int sum = 0;
        int maxLeft = 0;
        int maxRight = 0;

        int left = 1;
        int right = height.length - 2;
        for(int i = 1; i < height.length - 1; i++){
            if(height[left-1] < height[right+1]){
                maxLeft = Math.max(maxLeft, height[left-1]);
                int min = maxLeft;
                if(min > height[left]){
                    sum += min - height[left];
                }
                left++;

            }else {
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if(min > height[right]){
                    sum += min - height[right];
                }
                right--;
            }
        }
        return sum;
    }
}
