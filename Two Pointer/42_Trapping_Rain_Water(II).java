// Time Complexity O(N)
// Space Complexity O(1)

class 42_Trapping_Rain_Water(II) {
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = n - 1;
        int water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
