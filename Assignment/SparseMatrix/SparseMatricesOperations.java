import java.util.ArrayList;
import java.util.List;

public final class SparseMatricesOperations {
    private final List<Node> sparseMatrix;
    private final int rowSizeOfMatrix;
    private final int columnSizeOfMatrix;
    
    /**
     * Constructor to produce SparseMatricesOperations object from 2D array
     * @param sparseMatrix        2D array of matrix including zeros
     * @param rowSizeOfMatrix     Number of rows in matrix
     * @param columnSizeOfMatrix  number of columns in matrix
     * Time complexity            O(n^2) 
     */
    public SparseMatricesOperations(int[][] sparseMatrix, int rowSizeOfMatrix, int columnSizeOfMatrix) {
	    this.sparseMatrix = new ArrayList<Node>();
	    this.columnSizeOfMatrix = columnSizeOfMatrix;
	    this.rowSizeOfMatrix = rowSizeOfMatrix;
	    for(int rowIndex = 0; rowIndex < sparseMatrix.length; rowIndex++){
	        for(int columnIndex = 0; columnIndex < sparseMatrix[0].length; columnIndex++){
	            if(sparseMatrix[rowIndex][columnIndex] != 0){
	                this.sparseMatrix.add(new Node(rowIndex, columnIndex, sparseMatrix[rowIndex][columnIndex]));
	            }
	        }
	    }
    }
    
    /**
     * Constructor to produce SparseMatricesOperations object from list of node
     * @param sparseMatrix        List of node including non zero value and their row and column number
     * @param rowSizeOfMatrix     Number of rows in matrix
     * @param columnSizeOfMatrix  number of columns in matrix
     * Time complexity            O(1)
     */
    public SparseMatricesOperations(List<Node> sparseMatrixList, int rowSizeOfMatrix, int columnSizeOfMatrix){
        this.sparseMatrix = new ArrayList<Node>(sparseMatrixList);
        this.columnSizeOfMatrix = columnSizeOfMatrix;
	    this.rowSizeOfMatrix = rowSizeOfMatrix;
    }
    
    /**
     * This method return 2D array for SparseMatricesOperations's object
     * @return            2D array of sparse matrix including zeros
     * Time complexity    O(n)
     */
    public int[][] returnSparseMatrixIn2DArray(){
        int[][] resultArray = new int[this.rowSizeOfMatrix][this.columnSizeOfMatrix];
        for(Node element : this.sparseMatrix){
            resultArray[element.getRowNumber()][element.getColumnNumber()] = element.getValue();
        }
        return resultArray;
    }
    
    /**
     * This method is use to find transpose of a matrix
     * @return           SparseMatricesOperations's object for transpose matrix
     * Time complexity   O(n)
     */
    public SparseMatricesOperations getTransposeMatrix(){
        List<Node> transposeMatrix = new ArrayList<Node>();
        for(Node nodeObject : this.sparseMatrix)
        {
            transposeMatrix.add(new Node(nodeObject.getColumnNumber(), nodeObject.getRowNumber(), nodeObject.getValue()));
        }
        return new SparseMatricesOperations(transposeMatrix, this.rowSizeOfMatrix, this.columnSizeOfMatrix);
    }
    
    /**
     * This method is use to check matrix is symmetric or not 
     * @return           true if matrix is symmetric, otherwise false 
     * Time complexity   O(n^2)
     */
    public boolean isSymmetricmatrix(){
        SparseMatricesOperations transposeMatrix = this.getTransposeMatrix();
        int indexOfThisMatrix;
        int indexOfMatrix;
        for(indexOfThisMatrix = 0; indexOfThisMatrix < this.sparseMatrix.size(); indexOfThisMatrix++){
        	for(indexOfMatrix = 0; indexOfMatrix < transposeMatrix.sparseMatrix.size(); indexOfMatrix++){
        		if(this.sparseMatrix.get(indexOfThisMatrix).getRowNumber() == transposeMatrix.sparseMatrix.get(indexOfMatrix).getRowNumber() &&
                      this.sparseMatrix.get(indexOfThisMatrix).getColumnNumber() == transposeMatrix.sparseMatrix.get(indexOfMatrix).getColumnNumber() &&
                      this.sparseMatrix.get(indexOfThisMatrix).getValue() == transposeMatrix.sparseMatrix.get(indexOfMatrix).getValue()){
                    break;
        		}
        	}
        	if(indexOfMatrix == transposeMatrix.sparseMatrix.size()){
                return false;
        	}
        }
        return true;
    }
    
    /**
     * Calculate addition of sparse matrices
     * @param matrix               sparse matrix 
     * @return                     addition of matrices
     * @throws AssertionError      if addition of matrices is not possible
     * Time complexity             O(n) 
     */
    public SparseMatricesOperations addMatrices(SparseMatricesOperations matrix) throws AssertionError{
        List<Node> additionOfMatrix = new ArrayList<Node>();
        int thisListIndex;
        int matrixListIndex;
        int rowIndexOfThisMatrix,rowIndexOfMatrix;
        int columnIndexOfThisMatrix,columnIndexOfMatrix;
        int valueOfThisMatrix,valueOfMatrix;
        if(matrix == null || matrix.sparseMatrix.size() == 0){
            throw new AssertionError("Matrix is empty");
        }
        if((this.columnSizeOfMatrix != matrix.columnSizeOfMatrix) || (this.rowSizeOfMatrix != matrix.rowSizeOfMatrix)){
            throw new AssertionError("Matrices size should be same");
        }
        for(thisListIndex = 0, matrixListIndex = 0; thisListIndex < this.sparseMatrix.size() && matrixListIndex < matrix.sparseMatrix.size(); ){
            rowIndexOfMatrix = matrix.sparseMatrix.get(matrixListIndex).getRowNumber();
            rowIndexOfThisMatrix = this.sparseMatrix.get(thisListIndex).getRowNumber();
            columnIndexOfMatrix = matrix.sparseMatrix.get(matrixListIndex).getColumnNumber();
            columnIndexOfThisMatrix = this.sparseMatrix.get(thisListIndex).getColumnNumber();
            valueOfMatrix = matrix.sparseMatrix.get(matrixListIndex).getValue();
            valueOfThisMatrix = this.sparseMatrix.get(thisListIndex).getValue();
            if(rowIndexOfThisMatrix == rowIndexOfMatrix){
                if(columnIndexOfThisMatrix == columnIndexOfMatrix){
                    additionOfMatrix.add(new Node(rowIndexOfMatrix, columnIndexOfMatrix, valueOfMatrix + valueOfThisMatrix));
                    thisListIndex++;
                    matrixListIndex++;
                }
                else{
                   if(columnIndexOfMatrix > columnIndexOfThisMatrix){
                	   additionOfMatrix.add(new Node(rowIndexOfThisMatrix,columnIndexOfThisMatrix,valueOfThisMatrix));
                	   thisListIndex++;
                   }
                   else{
                	   additionOfMatrix.add(new Node(rowIndexOfMatrix,columnIndexOfMatrix,valueOfMatrix));
                	   matrixListIndex++;
                   }
                }
            }
            else if(rowIndexOfMatrix > rowIndexOfThisMatrix){
                additionOfMatrix.add(new Node(rowIndexOfThisMatrix, columnIndexOfThisMatrix, valueOfThisMatrix));
                thisListIndex++;
            }
            else {
                additionOfMatrix.add(new Node(rowIndexOfMatrix, columnIndexOfMatrix, valueOfMatrix));
                matrixListIndex++;
            }
        }
        while(thisListIndex < this.sparseMatrix.size()){
        	additionOfMatrix.add(new Node(this.sparseMatrix.get(thisListIndex).getRowNumber(), this.sparseMatrix.get(thisListIndex).getColumnNumber(), 
        	        this.sparseMatrix.get(thisListIndex).getValue()));
            thisListIndex++;
        }
        while(matrixListIndex < matrix.sparseMatrix.size()){
        	additionOfMatrix.add(new Node(matrix.sparseMatrix.get(matrixListIndex).getRowNumber(), 
        	        matrix.sparseMatrix.get(matrixListIndex).getColumnNumber(), matrix.sparseMatrix.get(matrixListIndex).getValue()));
            matrixListIndex++;
        }
        return new SparseMatricesOperations(additionOfMatrix, rowSizeOfMatrix, columnSizeOfMatrix);
    }
    
    /**
     * calculate multiplication of sparse matrices
     * @param matrix            sparse matrix
     * @return                  multiplication of matrices 
     * @throws AssertionError   if multiplication is not possible
     * Time complexity          O(n*m) 
     */
    public SparseMatricesOperations multiplyMatrices(SparseMatricesOperations matrix) throws AssertionError{
    	if(matrix == null){
        	throw new AssertionError("Multiplication is not possible because natrix is empty");
        }
        if(this.columnSizeOfMatrix != matrix.rowSizeOfMatrix){
        	throw new AssertionError("Multiplication is not possible");
        }
        
        int[][] result = new int[this.rowSizeOfMatrix][matrix.columnSizeOfMatrix];
        for(Node elementOfThisMatrix : this.sparseMatrix){
            for(Node elementOfMatrix : matrix.sparseMatrix){
                if(elementOfThisMatrix.getColumnNumber() == elementOfMatrix.getRowNumber()){
                	result[elementOfThisMatrix.getRowNumber()][elementOfMatrix.getColumnNumber()] += 
                        elementOfThisMatrix.getValue() * elementOfMatrix.getValue();
                }
            }
        }
        return new SparseMatricesOperations(result, result.length, result[0].length);
    }
}
