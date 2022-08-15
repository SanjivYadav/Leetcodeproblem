class Solution {
    private static Map<Character, Integer> map = new HashMap<>();
    static{
         map.put('I', 1);
         map.put('V', 5);
         map.put('X', 10);
         map.put('L', 50);
         map.put('C', 100);
         map.put('D', 500);
         map.put('M', 1000);
    }
    public int romanToInt(String s) {
        int res =0;
        int i=0;
        while(i<s.length()-1){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                res +=(map.get(s.charAt(i+1))-(map.get(s.charAt(i))));
                i=i+2;
            }
            else{
                res +=map.get(s.charAt(i));
                i=i+1;
            }
        }
        if(i<s.length())
            res +=map.get(s.charAt(i));   
        return res;
    }
}