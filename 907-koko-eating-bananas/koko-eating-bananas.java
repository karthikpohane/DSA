class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
         * Approach:
         * - Use binary search to find the minimum possible eating speed `k`.
         * - The range for k is [1, max(piles)].
         * - For each mid = (low + high) / 2, compute total hours required.
         * - If total hours <= h, update result and search in lower half.
         * - Else, search in upper half.
         * 
         * Time Complexity: O(n * log m), where n = piles.length, m = max(piles)
         * Space Complexity: O(1)
         */

        int low = 1, high = getMax(piles), result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(piles, h, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    // Check if all bananas can be eaten at speed k within h hours
    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            // Avoids casting with Math.ceil
            hours += (pile + k - 1) / k;
            if (hours > h) return false; // Early exit
        }
        return true;
    }

    // Get maximum value in array
    private int getMax(int[] piles) {
        int max = piles[0];
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }
}
