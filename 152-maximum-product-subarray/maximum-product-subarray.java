class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int prefix = 1;
        int sufix = 1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(prefix == 0) prefix = 1;
            if(sufix == 0) sufix =1;
            prefix *= nums[i];
            sufix *= nums[n-i-1];

            maxProd = Math.max(maxProd, Math.max(sufix, prefix));
        }
        return maxProd;
    }
}