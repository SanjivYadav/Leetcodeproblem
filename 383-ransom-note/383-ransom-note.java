class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int count[] = new int[26];
        for(int i=0;i<ransomNote.length();i++){
            count[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<magazine.length();i++){
            if(count[magazine.charAt(i)-'a'] !=0)
                count[magazine.charAt(i)-'a']--;
        }
        for(int i=0;i<ransomNote.length();i++){
            int x=count[ransomNote.charAt(i)-'a'];
            if(x !=0)
                return false;
        }
        return true;
    }
}