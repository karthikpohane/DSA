class Solution {
    public int findPeakElement(int[] nums) {
        //Using Binary search
        int n = nums.length;
        //Step 1 - find if the 1st and last elements are Peak ele or not
        if(n==1) return 0; // if only ele that is peak ele
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        //Step 2 - As we have checked for 1st and last ele
        //Start from 1 till n-2
        int low = 1;
        int high = n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid-1] < nums[mid] && nums[mid+1] < nums[mid])
                return mid;
            else if(nums[mid -1] < nums[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}