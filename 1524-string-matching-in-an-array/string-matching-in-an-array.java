import java.util.Vector;

// KMP Algorithm
class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (searchKMP(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    // KMP search function
    public Boolean searchKMP(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();

        // Find the LPS array
        Vector<Integer> LPS = new Vector<>(M);
        for (int i = 0; i < M; i++) LPS.add(0); // Initialize with zeros
        computeLPS(pat, LPS, M);

        // Apply KMP algorithm
        int i = 0, j = 0;
        while (i < N) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == M) {
                return true; // Pattern found
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = LPS.get(j - 1);
                } else {
                    i++;
                }
            }
        }
        return false; // Pattern not found
    }

    // Compute LPS array
    public void computeLPS(String pat, Vector<Integer> LPS, int M) {
        int len = 0;
        LPS.set(0, 0); // LPS[0] is always 0
        int i = 1;

        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                LPS.set(i, len);
                i++;
            } else {
                if (len != 0) {
                    len = LPS.get(len - 1);
                } else {
                    LPS.set(i, 0);
                    i++;
                }
            }
        }
    }
}







//Brutforce Method
// class Solution {
//     public List<String> stringMatching(String[] words) {
//         int n = words.length;
//         List<String> result = new ArrayList<>();

//         for(int i=0; i<n; i++)
//         {
//             for(int j=0; j<n; j++)
//             {
//                 if(i==j) continue;
//                 if(words[j].contains(words[i]))
//                 {
//                     result.add(words[i]);
//                     break;
//                 }
//             }
//         }
//         return result;
//     }
// }
