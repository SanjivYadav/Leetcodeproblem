class Solution {
    public String reverseWords(String s) {
    String[] strs = s.split(" ");
      StringBuilder sb = new StringBuilder();
      String space = "";
      for(String str: strs){
        sb.append(space);
        sb.append(reverse(str));  
        space = " ";
      }
      return sb.toString();
    }
    
    String reverse(String str){
      char[] sc = str.toCharArray();
      int s = 0, e = sc.length - 1;
      while(s < e){
        char t = sc[s];
        sc[s] = sc[e];
        sc[e] = t;
        s++;
        e--;
      }
      return new String(sc);
    }
}