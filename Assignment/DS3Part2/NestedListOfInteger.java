import java.util.ArrayList;
import java.util.List;

public class NestedListOfInteger implements NestedList {

	private static Node head;
	private Node tempPointerForParent;
	private Node tempPointerForChild;

	static class Node {

		int data;
		int index;
		static int tempIndex = -1;
		Node next, child;

		Node(int d) {

			data = d;
			index = tempIndex;
			next = child = null;
		}
	}

	public NestedListOfInteger() {
		this.head = null;
		this.tempPointerForParent = null;
		this.tempPointerForChild = null;
	}

	/**
	 * This create a parent node in parent list
	 * @param data
	 */
	public void createParentNode(int data) {
		Node.tempIndex++;
		Node previousNodePointer = tempPointerForParent;
		tempPointerForParent = new Node(data);
		tempPointerForParent.next = null;
		tempPointerForParent.child = null;
		if (head == null) {
			head = tempPointerForParent;
		} else {
			previousNodePointer.next = tempPointerForParent;
		}
	}

	/**
	 * This create a child node in child list
	 * @param parentIndex
	 * @param childData
	 */
	public void createChildNode(int parentIndex, int childData) {
		if (parentIndex >= size()) {
			throw new AssertionError("Index out of bound error");
		}
		Node parentNode = getParent(parentIndex);
		Node childNodePointer = parentNode.child;
		Node previousNode = null;
		Node newNode = new Node(childData);
		newNode.next = null;
		newNode.child = null;
		if (childNodePointer == null) {
			parentNode.child = newNode;
			newNode.index = 0;
		} else {
			int count = -1;
			while (childNodePointer.next != null) {
				count++;
				childNodePointer = childNodePointer.next;
			}
			childNodePointer.next = newNode;
			childNodePointer.index = count + 1;
		}
	}

	/**
	 * This return the size of parent list
	 * @return
	 */
	public int size() {
		return (Node.tempIndex + 1);
	}

	/**
	 * This return the size of child list
	 * @return
	 */
	public int getSizeOfChild(int parentIndex) {
		if (parentIndex >= size()) {
			throw new AssertionError("Index Out of bound");
		}
		Node pointer = getParent(parentIndex).child;
		int size = 1;
		while (pointer.next != null) {
			size++;
			pointer = pointer.next;
		}
		return size;
	}

	/**
	 * return the head of the nested list
	 * @return
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * This return reference of parent node at a spesific index 
	 * @param index
	 * @return
	 * @throws AssertionError if index is not valid
	 */
	public Node getParent(int index) throws AssertionError {
		if (index >= size()) {
			throw new AssertionError("Index Out of bound");
		}
		Node pointer = head;
		for (int listIndex = 0; listIndex < index; listIndex++) {
			pointer = pointer.next;
		}
		return pointer;
	}

	/**
	 * This return reference of chld node at a spesific index of parent list and child list
	 * @param index
	 * @return
	 * @throws AssertionError if index is not valid
	 */
	public Node getChild(int parentIndex, int childIndex) throws AssertionError {
		if (parentIndex >= size() || childIndex >= getSizeOfChild(parentIndex)) {
			throw new AssertionError("Index Out of bound");
		}
		Node pointer = getParent(parentIndex).child;
		for (int listIndex = 0; listIndex < childIndex; listIndex++) {
			pointer = pointer.next;
		}
		return pointer;
	}

	/**
	 * This return value of parent node at a spesific index 
	 * @param index
	 * @return
	 * @throws AssertionError if index is not valid
	 */
	public int getDataOfParent(int index) throws AssertionError {
		if (index >= size()) {
			throw new AssertionError("Index Out of bound");
		}
		return getParent(index).data;

	}

	/**
	 * This return value of chld node at a spesific index of parent list and child list
	 * @param index
	 * @return
	 * @throws AssertionError if index is not valid
	 */
	public int getDataOfChild(int parentIndex, int childIndex)
			throws AssertionError {
		if (parentIndex >= size() || childIndex >= getSizeOfChild(parentIndex)) {
			throw new AssertionError("Index Out of bound");
		}
		return getChild(parentIndex, childIndex).data;

	}

	/**
	 * return the sum of each element present in nested list
	 */
	@Override
	public int getSum() {
		int sum = 0;
		for (int parentIndex = 0; parentIndex < size(); parentIndex++) {
			sum += getDataOfParent(parentIndex);
			for (int childIndex = 0; childIndex < getSizeOfChild(parentIndex); childIndex++) {
				sum += getDataOfChild(parentIndex, childIndex);
			}
		}
		return sum;
	}

	/**
	 * Return the largest element from all child lists
	 */
	@Override
	public int getLargestElement() {
		int largestValueFromTheNestedList = 0;
		for (int parentIndex = 0; parentIndex < size(); parentIndex++) {
			for (int childIndex = 0; childIndex < getSizeOfChild(parentIndex); childIndex++) {
				if (getDataOfChild(parentIndex, childIndex) > largestValueFromTheNestedList) {
					largestValueFromTheNestedList = getDataOfChild(parentIndex,
							childIndex);
				}
			}
		}
		return largestValueFromTheNestedList;
	}

	/**
	 * This search the specific element in nested linked list
	 * @return true if element found, otherwise false
	 */
	@Override
	public boolean search(int searchingValue) {
		for (int parentIndex = 0; parentIndex < size(); parentIndex++) {
			if (getDataOfParent(parentIndex) == searchingValue) {
				return true;
			}
			for (int childIndex = 0; childIndex < getSizeOfChild(parentIndex); childIndex++) {
				if (getDataOfChild(parentIndex, childIndex) == searchingValue) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public int getValue(List<Node> nodeList, String value) throws AssertionError{
		int result = 0;
		Node head = nodeList.get(0).child;
		Node tempPointer = head;
		List<Node> tail = new ArrayList<Node>();
		while (tempPointer != null){
			tempPointer = tempPointer.next;
			tail.add(tempPointer);
		}
		try{
		if (value.charAt(0) == 'T') {
			for (int charIndex = 1; charIndex < value.length(); charIndex++) {
				if (value.charAt(charIndex) != 'H'){
					throw new AssertionError("Invalid input");
				}
				
					head = tempPointer = tail.get(0);
					tail.removeAll(tail);
					while (tempPointer != null){
						tempPointer = tempPointer.next;
						tail.add(tempPointer);
					
				}
			}
			if (head.child == null) {
				return head.data;
			} else {
				throw new AssertionError("Invalid input");
			}
		}}
		catch(NullPointerException e){
			throw new AssertionError("Invalid input");
		}
	
		return result;
	}
}
