class Solution {
    public boolean canJump(int[] nums) {
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            if(i>maxLen) return false;
            int len = i + nums[i];
            maxLen = Math.max(maxLen, len);
        }
        return true;
    }
}