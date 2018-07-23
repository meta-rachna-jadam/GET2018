
public class NQueen {
    
    public boolean isQueenPlacedHere(int board[][], int rowNumber, int columnNumber){
        int rowIndex,columnIndex;
        //check for row on left side
        for(columnIndex = 0; columnIndex < columnNumber; columnIndex++){
    	    if(board[rowNumber][columnIndex] == 1){
    	        return false;
    	    }
        }
        //check upper diagonal on left side
        for(rowIndex = rowNumber, columnIndex = columnNumber; columnIndex >= 0 && rowIndex >= 0; columnIndex--, rowIndex--){
    	    if(board[rowIndex][columnIndex] == 1){
    	        return false;
    	    }
        }
    	//check lower diagonal on left side
        for(rowIndex = rowNumber, columnIndex = columnNumber; columnIndex >= 0 && rowIndex < board.length; columnIndex--, rowIndex++){
    	    if(board[rowIndex][columnIndex] == 1){
    	        return false;
    	    }
        }
        return true;
    }
    
    public boolean solveNQueen(int board[][], int columnNumber){
    	// base case: If all queens are placed then return true 
        if(columnNumber >= board.length){
            return true;
        }
        //Consider this column and try placing this queen in all rows one by one
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            //Check if the queen can be placed on board[rowIndex][columnNumber]
            if(isQueenPlacedHere(board, rowIndex, columnNumber)){
            	//Place this queen in board[rowIndex][columnNumber]
        	    board[rowIndex][columnNumber]=1;
        	    //recursive call to place rest of the queens
        	    if(solveNQueen(board, columnNumber+1)){
        		    return true;
                }
        	    /*
        	     * If placing queen in board[rowIndex][columnNumber]
                   doesn't lead to a solution then
                   remove queen from board[rowIndex][columnNumber]
                */
        	    board[rowIndex][columnNumber]=0; // BACKTRACK
            }
        }
        /* If the queen can not be placed in any row in
        this column columnNumber, then return false */
        return false;   
    }
    
    
    public int[][] solveNQueen(int N)
    {
        int board[][] = new int[N][N];
        if (!solveNQueen(board, 0))
        {
            System.out.print("Solution does not exist");
            return null;
        }
        return board;
    }
}
