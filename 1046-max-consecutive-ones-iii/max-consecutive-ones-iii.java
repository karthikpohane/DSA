class Solution {
    public int longestOnes(int[] nums, int k) {
        // Sliding window using Acquire and Release approach
        int i = 0;
        int j = -1;
        int ans = 0;
        int coziw = 0;  // Count of zeros in current window

        while (i < nums.length) {
            // Acquire
            if (nums[i] == 0) {
                coziw++;
            }
            i++;

            // Release until the window is valid (coziw <= k)
            while (coziw > k) {
                j++;
                if (nums[j] == 0) {
                    coziw--;
                }
            }

            // Update max length of valid window
            int currentWindowLength = i - j - 1;
            ans = Math.max(ans, currentWindowLength);
        }

        return ans;
    }
}