import java.util.LinkedHashMap;
import java.util.Map;


public class BinarySearchTree {
	
    private TreeNode root;
    private Map<String, String> sortedListOfWords;
    
    /**
     * Initializes Binary Search Tree
     */
    BinarySearchTree() { 
        root = null; 
        sortedListOfWords = new LinkedHashMap<String, String>();
    }

    /**
     * Calls insert() overLoaded method which is private method
     * @param key key   
     * @param value value
     * @return true if TreeNode added, else false
     */
    public boolean insert(String key, String value) {
        root = insert(root, key, value);
        return (root != null);
    }
    
    /**
     * Inserts TreeNode to binary search tree
     * @param root root TreeNode
     * @param key key
     * @param value value
     * @return return root TreeNode
     */
    private TreeNode insert(TreeNode root, String key, String value){
        //if root is null then add key to root
        if (root == null) {
            root = new TreeNode(key, value);
            return root;
        }
        
        //if key is less than key of root TreeNode then go left
        if (root.getKey().compareToIgnoreCase(key) > 0) {
            root.setLeftChild(insert(root.getLeftChild(), key, value));
        }else if (root.getKey().compareToIgnoreCase(key) < 0) {
        //else if key is more than key of root TreeNode then go right
            root.setRightChild(insert(root.getRightChild(), key, value));
        }
        return root;
    }
    
    /**
     * Returns a list with all TreeNodes arranged in inorder format
     * @return list of TreeNodes
     */
    public Map<String, String> getSortedKeyList() {
    	sortedListOfWords.clear();
        inorder(root);
        return sortedListOfWords;
    }

    /**
     * Traverses through tree inorder format
     * @param root root TreeNode
     */
    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.getLeftChild());
            sortedListOfWords.put(root.getKey(), root.getValue());
            inorder(root.getRightChild());
        }
    }
    
    /**
     * Calls deleteKey() overLoaded method (private method) to delete key
     * @param key key of TreeNode that is to be deleted
     * @return 
     */
    public boolean deleteKey(String key) {
        root = deleteKey(root, key);
        return (root != null);
    }
    
    /**
     * Deletes an TreeNode from binary search tree
     * @param root root TreeNode
     * @param key key of TreeNode that is to be deleted
     */
    private TreeNode deleteKey(TreeNode root, String key){
        //Return null  if tree is empty
        if (root == null) {
            return root;
        }

        //if key is less than key of root TreeNode then go left
        if (root.getKey().compareToIgnoreCase(key) > 0) {
            root.setLeftChild(deleteKey(root.getLeftChild(), key));
        }else if (root.getKey().compareToIgnoreCase(key) < 0) {
        //else if key is more than key of root TreeNode then go right
            root.setRightChild(deleteKey(root.getRightChild(), key));
        }else {
        // if key is same as root's key then This is the TreeNode to be deleted
            // TreeNode with only one child or no child
            if (root.getLeftChild() == null) {
                return root.getRightChild();
            }else if (root.getRightChild() == null) {
                return root.getLeftChild();
            }
            
            // TreeNode with two children
            root.setKey(getLeftmostTreeNode(root.getRightChild()).getKey());
            root.setValue(getLeftmostTreeNode(root.getRightChild()).getValue());

            // Delete the inorder successor
            root.setRightChild(deleteKey(root.getRightChild(), root.getKey()));
        }
        return root;
    }

    /**
     * Returns key of leftmost leaf TreeNode
     * @param root root TreeNode
     */
    private TreeNode getLeftmostTreeNode(TreeNode root) {
        TreeNode leftmostTreeNode = root;
        while (root.getLeftChild() != null) {
            leftmostTreeNode = root.getLeftChild();
            root = root.getLeftChild();
        }
        return leftmostTreeNode;
    }
}
