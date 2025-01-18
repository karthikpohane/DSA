class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int i = 0;
        int candyToGive = 1; 

        while (candies > 0) {
            nums[i] += Math.min(candies, candyToGive); 
            candies -= candyToGive; 
            candyToGive++; 
            i = (i + 1) % num_people; // Move to the next person in a circular manner
        }

        return nums;
    }
}