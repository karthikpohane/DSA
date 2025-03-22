class Solution {
    public int secondHighest(String s) {
        int large = -1;
        int secondLarge = -1;
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))) {
                int val = s.charAt(i) - '0';
                if(large < val){
                    secondLarge = large;
                    large = val;
                } else if(val > secondLarge && val != large)
                    secondLarge = val;
            }
        }
        return secondLarge;
    }
}