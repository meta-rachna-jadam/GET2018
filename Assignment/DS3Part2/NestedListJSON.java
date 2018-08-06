import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class NestedList
{
    public static Node createNestedListFromJSONString(String jsonString)
    {           
        Object obj=JSONValue.parse(jsonString);  
        JSONObject jsonObject = (JSONObject) obj;  
    	
        String firstName = (String) jsonObject.get("firstName");  
        String lastName = (String) jsonObject.get("lastName");  
        String age = ""+ jsonObject.get("age");  
        Node node1 = new Node();
        node1.addElement(new JSON("firstName",firstName));
        node1.addElement(new JSON("lastName",lastName));
        node1.addElement(new JSON("age",age));
        
        JSONObject address =  (JSONObject) jsonObject.get("address");  
        String streetAddress = (String) address.get("streetAddress");  
        String city = (String) address.get("city");  
        String state = (String) address.get("state");  
        String postalCode = (String) address.get("postalCode");  
        Node node2 = new Node();
        node2.addElement(new JSON("streetAddress",streetAddress));
        node2.addElement(new JSON("city",city));
        node2.addElement(new JSON("state",state));
        node2.addElement(new JSON("postalCode",postalCode));
        node1.addNode(node2);
        
        return node1;
    }
    
    public static void traverseList(Node n) 
    {
        int len = n.getListSize();
        List<Object> l = n.getList();
        for (int i = 0; i < len; i++) 
        {
            if(l.get(i) instanceof JSON)
            {
                System.out.println(((JSON)l.get(i)).getKey()+" : "+((JSON)l.get(i)).getValue());    
            }
            if(l.get(i) instanceof Node)
            {
                traverseList((Node)l.get(i));
            }
        }
    }
    
    public static void main(String[] args)
    {
    	String jsonString = "{\"firstName\": \"Sonoo\",\"lastName\": \"Jaiswal\",\"age\": 27,"+  
    		     "\"address\" : {\"streetAddress\": \"Plot-6, Mohan Nagar\",  \"city\": \"Ghaziabad\","+  
    		         "\"state\": \"UP\",\"postalCode\":\"201007\"}}";  
        Node n = createNestedListFromJSONString(jsonString);
        
        traverseList(n);
    }
}
