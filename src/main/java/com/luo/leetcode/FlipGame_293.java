package com.luo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlipGame_293 {
    /*You are playing the following Flip Game with your friend: Given a string that contains only
    these two characters: + and -, you and your friend take turns to flip twoconsecutive "++" into "--".
    The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]


If there is no valid move, return an empty list [].*/
    public List<String> generatePossibleNextMoves(String s) {
        int n = s.length();
        List<String>res = new ArrayList<String>();
        char[]c = s.toCharArray();
        for(int i=0;i<n-1;i++){
            if(c[i]=='+'&&c[i+1]=='+'){
                c[i]='-';
                c[i+1]='-';
                res.add(new String(c));
                c[i]='+';
                c[i+1]='+';
            }
        }
        return res;
    }
}
