import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Node {

    private final String directoryName;
    private List<Node> childNodeList;
    private String creationDateAndTime;
    
    public Node(String directoryName) {
        this.directoryName = directoryName;
        this.childNodeList = new ArrayList<Node>();
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/YYYY hh.mm.ss aa");
		Date date = new Date();
        creationDateAndTime = dateTimeFormat.format(date);
    }
    
	public String getDirectoryName() {
		return directoryName;
	}
	
	public List<Node> getChildNodeList() {
		return childNodeList;
	}
	
	public void addChildNodeInChildList(Node childNode) {
		this.childNodeList.add(childNode);
	}

	public String getCreationDateAndTime() {
		return creationDateAndTime;
	}

	public void setCreationDateAndTime() {
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/YYYY hh.mm.ss.S aa");
		Date date = new Date();
		creationDateAndTime = dateTimeFormat.format(date);
	}

}
