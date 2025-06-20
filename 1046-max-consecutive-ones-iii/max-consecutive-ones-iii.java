class Solution {
    public int longestOnes(int[] nums, int k) {
        // Sliding window approach using two pointers (i and j)
        // i = right boundary of window, j = left boundary (initially -1)
        // coziw = count of zeros in the current window
        // ans = stores the maximum length of a valid window

        int i = 0;
        int j = -1;
        int ans = 0;
        int coziw = 0;  // Count of zeros in the current window

        while (i < nums.length) {
            // Acquire new element into the window
            if (nums[i] == 0) {
                coziw++;
            }
            i++;

            // Release elements from the left until the window becomes valid (zero count ≤ k)
            while (coziw > k) {
                j++;
                if (nums[j] == 0) {
                    coziw--;
                }
            }

            // Update the maximum length of the valid window
            int currentWindowLength = i - j - 1;
            ans = Math.max(ans, currentWindowLength);
        }

        return ans;
    }
}
