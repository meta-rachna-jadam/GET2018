
public class Node {
    private int data;
    private final int priority;
    public Node(int data, int priority) {
    	this.setData(data);
    	this.priority = priority;
    }
	public int getPriority() {
		return priority;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
}
