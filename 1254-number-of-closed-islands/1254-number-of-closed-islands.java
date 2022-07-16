class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
       
        for(int i=0;i<n;i++){
            if(grid[0][i]==1 || grid[0][i]==0){
                int target= grid[0][i];
                dfs(grid,m,n,0,i,target,dx,dy);
            }
        }
        
        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1 || grid[i][n-1]==0){
                int target= grid[i][n-1];
                dfs(grid,m,n,i,n-1,target,dx,dy);
            }
        }
        
        for(int i=n-1;i>=0;i--){
            if(grid[m-1][i]==1 || grid[m-1][i]==0){
                int target= grid[m-1][i];
                 //System.out.print("calling for : "+target);
                dfs(grid,m,n,m-1,i,target,dx,dy);
            }
        }
        
        for(int i=m-1;i>=0;i--){
            if(grid[i][0]==1 || grid[i][0]==0){
                int target= grid[i][0];
               // System.out.print("calling for : "+target);
                dfs(grid,m,n,i,0,target,dx,dy);
            }
        }
        
        //System.out.println(" After "+"    ");
        
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    dfs(grid,m,n,i,j,0,dx,dy);
                    res++;
                }
            }
        }
        
        
        return res;
    }
    
    private void dfs(int[][] grid, int m, int n, int i, int j, int target, int dx[], int dy[]){
        grid[i][j]=2;
        
        for(int k=0;k<4;k++){
            int newX = i+dx[k];
            int newY = j+dy[k];
            if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]== target){
                dfs(grid, m, n, newX, newY, target, dx, dy);
            }
        }
    }
}