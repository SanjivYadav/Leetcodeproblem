class Solution {
    int count =0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,m,n,i,j,x,y);
                    if(max<count)
                        max =count;
                    count=0;
                }
            }
        }
        return max;
        
    }
    
    private void dfs(int[][] grid,int m, int n, int i,int j, int x[], int y[]){
        grid[i][j]=2;
        count++;
        
        for(int  k=0;k<4;k++){
            int newX = i+x[k];
            int newY = j+y[k];
            if(isValid(grid,m,n,newX,newY)){
                dfs(grid,m,n,newX,newY,x,y);
                
            }
        }
    }
    private boolean isValid(int grid[][], int m, int n, int newX, int newY){
        if(newX>=0 && newX< m && newY>=0 && newY<n && grid[newX][newY]==1)
            return true;
        return false;
    }
}