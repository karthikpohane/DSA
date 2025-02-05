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

//Second Approach 
// class Solution {
//     public int maxProduct(int[] nums) {
//         if (nums.length == 0) return 0;

//         int maxProduct = nums[0];
//         int minProduct = nums[0];
//         int result = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] < 0) {
//                 // Swap max and min because multiplying by a negative number reverses roles
//                 int temp = maxProduct;
//                 maxProduct = minProduct;
//                 minProduct = temp;
//             }

//             // Update max and min product for the current position
//             maxProduct = Math.max(nums[i], maxProduct * nums[i]);
//             minProduct = Math.min(nums[i], minProduct * nums[i]);

//             // Store the maximum result
//             result = Math.max(result, maxProduct);
//         }

//         return result;
//     }
// }

