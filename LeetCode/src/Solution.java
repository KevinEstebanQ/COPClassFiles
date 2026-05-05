import java.util.*;

public class Solution{
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> counts = new HashMap<>();

        for(String s: strs){
            int[] count = new int[26];
            for(Character c: s.toCharArray()){
                count[c - 'a']+=1;
            }
            String key = Arrays.toString(count);
            counts.putIfAbsent(key, new ArrayList<>());
            counts.get(key).add(s);
        }
        return new ArrayList<List<String>>(counts.values());
    }
}
