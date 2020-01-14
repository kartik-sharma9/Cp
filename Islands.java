class Islands {
    public int numIslands(char[][] grid) {
        return recursiveFunction(0,0,grid);
    }
    
    public int recursiveFunction(int i, int j, char[][] grid){
        if(i >=grid.length || i < 0 || j< 0)
            return 0;
        else{
            if(grid[i][j]== 1){
                int islands =1;
                grid[i][j]=2;
                //Integer.parseInt(String.valueOf(Boolean.TRUE));
                return (islands + grid[i+1][j]==1?recursiveFunction(i+1,j,grid):0 +
                        grid[i][j+1]==1?recursiveFunction(i,j+1,grid):0 +
                        grid[i][j-1]==1?recursiveFunction(i,j+1,grid):0 +
                        grid[i-1][j]==1?recursiveFunction(i,j+1,grid):0) > 0? islands++ :1 ;
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Islands islands = new Islands();
        char[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(islands.numIslands(grid));
    }

}