import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math.*;


class Solution {
    
    private HashMap<Character,ArrayList<Integer>> genMap(String str){
        
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++){
            Character key = str.charAt(i);
            if(!map.containsKey(key)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key,list);
            }
            else{
                ArrayList<Integer> list = map.get(key);
                list.add(i);
                map.put(key,list);
            }
        }
        return map;
    }
    
    public String getHint(String secret, String guess) {
        
        int bull = 0;
        int cow = 0;
        HashMap<Character,ArrayList<Integer>> sMap = genMap(secret);
        HashMap<Character,ArrayList<Integer>> gMap = genMap(guess);
        sMap.keySet().retainAll(gMap.keySet());
        
        for(Character key : sMap.keySet()){
            int count = 0;
            ArrayList<Integer> sIndices = sMap.get(key);
            ArrayList<Integer> gIndices = gMap.get(key);
            for(Integer sIndex : sIndices){
                if(gIndices.contains(sIndex)){
                    count++;
                    bull += 1;
                }
            }
            cow += Math.min(sIndices.size(),gIndices.size())-count;
        }
        return String.valueOf(bull) + "A" + String.valueOf(cow) + "B";
    }
}
