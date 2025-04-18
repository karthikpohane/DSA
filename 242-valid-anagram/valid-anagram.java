class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // for lowercase letters only

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // increment count for s
            count[t.charAt(i) - 'a']--; // decrement count for t
        }

        // If all counts are zero, it's an anagram
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
