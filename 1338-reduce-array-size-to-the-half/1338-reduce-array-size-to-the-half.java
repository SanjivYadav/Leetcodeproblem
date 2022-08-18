class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],0);
            map.put(arr[i], map.get(arr[i])+1);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
		Collections.sort(list);
        int count=0;
        int res=0;
        int len = list.size();
        for(int i=len-1;i>=0;i--){
            count +=list.get(i);
            res = res+1;
            //System.out.println("count :"+count);
            //System.out.println("i :"+i);
            if(count >= (arr.length/2)){
                //System.out.println("san :"+count);
                return res;
            }
            
        }
        return len;
        
    }
}