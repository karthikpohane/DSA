class Solution {
    public int maxProduct(int[] nums) {
        int maxPro = nums[0];
        int sufix = 1;
        int prefix = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(sufix==0) sufix = 1;
            if(prefix==0) prefix = 1;

            sufix *= nums[i];
            prefix *= nums[n-i-1];
            maxPro = Math.max(maxPro, Math.max(sufix, prefix));
        }
        return maxPro;
    }
}