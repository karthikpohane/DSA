class Solution {
    public boolean isHappy(int n) {
        Set<Integer> knownInt = new HashSet<>();
        while(true){
            int sum = 0;
            while(n!=0){
                sum += Math.pow(n%10, 2.0);
                n = n/10;
            }
            if(sum==1) return true;
            n = sum;
            if(knownInt.contains(n)) return false;
            else knownInt.add(n);
        }
    }
}