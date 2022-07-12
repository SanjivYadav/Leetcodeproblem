class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4)
            return false;
        int sum =0;
        for(int i=0;i<matchsticks.length;i++){
            sum += matchsticks[i];
        }
        if(sum%4 != 0)
            return false;
        int target = sum/4;
        Arrays.sort(matchsticks);
        int sides[] = new int[4];
        return dp(matchsticks, matchsticks.length-1,sides, target);
        
    }
    private boolean dp(int arr[], int len,int sides[], int target){
        if(len ==-1){
            return ((sides[0]==sides[1]) && (sides[1]==sides[2]) && (sides[2]==sides[3]) && (sides[3]==sides[0]));
        }
        
        for(int i=0;i<4;i++){
            if(sides[i]+arr[len]<=target){
                sides[i] +=arr[len];
                if(dp(arr,len-1,sides,target))
                    return true;
                sides[i] -=arr[len];
            }
        }
        return false;
    }
}