class Solution {
    public int findPeakElement(int[] nums) {
        //Using Binary search
        //Step 1 - finding the mid and checking if that is the peak ele.
        int n = nums.length;
        int low = 0;
        int high = n-1;
        if(n==1) return 0;
        else if(nums[low]>nums[low+1]) return low;
        else if(nums[high]>nums[high-1]) return high;
        else{
            low++;
            high--;
        }

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