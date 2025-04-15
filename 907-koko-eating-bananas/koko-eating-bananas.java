class Solution {
    public int minEatingSpeed(int[] piles, int h) { 
        int low = 1;
        int high = maxValue(piles);
        int k = 0;
        int totalHours = 0;
        while(low<=high){
            int mid = (low+high)/2;
            totalHours = findHours(piles, mid);
            if(totalHours <= h){
                k = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return k;
    }

    //Funtion to find the number of hours required if k = mid is assumed.
    private static int findHours(int nums[], int k){
        int hours = 0;
        for(int i=0; i<nums.length; i++){
            hours += Math.ceil((double)nums[i] / (double)k);
        }
        return hours;
    }

    //Function to find the max of the array elements
    private static int maxValue(int nums[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}