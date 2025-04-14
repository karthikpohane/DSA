class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Step 1 - Modified Moore's algo
        int count1 = 0;
        int count2 = 0;
        int hero1 = -1;
        int hero2 = -2;
        for(int i=0; i<nums.length; i++){
            if(count1 == 0 && nums[i] != hero2){
                count1 = 1;
                hero1 = nums[i];
            } else if(count2 == 0 && nums[i] != hero1) {
                count2 = 1;
                hero2 = nums[i];
            } else if(nums[i] == hero1) count1++;
            else if(nums[i] == hero2) count2++;
            else {
                count1--;
                count2--;
            }
        }
        //Step 2 - New List and manual checking 
        List<Integer> ans = new ArrayList<>();
        int check1 =0;
        int check2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == hero1) check1++;
            if(nums[i] == hero2) check2++;
        }
        int dif = (nums.length)/3;
        if(check1 > dif) ans.add(hero1);
        if(check2 > dif) ans.add(hero2);
        return ans;
    }
}