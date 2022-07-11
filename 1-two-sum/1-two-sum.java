class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        Map<Integer, Integer> mp = new HashMap<Integer,Integer>();
        int i=0;
        int x = nums.length-1;
        while(i<=x)
        {
            if(mp.get(target-nums[i]) != null)
            {
                res[0] = i;
                res[1] = mp.get(target-nums[i]);
                break;
            }
            else
                mp.put(nums[i],i);
            i++;
        }
        return res;
        
    }
}