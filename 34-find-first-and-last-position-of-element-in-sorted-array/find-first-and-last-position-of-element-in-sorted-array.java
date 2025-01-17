class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the first occurrence of the target
        result[0] = findBound(nums, target, true);

        // If the first occurrence is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }

        // Find the last occurrence of the target
        result[1] = findBound(nums, target, false);

        return result;
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid; // Record the position
                if (isFirst) {
                    right = mid - 1; // Narrow down the search for the first occurrence
                } else {
                    left = mid + 1; // Narrow down the search for the last occurrence
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
}
