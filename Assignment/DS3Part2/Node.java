

import java.util.ArrayList;
import java.util.List;

public class Node
{
    private List<Object> list;
    
    Node()
    {
        list = new ArrayList<Object>();
    }
    
    public void addElement(JSON element)
    {
        list.add(element);
    }
    
    public void addNode(Node node)
    {
        list.add(node);
    }
    
    public int getListSize()
    {
        return list.size();
    }
    
    public List<Object> getList()
    {
        return list;
    }
}
