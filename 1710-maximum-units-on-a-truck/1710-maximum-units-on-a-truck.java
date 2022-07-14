class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2){
                return ((a2[1])-(a1[1]));
            }
        });
        int res=0;
        for(int i=0;i<boxTypes.length;i++){
            if(boxTypes[i][0]<=truckSize){
                res += boxTypes[i][0]*boxTypes[i][1];
                truckSize -=boxTypes[i][0];
            }
            else{
                res += truckSize*boxTypes[i][1];
                truckSize=0;
                break;
            }
        }
        return res;
    }
}