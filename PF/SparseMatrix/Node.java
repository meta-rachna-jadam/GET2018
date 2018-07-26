/**
 * Immutable class to store position of non-zero elements of Sparse Matrix
 * @author Rachna Jadam
 *
 */
public final class Node {
    private final int rowNumber;
    private final int columnNumber;
    private final int value;
    public Node(int rowNumber, int columnNumber, int value) {
	    this.rowNumber = rowNumber;
	    this.columnNumber = columnNumber;
	    this.value = value;
	}
    public int getRowNumber() {
        return rowNumber;
    }
    public int getColumnNumber() {
        return columnNumber;
    }
    public int getValue(){
        return value;
    }
}
