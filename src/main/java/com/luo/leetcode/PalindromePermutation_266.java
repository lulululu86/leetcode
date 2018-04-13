package com.luo.leetcode;

public class PalindromePermutation_266 {
    /*Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
*/
    public boolean canPermutePalindrome(String s) {
        int[]arr = new int[26];
        int n = s.length();
        char[]c = s.toCharArray();
        for(char cc:c){
            arr[cc-'a']++;
        }
        boolean odd = false;
        for(int i=0;i<26;i++){
            if(arr[i]%2==1){
                if(odd)return false;
                odd = true;
            }
        }
        return true;
    }
}
