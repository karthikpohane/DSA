class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //1. Map Creation and storing the values of ele frequence.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        //2. Create a bucket array to store the elements of dif/same freq.
        int n = nums.length;
        ArrayList<Integer>[] bucket = new ArrayList[n+1];
        //iterate through map
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        //3. Create a result list to store the answer and return the array.
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=n; i>=0 && result.size()<k; i--){
            if(bucket[i]!=null){
                result.addAll(bucket[i]);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}