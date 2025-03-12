class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        for(right = 0; right<nums.length; right++){
            if(nums[right] == 0) left = right+1;
            else{
                int len = right-left+1;
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}