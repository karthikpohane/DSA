class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high  = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;
            //The main problem when the finding the sorted array becomes impossible.
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            //Check for sorted array [Sorting Property]
            if(nums[low] <= nums[mid]){
                if(nums[low]<=target && target<=nums[mid]) high = mid-1;
                else low = mid+1;
            } else{
                if(nums[mid]<=target && target<=nums[high])
                    low = mid+1;
                else high = mid-1;
            }
        }
        return false;
    }
}