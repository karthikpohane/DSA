class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0) return false; // Odd length cannot be valid

        int open = 0;   // Tracks '(' and unlocked positions from left
        int close = 0;  // Tracks ')' and unlocked positions from right

        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }
            if (open < 0) return false; // Too many ')' without matching '('
        }

        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                close++;
            } else {
                close--;
            }
            if (close < 0) return false; // Too many '(' without matching ')'
        }

        return true; // Passed both checks
    }
}
