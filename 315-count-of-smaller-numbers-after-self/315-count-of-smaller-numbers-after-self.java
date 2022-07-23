class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Map<Integer,ArrayList<Integer>> Hm = new HashMap<>();
        
        for(int num: nums) arr.add(num);
        Collections.sort(arr);
          
        for(int i = 0; i < len; i++){
            int index = firstOccBinarySearch(arr,nums[i]);
            ans.add(index);
            arr.remove(index);
        }
        
        return ans;
    }
    public int firstOccBinarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;
        int firstOccIndex = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) == target) {
                firstOccIndex = mid;
                end = mid - 1;
            } else if(list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstOccIndex;
    }
    
    public int firstOccBinarySearch1(List<Integer> list, int target) {
        int start = 0;
        int end = list.size()-1;
        int firstOccIndex = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(list.get(mid) == target) {
                firstOccIndex = mid;
                end = mid - 1;
            } else if(list.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return firstOccIndex;
    }
}