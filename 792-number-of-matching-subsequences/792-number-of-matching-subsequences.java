class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for(char c ='a'; c<='z';c++){
            map.put(c,new LinkedList<>());
        }
        for(String word : words){
            map.get(word.charAt(0)).addLast(word);
        }
        int count=0;
        for(char c : s.toCharArray()){
            Deque<String> q = map.get(c);
            int size=q.size();
            for(int j=0;j<size;j++){
                String word = q.removeFirst();
                if(word.length()==1)
                    count++;
                else
                    map.get(word.charAt(1)).addLast(word.substring(1)); 
            }
            
        }
            return count;
        
    }
}