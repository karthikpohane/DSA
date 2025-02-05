class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's Alogorithem
        int sum = 0;
        int maxStore = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxStore = Math.max(maxStore, sum);
            if(sum<0) sum=0;
        }
        return maxStore;
    }
}