public  class sudoku{

    private static boolean isSafe(int[][] sudoku,int row,int col,int digit){

        //col
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==digit) return false;
        }
        //row
        for(int i=0;i<9;i++){
            if(sudoku[row][i]==digit) return false;
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit) return false;
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int[][] sudoku,int row,int col){
       if(row==9){
        return true;
       }
        
        int nextRow=row, nextCol=col+1;
        if(col+1==9){
            nextCol=0;
            nextRow=row+1;
        }
        //recursion(kaam)/kaj
        if(sudoku[row][col] !=0){
          return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
           return false;
    }
    public static void main(String[] args) {
        int[][] sudoku = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(sudokuSolver(sudoku, 0, 0)){
            for(int i=0;i<sudoku.length;i++){
                for(int j=0;j<sudoku.length;j++){
                    System.out.print(sudoku[i][j]+" ");
                }
                System.out.println();
            }
        } else{
            System.out.println("not exists");
        }
    }
}