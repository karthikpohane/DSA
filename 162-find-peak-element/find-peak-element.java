class Solution {
    public int findPeakElement(int[] nums) {
        int peak = -1;
        if(nums.length==1) return 0;
        if(nums.length <=2) {
            if(nums[0]<nums[1]) return 1;
            else return 0;
        }
        for(int i=1; i<=nums.length-2; i++){
            if (i-1 == 0 && nums[i-1]>nums[i]) {
                peak = i-1;
                break;
            }
            if(nums[i-1]<nums[i] && nums[i+1] < nums[i]) {
                peak = i;
                break;
            }
            if(nums[i+1] == nums.length && peak == -1 && nums[i] < nums[i+1]) {
                peak = i+1;
                break;
            }
        }
        return peak;
    }
}