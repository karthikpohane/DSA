class Solution {
    public int majorityElement(int[] nums) {
        //Step 1 - Moore's voting algo
        int count = 0;
        int hero = nums[0];
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                count = 1;
                hero = nums[i];
            } else if(nums[i] == hero) count++;
            else count--;
        }

        //step 2 - verify if the hero ele occures more than n/2 times
        int check = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == hero) check++;
        }
        if(check > (nums.length)/2) return hero;
        return -1;
    }
}