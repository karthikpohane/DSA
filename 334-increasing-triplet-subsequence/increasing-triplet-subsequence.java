class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int val: nums){
            if(val <= first){
                first = val;
            } else if(val <= second){
                second = val;
            } else {
                return true;
            }
        }
        return false; 
    }
}