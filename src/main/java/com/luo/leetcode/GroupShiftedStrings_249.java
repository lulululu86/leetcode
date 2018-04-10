package com.luo.leetcode;
import java.util.*;
public class GroupShiftedStrings_249 {
    /*Given a string, we can "shift" each of its letter to its successive letter,
    for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given a list of strings which contains only lowercase alphabets, group all strings that belong to
 the same shifting sequence,
 For example, given:["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],return:
 [
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]*/
    public List<List<String>> groupStrings(String[] strings) {
        Map<String,List<String>>map = new HashMap<String, List<String>>();
        for(String s:strings){
            int n = s.length();
            if(n==1){
                if(!map.containsKey("0"))map.put("0",new ArrayList<String>());
                map.get("0").add(s);
            }else {
                StringBuilder sb = new StringBuilder();
                for (int i = 1; i < n; i++) {
                    sb.append((s.charAt(i) - s.charAt(i - 1) + 26) % 26).append(" ");
                }

                String key = sb.toString();
                if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
                map.get(key).add(s);
            }
        }
        List<List<String>>res = new ArrayList<List<String>>();
        for(String s:map.keySet()){
            List<String>list = map.get(s);
            System.out.print("[");
            for(String str:list)System.out.print(str+" ");
            System.out.print("]");
            System.out.println();
            res.add(list);
        }
        return res;
    }
}
