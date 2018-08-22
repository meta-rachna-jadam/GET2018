/**
 * This class maintain some properties of parent category
 * @author Rachna Jadam
 *
 */
public class ParentCategory {

	private int id;
    private String name;
    private int numberOfChild;
    
    public ParentCategory(int id, String name, int numberOfChild){
    	this.id = id;
    	this.name = name;
    	this.numberOfChild = numberOfChild;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfChild() {
		return numberOfChild;
	}
	public void setNumberOfChild(int numberOfChild) {
		this.numberOfChild = numberOfChild;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}
