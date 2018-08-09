
public class TreeNode {

    private String key;    //Key is the word of dictionary 
    private String value;  //Value is the meaning of the word
    private TreeNode leftChild;
    private TreeNode rightChild;
    
    public TreeNode(String key, String value) {
	    this.key = key;
	    this.value = value;
	    leftChild = rightChild = null;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
   
    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    
    public void setKey(String key) {
    	this.key = key;
    }
    
    public void setValue(String value) {
    	this.value = value;
    }
}
