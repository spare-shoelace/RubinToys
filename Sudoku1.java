public class ruSudoku {
    public int grid[][];
    /*
    Current Thoughts: Implement BackTracking or Straight to Dancing Links
    Done: Validity Checks, just need to implement the algorithm that pieces it
    altogether
    */


    /* Check to identify whether a value already exists in
    the 3x3 sub square */
    public boolean isSubSquare(int row, int col, int val){
        int rCheck = row - row % 3;
        int cCheck = col - col % 3;

        for (int i = rCheck; i < row + 3 ; i++){
            for (int j = cCheck; j < col + 3 ; j++){
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
            if (grid[row][val] == val){
                return true;
            }
        }
        return false;
    }

    /* Check to identify whether a value already exist in the col */
    public boolean isCol(int col, int val){
        for (int i = 0; i < 9 ; i++){
            if (grid[val][col] == val){
                return true;
            }
        }
        return false;
    }
}
