class Solution {
    private static Map<Character, String> map = new HashMap<>();
    static{
        map.put('a', ".-");
         map.put('b', "-...");
         map.put('c', "-.-.");
         map.put('d', "-..");
         map.put('e', ".");
         map.put('f', "..-.");
         map.put('g', "--.");
         map.put('h', "....");
         map.put('i', "..");
         map.put('j', ".---");
         map.put('k', "-.-");
         map.put('l', ".-..");
         map.put('m', "--");
         map.put('n', "-.");
         map.put('o', "---");
         map.put('p', ".--.");
         map.put('q', "--.-");
         map.put('r', ".-.");
         map.put('s', "...");
         map.put('t', "-");
         map.put('u', "..-");
         map.put('v', "...-");
         map.put('w', ".--");
         map.put('x', "-..-");
         map.put('y', "-.--");
         map.put('z', "--..");
    }
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>();
        for(String word : words){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++){
                sb.append(map.get(word.charAt(i)));
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}