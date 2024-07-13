class Solution {
public:
    bool wordPattern(string pattern, string s) {
       unordered_map<char, string> map;
       unordered_map<string, bool> visited;
       vector<string> wordlist;

       //stringstream
       stringstream st(s);

       string word;
       int count = 0;

        //Take each word from the stringstream st and store it in word and the access the word.
       while(st>>word)
       {
        count += 1; //Count the number of words to mach the count of letter in pattern.
        wordlist.push_back(word); // store all the words in vector to map them accordingly.
       }

       //Check 01 - total(pattern) != total(s)
       if(pattern.size() != count)
            return false;
        else {
            //Travers the pattern.
            for(int i=0; i<pattern.size();i++)
            {
                char c = pattern[i];
//Condition-01: If a charecter is not mapped with any word and the word at ith index is already visited.
                if(map[c] == "" && visited[wordlist[i]] == true)
                    return false;
//Condition-02: If the word is not mapped then map the word.
                else if(map[c] == "")
                {
                    map[c] = wordlist[i];
                    visited[wordlist[i]] = true;
                }
//Condition-03: If the letter is not mapped with the current word hence return false.
                else{
                    if(map[c] != wordlist[i])
                        return false;
                }
            }
        }
        return true;

    }
};
