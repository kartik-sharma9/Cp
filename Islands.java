class Islands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i =0; i < grid.length;i++)
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j]==1)
                 islands++;
                recursiveFunction(i,j,grid);
            }
        return islands;
    }
    
    public void recursiveFunction(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]=='0')
            return;
            grid[i][j]='0';
            recursiveFunction(i+1,j,grid);
            recursiveFunction(i,j+1,grid);
            recursiveFunction(i-1,j,grid);
            recursiveFunction(i,j-1,grid);

    }
    public static void main(String args[]){
        Islands islands = new Islands();
        char[][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(islands.numIslands(grid));
    }

}