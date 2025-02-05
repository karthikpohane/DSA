class Solution {
    public int maxProduct(int[] nums) {
        int pro = 1;
        int maxStore = Integer.MIN_VALUE; 
        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length; i++) {
            pro *= nums[i];
            maxStore = Math.max(pro, maxStore);

            if (pro == 0) {
                pro = 1;
            }
        }

        // Additional check for cases where negative products might yield the maximum product
        pro = 1; 
        for (int i = nums.length - 1; i >= 0; i--) {
            pro *= nums[i];
            maxStore = Math.max(pro, maxStore);
            if (pro == 0) pro = 1;
        }

        return maxStore;
    }
}
