class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;
        return dpRec(nums, target);
        
    }
    private int dpRec(int[] nums, int target){
        if(dp[target] !=-1)
            return dp[target];
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(target>=nums[i]){
                result +=dpRec(nums, target-nums[i]);
            }
        }
        dp[target] = result;
        return result;
    }
     
}