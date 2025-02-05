class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        if(n!=s2.length()) return false;

        int[] val = new int[2];
        int j=0;
        
        for(int i=0; i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(j>=2) return false;
                val[j++] = i;
            }
        }
        if(j==0) return true;
        if(j!=2) return false;
        return (s1.charAt(val[0]) == s2.charAt(val[1]) && s1.charAt(val[1]) == s2.charAt(val[0]));

    }
}