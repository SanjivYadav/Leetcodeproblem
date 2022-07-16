class Solution {
    int sum =0;
    Map<Integer, Integer> map =new HashMap<>();
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        boolean isZero = false;
        int max =0;
        int count=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,n,i,j,dx,dy,count);
                    map.put(count, sum);
                    count++;
                    sum=0;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    isZero = true;
                    int temp=0;
                    set.clear();
                    //System.out.println(" New : ");
                     for(int k=0;k<4;k++){
                        int newX = i+dx[k];
                        int newY = j+dy[k];
                         
                         if(newX>=0 && newX<n && newY>=0 && newY<n && grid[newX][newY]!=0 && map.containsKey(grid[newX][newY])){
                             //System.out.println(" grid : "+ (grid[newX][newY]));
                             //System.out.println(" map : "+ map.get(grid[newX][newY]));
                          if(!set.contains(grid[newX][newY])){
                              temp+=map.get(grid[newX][newY]);
                              set.add(grid[newX][newY]);
                          }
                        }
                }
                //System.out.println(" temp : "+ temp);
                max = Math.max(max,temp);
                //System.out.println(" max : "+ max);
            }
        }
        
    }
        if(!isZero)
            return n*n;
        return max+1;
    }
    
    private void dfs(int[][] grid, int n, int i,int j, int[] dx, int[] dy, int count){
        grid[i][j] =count;
        sum++;
        
        for(int k=0;k<4;k++){
            int newX = i+dx[k];
            int newY = j+dy[k];
            if(newX>=0 && newX<n && newY>=0 && newY<n && grid[newX][newY]==1){
                dfs(grid,n,newX,newY,dx,dy,count);
            }
        }
    }
}