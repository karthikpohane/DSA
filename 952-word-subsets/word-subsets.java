import java.util.*;
import java.lang.*;
class Solution {
    Boolean isSubset(int[] freq2, int[] temp){
        for(int i=0; i<26; i++)
        {
            if(temp[i]<freq2[i])
                return false;
        }
        return true;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        int n = words1.length;
        List<String> result = new ArrayList<>();
        //to count the requence
        // Vector<Integer> freq2 = new Vector<>(26);
        int[] freq2 = new int[26];
        for(String word : words2)
        {
           int[] temp = new int[26];
           for(char ch : word.toCharArray())
           {
            temp[ch-'a']++;
            freq2[ch-'a'] = Math.max(freq2[ch-'a'], temp[ch-'a']);
           }
        }

        for(String word : words1)
        {
            int [] temp = new int[26];
            for(char ch : word.toCharArray())
           {
            temp[ch-'a']++;
           }
           if(isSubset(freq2, temp)==true)
            result.add(word);
        }
        return result;
    }
}