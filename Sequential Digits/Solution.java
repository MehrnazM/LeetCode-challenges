class Solution {
    
    private int generate(int fDig, int length){
        
        int res = 0;
        for(int i = 1; i < length+1; i++){
            
            int ten = (int)Math.pow(10,length-i);
            res += fDig * ten;
            fDig++;
        }
        return res;
    }
    
    
    public List<Integer> sequentialDigits(int low, int high) {
        
        String lowStr = Integer.toString(low);
        String highStr = Integer.toString(high);
        int minNumDigit = lowStr.trim().length();
        int maxNumDigit = highStr.trim().length();
        List<Integer> resList = new ArrayList<>();
        int len = minNumDigit;
        int start = 1;
        while(true){
            if(start < (11-len)){
                int num = generate(start,len);
                resList.add(num);
                start++;
                continue;
            }
            start = 1;
            len++;
            if(len > maxNumDigit){
                break;
            }
        }
        resList = resList.stream().filter(num -> num >= low && num <= high).sorted().
            collect(Collectors.toList());
        return resList;
        
    }
}
