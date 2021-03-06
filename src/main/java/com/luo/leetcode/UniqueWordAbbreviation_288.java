package com.luo.leetcode;
import java.util.*;
public class UniqueWordAbbreviation_288 {
    /*An abbreviation of a word follows the form <first letter><number><last letter>.
    Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


这道题让我们求独特的单词缩写，但是题目中给的例子不是很清晰，我们来看下面三种情况：

1. dictionary = {"dear"},  isUnique("door") -> false

2. dictionary = {"door", "door"}, isUnique("door") -> true

3. dictionary = {"dear", "door"}, isUnique("door") -> false*/
    private Map<String,Set<String>>map;
    public UniqueWordAbbreviation_288(List<String>words){
        map = new HashMap<String, Set<String>>();
        for(String word:words){
            int len = word.length();
            String key = word.substring(0,1)+(len-2)+word.substring(len-1);
            if(!map.containsKey(key))map.put(key,new HashSet<String>());
            map.get(key).add(word);
        }
    }
    public boolean isUnique(String word) {
        int len = word.length();
        String key = word.substring(0,1)+(len-2)+word.substring(len-1);
        if(!map.containsKey(key))return true;
        if(map.get(key).size()>1)return false;
        for(String s:map.get(key))return s.equals(word);
        return false;
    }
}
