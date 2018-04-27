package com.luo.leetcode;

import java.util.List;

public class SentenScreenFitting_418 {
    /*Given a rows x cols screen and a sentence represented by a list of words,
    find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word won't exceed 10.
1 ≤ rows, cols ≤ 20,000.


Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output:
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.


Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output:
2

Explanation:
a-bcd-
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.


Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output:
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
*/
    public int wordsTyping(List<String> sentence, int rows, int cols) {
        int res = 0,i=0,j=0,k=0,n = sentence.size();
        while(k<n){
            int len = sentence.get(k).length();
            if(cols-j>=len){
                j+=len+1;
                k++;
                if(k==n){
                    k=0;
                    res++;
                }
                if(j>=cols){
                    j=0;
                    i++;
                    if(i==rows)return res;
                }
            }else{
                i++;
                if(i==rows)return res;
                j=0;
            }
            //System.out.println(i+" "+j+" "+k);
        }
        return res;
    }
}
