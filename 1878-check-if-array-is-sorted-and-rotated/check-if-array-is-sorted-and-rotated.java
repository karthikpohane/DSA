class Solution {
    public boolean check(int[] nums) {
      int n = nums.length;
      int breakPoint = 0;
      for(int i=0; i<n-1; i++)
      {
        if(nums[i] > nums[i+1]) breakPoint++;
      } 
      if(nums[n-1]>nums[0]) breakPoint++;
      return breakPoint<=1;
    }
}