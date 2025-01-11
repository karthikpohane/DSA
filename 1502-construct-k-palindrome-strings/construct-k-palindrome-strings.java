class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n==k)
            return true;
        if(n<k)
            return false;
        //If k is less than odd frequence charecters then return false.
        //i.e is if(odd freq chars > k) return false
        //if(odd freq chars <= k) return true.
        int [] freq = new int[26];
        for(char ch: s.toCharArray())
        {
            freq[ch-'a']++;
        }

        int oddFreqChars = 0;
        for(int i=0; i<26; i++)
        {
            if(freq[i]%2 != 0)
                oddFreqChars++;
        }
        if(oddFreqChars>k)
            return false;
        else return true;
    }
}