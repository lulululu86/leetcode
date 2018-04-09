package com.luo.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MissingRange_163 {
    /*
    * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/
    private int a;

    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        int n = A.length,i = 1;

        List<String>res = new ArrayList<String>();
        if(A==null||n==0||A[n-1]<=lower||A[0]>=upper)return res;
        if(lower<A[0]-1)res.add(lower+"->"+(A[0]-1));
        else if(lower==A[0]-1)res.add(""+lower);
        for(;i<n;i++){
            if(A[i]<=lower)continue;
            if(A[i]>=upper){
                break;
            }
            if(A[i]-A[i-1]>2)res.add((A[i-1]+1)+"->"+(A[i]-1));
            else if(A[i]-A[i-1]==2)res.add(""+(A[i-1]+1));
        }
        if(upper==A[i-1]+1)res.add(""+(A[i-1]+1));
        else if(upper>A[i-1]+1)res.add((A[i-1]+1)+"->"+upper);

        return res;
    }



}
