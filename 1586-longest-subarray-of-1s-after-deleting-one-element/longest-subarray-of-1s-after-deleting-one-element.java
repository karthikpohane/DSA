class Solution {
    public int longestSubarray(int[] nums) {
        // Leetcode 1004 | Maximum consecutive ones III with k=1
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
            while (coziw > 1 && j < i) {
                j++;
                if (nums[j] == 0) {
                    coziw--;
                }
            }

            // Update max length of valid window
            int currentWindowLength = i - j - 1;
            ans = Math.max(ans, currentWindowLength);
        }

        return ans-1;
    }
}