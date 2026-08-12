class Solution {
    public static boolean issafe(char[][] sudoku,int row,int col,int digit){
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }

        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board){
        solve(board);
    }

    public boolean solve(char[][] sudoku){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(sudoku[row][col]=='.'){
                    for(char num='1';num<='9';num++){
                        if(issafe(sudoku,row,col,num)){
                            sudoku[row][col] = num;
                            if(solve(sudoku)){
                                return true;
                            }
                            sudoku[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}