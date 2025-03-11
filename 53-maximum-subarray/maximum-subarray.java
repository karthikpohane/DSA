class Solution {
    public int maxSubArray(int[] nums) {
        //Use of Kaden's Algo - Where you just keep on adding in sum and,
        //if the sum becomes less then zero then make the sum as Zero.

        int sum = nums[0];
        int maxLen = nums[0];
        for(int i=1; i<nums.length; i++){
            if(sum<0) sum = 0;
            sum += nums[i];
            maxLen = Math.max(sum, maxLen);
        }
        return maxLen;
    }
}