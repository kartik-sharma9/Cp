class Islands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i =0; i < grid.length;i++)
            for(int j =0; j<grid.length;j++){
                if(grid[i][j]==1)
                 islands+= recursiveFunction(i,j,grid);
            }
        return islands;
    }
    
    public int recursiveFunction(int i, int j, char[][] grid){
        if(i >=grid.length || j >= grid[0].length)
            return 0;
        else{
            if(grid[i][j]== 1){
                int islands = 1;
                grid[i][j] = 2;
                if( i >=grid.length-1 && !(j >= grid[0].length-1)) {

                    //Integer.parseInt(String.valueOf(Boolean.TRUE));
                    return islands + (
                            (grid[i][j + 1] == 1 ? recursiveFunction(i, j + 1, grid) : 0)
                            //grid[i][j-1]==1?recursiveFunction(i,j-1,grid):0 +
                            // grid[i-1][j]==1?recursiveFunction(i-1,j,grid):0
                    ) > 0 ? islands++ : 1;
                }
                if(j >= grid[0].length-1){
                    //Integer.parseInt(String.valueOf(Boolean.TRUE));
                    return islands++;
                }
                else{
                    return islands + ((grid[i + 1][j] == 1 ? recursiveFunction(i + 1, j, grid) : 0) +
                            (grid[i][j + 1] == 1 ? recursiveFunction(i, j + 1, grid) : 0)
                            //grid[i][j-1]==1?recursiveFunction(i,j-1,grid):0 +
                            // grid[i-1][j]==1?recursiveFunction(i-1,j,grid):0
                    ) > 0 ? islands++ : 1;
                }
            }
        }
        return 0;
    }
    public static void main(String args[]){
        Islands islands = new Islands();
        char[][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
        System.out.println(islands.numIslands(grid));
    }

}