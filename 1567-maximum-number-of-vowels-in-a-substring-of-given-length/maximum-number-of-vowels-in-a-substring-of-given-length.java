class Solution {
    public int maxVowels(String s, int k) {
        int count = 0, maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            // Add current character if it's a vowel
            if (isVowel(s.charAt(i))) {
                count++;
            }
            // Remove character that's sliding out of the window
            if (i >= k && isVowel(s.charAt(i - k))) {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
