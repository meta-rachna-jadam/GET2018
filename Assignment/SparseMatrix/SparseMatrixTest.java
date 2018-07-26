import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

    @Test
    public void getTransposeMatrixTest() {
    	int[][] sparseMatrix = new int[][]{{0,0,1,0},{0,1,0,0},{1,0,1,1},{0,0,1,0}};
        SparseMatricesOperations sparseMatricesOperationsInstance = new SparseMatricesOperations(sparseMatrix, 4, 4);
        int[][] transposeSparseMatrix = sparseMatricesOperationsInstance.getTransposeMatrix().returnSparseMatrixIn2DArray();
        assertArrayEquals(new int[]{0,0,1,0}, transposeSparseMatrix[0]);
        assertArrayEquals(new int[]{0,1,0,0}, transposeSparseMatrix[1]);
        assertArrayEquals(new int[]{1,0,1,1}, transposeSparseMatrix[2]);
        assertArrayEquals(new int[]{0,0,1,0}, transposeSparseMatrix[3]);
	}
    
    @Test
    public void isSymmetricmatrixTest(){
    	int[][] sparseMatrix = new int[][]{{0,0,1,0},{0,1,0,0},{1,0,1,1},{0,0,1,0}};
        SparseMatricesOperations sparseMatricesOperationsInstance = new SparseMatricesOperations(sparseMatrix, 4, 4);
        System.out.println(sparseMatricesOperationsInstance.isSymmetricmatrix());
        assertTrue(sparseMatricesOperationsInstance.isSymmetricmatrix());
    }
    
    @Test
    public void addMatricesTest(){
    	int[][] sparseMatrix = new int[][]{{3,1,3},{0,2,0},{0,0,0}};
    	int[][] sparseMatrixTwo = new int[][]{{2,0,2},{1,0,0},{0,1,0}};
        SparseMatricesOperations sparseMatricesOperationsInstance = new SparseMatricesOperations(sparseMatrix, 3, 3);
        SparseMatricesOperations sparseMatricesOperationsInstanceTwo = new SparseMatricesOperations(sparseMatrixTwo, 3, 3);
        SparseMatricesOperations addition = sparseMatricesOperationsInstance.addMatrices(sparseMatricesOperationsInstanceTwo);
        int[][] result = addition.returnSparseMatrixIn2DArray();
        assertArrayEquals(new int[]{5,1,5}, result[0]);
        assertArrayEquals(new int[]{1,2,0}, result[1]);
        assertArrayEquals(new int[]{0,1,0}, result[2]);
    }
    
    @Test
    public void multiplyMatricesTest(){
    	int[][] sparseMatrix = new int[][]{{3,1,3},{0,2,0},{0,0,0}};
    	int[][] sparseMatrixTwo = new int[][]{{2,0,2},{1,0,0},{0,1,0}};
        SparseMatricesOperations sparseMatricesOperationsInstance = new SparseMatricesOperations(sparseMatrix, 3, 3);
        SparseMatricesOperations sparseMatricesOperationsInstanceTwo = new SparseMatricesOperations(sparseMatrixTwo, 3, 3);
        SparseMatricesOperations multiplication = sparseMatricesOperationsInstance.multiplyMatrices(sparseMatricesOperationsInstanceTwo);
        int[][] result = multiplication.returnSparseMatrixIn2DArray();
        assertArrayEquals(new int[]{7,3,6}, result[0]);
        assertArrayEquals(new int[]{2,0,0}, result[1]);
        assertArrayEquals(new int[]{0,0,0}, result[2]);
    }

}
