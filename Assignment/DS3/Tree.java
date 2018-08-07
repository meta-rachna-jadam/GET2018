import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Tree {
	
    public static final Node root = new Node("R:");
    Node ptr = root;
    public Tree(){
    	
    }
    
    public void addDirectory(String path) {
    	String directory[] = path.split("\\\\");
    	Node newDirectory = new Node(directory[directory.length - 1]);
    	Node tempNode = null;
    	int index = 0;
    	for (Map.Entry<Node, Integer> mapEntry : findDirectory(path).entrySet()) {
                 tempNode = mapEntry.getKey();
                 index = mapEntry.getValue();
                 break;
    	}
    	while (index < directory.length - 1) {
    		tempNode.addChildNodeInChildList(new Node(directory[index+1]));
    		tempNode = tempNode.getChildNodeList().get(0);
    		index++;
    	}
    }
    
    public Map<Node, Integer> findDirectory(String path) {
    	Map<Node, Integer> result = new HashMap<Node, Integer>();
    	String directory[] = path.split("\\\\");
    	Node tempPointer = root;
    	boolean isDirectoryFound = false;
    	int index ;
    	for (index = 0; index < directory.length - 2; index++) {
    		for (Node childNode : tempPointer.getChildNodeList()) {
    			if (directory[index+1].equals(childNode.getDirectoryName())) {
    				isDirectoryFound = true;
    				tempPointer = childNode;
    				break;
    			}
    		}
    		if (!isDirectoryFound) {
    			result.put(tempPointer, index);
    			return result;
    		}
    	}
    	result.put(tempPointer, index);
    	return result;
    }
    
    public boolean isPathExistOrNot(String path) {
    	String directory[] = path.split("\\\\");
    	Node tempPointer = root;
    	boolean isDirectoryFound = false;
    	for (int index = 0; index < directory.length - 1; index++) {
    		isDirectoryFound = false;
    		for (Node childNode : tempPointer.getChildNodeList()) {
    			if (directory[index+1].equals(childNode.getDirectoryName())) {
    				isDirectoryFound = true;
    				tempPointer = childNode;
    				break;
    			}
    		}
    		if (!isDirectoryFound) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public void traverseTree(List<Node> nodeList){
    	
    }
    
    public Node getNode(String path) throws AssertionError {
    	String directory[] = path.split("\\\\");
    	Node tempPointer = root;
    	boolean isDirectoryFound = false;
    	for (int index = 0; index < directory.length - 1; index++) {
    		isDirectoryFound = false;
    		for (Node childNode : tempPointer.getChildNodeList()) {
    			if (directory[index+1].equals(childNode.getDirectoryName())) {
    				isDirectoryFound = true;
    				tempPointer = childNode;
    				break;
    			}
    		}
    		if (!isDirectoryFound) {
    			throw new AssertionError("Invalid path");
    		}
    	}
    	return tempPointer;
    }
    
    

}
