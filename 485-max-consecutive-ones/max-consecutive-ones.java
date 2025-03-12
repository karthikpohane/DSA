class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        //if(nums.length ==1) return nums[0];
        int maxLen = nums[0];
        int left = 0;
        int right = 0;
        while(right<nums.length){
            if(nums[right]==0){
                left = right+1;
            }
            int len = right-left+1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }
}