package com.luo.leetcode;

public class FlipGameII_294 {
    /*You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
    you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no longer
    make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.*/
    public boolean canWin(String s) {
        int n = s.length();
        for(int i=1;i<n;i++){
            if(s.charAt(i-1)=='+'&&s.charAt(i)=='+'&&!canWin(s.substring(0,i-1)+"--"+s.substring(i+1)))return true;
        }
        return false;
    }
}
