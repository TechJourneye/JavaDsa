public class nqueens{

    public static void printBoa(char Board[][]){
        System.out.println("Cheease board------>");
        for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board.length;j++){
               System.out.print(Board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(char Board[][],int row,int col){
        //Diagonal left 
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(Board[i][j]=='Q') return false;
        }
        //vertical up;
     for(int i=row-1;i>=0;i--){
        if(Board[i][col]=='Q') return false;
     }
        //diagonal right
        for(int i=row-1,j=col+1;i>=0&&j<Board.length;i--,j++){
            if(Board[i][j]=='Q') return false;
        }
        return true;
    }

    static int count;
    public static void nQueens(char Board[][],int row){
        if(row==Board.length){
            // printBoa(Board);
            count++;
            return;
        }
        for(int j=0;j<Board.length;j++){
            if(isSafe(Board,row,j)){
                Board[row][j]='Q';
                nQueens(Board, row+1);//recursion call
                Board[row][j]='X';//backtracking step
            }
          
        }
    }
    public static void main(String[] args) {
        int n=8;
        char Board[][]=new char[n][n];
        for(int i=0;i<Board.length;i++){
            for(int j=0;j<Board.length;j++){
                Board[i][j]='X';
            }
        }
        nQueens(Board, 0);
       System.out.println(count);
    }
}