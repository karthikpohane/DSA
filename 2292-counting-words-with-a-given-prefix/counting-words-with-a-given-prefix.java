// class Solution {
//     public int prefixCount(String[] words, String pref) {
//        int n = words.length;
//        int m = pref.length();
//        int count = 0;
//        for(int i=0; i<n; i++)
//        {
//         count += counterFun(words[i], pref, m);
//        }
//        return count;
//     }

//     public int counterFun(String word, String pref, int m){
//         if (word.length() < m) {
//             return 0;
//         }
//        for (int i = 0; i < m; i++) {
//             if (word.charAt(i) != pref.charAt(i)) {
//                 return 0;
//             }
//         }
//         return 1;
//     }
// }


//With Inbuild Function - words[i].startsWith(pref)
class Solution {
    public int prefixCount(String[] words, String pref) {
        int c=0;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].startsWith(pref))
            {
                c++;
            }
        }
        return c;
    }
}