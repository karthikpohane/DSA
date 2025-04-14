class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Step 1 - Creation of List of List and sorting the array
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        //Step 2&3 - For loop for the 1st element (i)
        // while loop for 2nd and 3rd ele (j, k);
        for(int i=0; i<n; i++){
            //duplicate check (i)
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = n-1;
            
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0) j++;
                else if(sum > 0) k--;
                else{
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
            }
        }
        return ans;
    }
}