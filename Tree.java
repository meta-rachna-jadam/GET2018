import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Tree {

	public static final Node root = new Node("R:", "R:\\");
	Node ptr = root;

	public Tree() {

	}

	/**
	 * This is use to add new directory in tree structure
	 * @param path
	 */
	public void addDirectory(String path) {
		String directory[] = path.split("\\\\");
		Node tempNode = null;
		String directoryPath = "";
		int index = 0;
		for (Map.Entry<Node, Integer> mapEntry : findDirectoryForAddNewDirectory(
				path).entrySet()) {
			tempNode = mapEntry.getKey();
			index = mapEntry.getValue();
			break;
		}
		for (int arrayIndex = 0; arrayIndex <= index; arrayIndex++) {
			directoryPath += directory[arrayIndex];
		}
		while (index < directory.length - 1) {
			directoryPath += "\\" + directory[index + 1];
			tempNode.addChildNodeInChildList(new Node(directory[index + 1],
					directoryPath));
			tempNode = tempNode.getChildNodeList().get(0);
			index++;
		}
	}

	/**
	 * This is use by addDirectory method to find at which part we have to create new directory 
	 * @param path
	 * @return map with key as a node and value as a index at which key present in path
	 */
	public Map<Node, Integer> findDirectoryForAddNewDirectory(String path) {
		Map<Node, Integer> result = new HashMap<Node, Integer>();
		String directory[] = path.split("\\\\");
		Node tempPointer = root;
		boolean isDirectoryFound = false;
		int index;
		for (index = 0; index < directory.length - 2; index++) {
			for (Node childNode : tempPointer.getChildNodeList()) {
				if (directory[index + 1].equals(childNode.getDirectoryName())) {
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

	/**
	 * This method is use to update current working directory
	 * @param path
	 * @return reference of current working directory
	 */
	public Node setCurrentDirectory(String path) {
		String directory[] = path.split("\\\\");
		Node tempPointer = root;
		boolean isDirectoryFound = false;
		for (int index = 0; index < directory.length - 1; index++) {
			isDirectoryFound = false;
			for (Node childNode : tempPointer.getChildNodeList()) {
				if (directory[index + 1].equals(childNode.getDirectoryName())) {
					isDirectoryFound = true;
					tempPointer = childNode;
					break;
				}
			}
			if (!isDirectoryFound) {
				return null;
			}
		}
		return tempPointer;
	}

	/**
	 * This method is for the traversing of the tree from current working directory 
	 * @param currentDirectory
	 * @return path list of all directories present in current working directory 
	 */
	public List<String> traverseTree(Node currentDirectory) {
		System.out.println("traverseTree");
		List<String> result = new ArrayList<String>();
		boolean isForCurrentNode = true;
		Queue<Node> bFSQueue = new LinkedList<Node>();
		Node tempNode = currentDirectory;
		bFSQueue.add(tempNode);
		while (!bFSQueue.isEmpty()) {
			tempNode = bFSQueue.remove();
			if (!isForCurrentNode) {
				result.add(tempNode.getDirectoryPath());
			}

			if (tempNode.getChildNodeList().size() != 0) {
				for (Node node : tempNode.getChildNodeList()) {
					bFSQueue.add(node);
				}
			}
			isForCurrentNode = false;
		}
		return result;
	}

	/**
	 * to get node at specified path
	 * @param path
	 * @return
	 * @throws AssertionError if node is not present at specific path
	 */
	public Node getNode(String path) throws AssertionError {
		String directory[] = path.split("\\\\");
		Node tempPointer = root;
		boolean isDirectoryFound = false;
		for (int index = 0; index < directory.length - 1; index++) {
			isDirectoryFound = false;
			for (Node childNode : tempPointer.getChildNodeList()) {
				if (directory[index + 1].equals(childNode.getDirectoryName())) {
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

	/**
	 * To find the directories present with specific name 
	 * @param currentDirectory
	 * @param directoryName
	 * @return list of all possible path from current working directory for directoryName 
	 */
	public List<String> findDirectory(Node currentDirectory,
			String directoryName) {
		if (currentDirectory == null || directoryName == null) {
			throw new AssertionError();
		}
		List<String> pathList = new ArrayList<String>();
		Queue<Node> bFSQueue = new LinkedList<Node>();
		Node tempNode = currentDirectory;
		bFSQueue.add(tempNode);
		while (!bFSQueue.isEmpty()) {
			tempNode = bFSQueue.remove();
			if (directoryName.equals(tempNode.getDirectoryName())) {
				pathList.add(tempNode.getDirectoryPath());
			}
			if (tempNode.getChildNodeList().size() != 0) {
				for (Node node : tempNode.getChildNodeList()) {
					bFSQueue.add(node);
				}
			}
		}
		return pathList;
	}
}
