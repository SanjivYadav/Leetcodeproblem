class Solution {
    public int[] processQueries(int[] queries, int m) {
        List<Integer> temp = new ArrayList<>();
        int res[] = new int[queries.length];
        for(int i=1;i<=m;i++){
            temp.add(i);
        }
        for(int i=0;i<queries.length;i++){
            if(temp.contains(queries[i])){
            res[i]= temp.indexOf(queries[i]);
            temp.remove(temp.indexOf(queries[i]));
            temp.add(0,queries[i]);
            }
        }
        return res;
    }
}