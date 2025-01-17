class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1}; // Default result for no match

        // Handle edge case where the array has only one element
        if (nums.length == 1 && nums[0] == target) return new int[]{0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }

        return result;
    }
}
