class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's Alogorithem
        int sum = 0;
        int maxStore = nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxStore = sum>maxStore ? sum : maxStore;
            if(sum<0) sum=0;
        }
        return maxStore;
    }
}