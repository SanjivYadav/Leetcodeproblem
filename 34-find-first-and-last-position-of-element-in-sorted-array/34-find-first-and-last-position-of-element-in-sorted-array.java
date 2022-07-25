class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0){
            return new int[]{-1,-1};
        }
        int index1 = firstOcurance(nums, 0, nums.length-1,target);
        int index2 = lastOcurance(nums, 0, nums.length-1,target);
        int res[] = new int[2];
        res[0]= index1;
        res[1]= index2;
        return res;
        
    }
    
    private int firstOcurance(int[] nums, int s, int e,int target){
        int res = 0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(target <= nums[mid]){
                res = mid;
                e= mid-1;
            }
            else{
                s = mid+1;
            }
        }
        if(nums[res]== target)
            return res;
        return -1;
    }
    
     private int lastOcurance(int[] nums, int s, int e,int target){
        int res = 0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(target >= nums[mid]){
                res = mid;
                s= mid+1;
            }
            else{
                //res = mid;
                e = mid-1;
            }
        }
        if(nums[res]== target)
            return res;
        return -1;
    }
}