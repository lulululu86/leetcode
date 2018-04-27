package com.luo.leetcode;

public class ValidWordAbbreviation_408 {
    /*Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not
a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:

Given s = "internationalization", abbr = "i12iz4n":

Return true.


Example 2:

Given s = "apple", abbr = "a2e":

Return false.*/
    public boolean validWordAbbreviation(String word, String abbr) {
        char[]cAbbr = abbr.toCharArray();
        char[]cWord = word.toCharArray();
        int n = abbr.length(),m = word.length(),i=0,j=0;
        while(i<n){
            if(cAbbr[i]>='a' && cAbbr[i]<='z'){
                if(j>m||cAbbr[i]!=cWord[j])return false;
                i++;j++;
            }else if(cAbbr[i]>='0' && cAbbr[i]<='9'){
                int num = 0;
                while(i<n&&cAbbr[i]>='0' && cAbbr[i]<='9'){
                    num = num*10+(cAbbr[i++]-'0');
                }
                j += num;
            }
        }
        return i==n&&j==m;
    }
}
