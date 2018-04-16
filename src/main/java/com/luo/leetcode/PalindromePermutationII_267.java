package com.luo.leetcode;
import java.util.*;
public class PalindromePermutationII_267 {
    /*Given a string s, return all the palindromic permutations (without duplicates) of it.
    Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].

Hint:

If a palindromic permutation exists, we just need to generate the first half of the string.
To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.*/
    public List<String> generatePalindromes(String s){
        char[]c = s.toCharArray();
        int n = s.length();
        Arrays.sort(c);
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer>map = new HashMap<Character, Integer>();
        List<String>ret = new ArrayList<String>();
        boolean odd = false;
        char oddone = ' ';
        for(char cc:c){
            if(!map.containsKey(cc))map.put(cc,1);
            else map.put(cc,map.get(cc)+1);
        }
        for(char cc:map.keySet()){
            if(map.get(cc)%2==1){
                if(odd)return ret;
                odd = true;
                oddone = cc;
            }
            int i=0;
            while(i++<map.get(cc)/2)sb.append(cc);
        }
        int len = sb.length();
        Set<String> res = new HashSet<String>();
        //backtrack(sb.toString(),res,"",new boolean[len]);
        permute(sb.toString().toCharArray(),res,0,sb.toString());
        for(String ss:res){
            StringBuilder sb1 = new StringBuilder();
            sb1.append(ss);
            String re = new StringBuilder(ss).reverse().toString();
            if(odd)sb1.append(oddone);
            sb1.append(re);
            ret.add(sb1.toString());
        }
        return ret;
    }
    private void backtrack(String s,Set<String>res,String cur,boolean[]visited){
        if(cur.length()==s.length()){
            res.add(new String(cur));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(s,res,cur+s.charAt(i),visited);
                visited[i] = false;
            }
        }
    }
    private void permute(char[]c,Set<String>res,int pos,String cur){
        if(pos==c.length){
            res.add(cur);
            return;
        }
        for(int i=pos;i<c.length;i++){
            if(i>pos&&c[i]==c[pos])continue;
            char t = c[i];
            c[i] = c[pos];
            c[pos] = t;
            permute(c,res,pos+1,new String(c));
            t = c[i];
            c[i] = c[pos];
            c[pos] = t;
        }
    }
}
