package com.luo.leetcode;

public class ReverseWordsInAStringII_186 {
    /*
    * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Could you do it in-place without allocating extra space?
    * */
    public String reverseWords(String s) {
        int n = s.length(),i=0,j = n-1;
        char[]c = s.toCharArray();
        char temp = '0';
        while(i<j){
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        i=0;j=0;
        int t=0;
        System.out.println(new String(c));
        for(;j<n;j++){
            if(c[j]==' '){
                t = j+1;
                j--;
                while(i<j){
                    temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                    i++;
                    j--;
                }
                i = t;
                j = t-1;
            }
        }
        j--;
        while(i<j){
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return new String(c);
    }
}
