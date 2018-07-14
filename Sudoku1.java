public class Sudoku {
    public int[][] grid;

    public static int[][] problem = {
            { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
            { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
            { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
            { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
            { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
            { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
    };

    public Sudoku(int[][] grid){
        this.grid = new int[9][9];
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                this.grid[i][j] = grid[i][j];
            }
        }
    }

    public static void main(String[] args){
        Sudoku su = new Sudoku(problem);
        System.out.println("Sudoku to Solve:");
        su.display();

        if(su.isSolved()){
            System.out.println("Solution to Sudoku:");
            su.display();
        }
        else{
            System.out.println("Somethings gone wrong!\n");
        }
    }

    /* Check to identify whether a value already exists in
    the 3x3 sub square */
    public boolean isSubSquare(int row, int col, int val){
        int rCheck = row - row % 3;
        int cCheck = col - col % 3;

        for (int i = rCheck; i < rCheck + 3 ; i++){
            for (int j = cCheck; j < cCheck + 3 ; j++){
                if (grid[i][j] == val){
                    return true;
                }
            }
        }
        return false;
    }

    /* Check to identify whether a value already exist in the row */
    public boolean isRow(int row, int val){
        for (int i = 0; i < 9 ; i++){
            if (grid[row][i] == val){
                return true;
            }
        }
        return false;
    }

    /* Check to identify whether a value already exist in the col */
    public boolean isCol(int col, int val){
        for (int i = 0; i < 9 ; i++){
            if (grid[i][col] == val){
                return true;
            }
        }
        return false;
    }

    public boolean isSolved(){
        for (int i = 0; i < 9 ; i++){
            for (int j = 0; j < 9; j++){
                if (grid[i][j] == 0){
                    for (int k = 1; k <= 9 ; k++){
                        if(!isRow(i,k) && !isCol(j,k) && !isSubSquare(i,j,k)){
                            grid[i][j] = k;
                            if (isSolved()){
                                return true;
                            } else{
                                grid[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void display(){
        for (int i = 0; i < 9 ; i++){
            for (int j = 0; j < 9 ; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
