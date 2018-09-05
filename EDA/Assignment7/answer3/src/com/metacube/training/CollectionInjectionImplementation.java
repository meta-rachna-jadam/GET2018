package com.metacube.training;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionInjectionImplementation {
	
    List categoryList;
    Set  categorySet;
    Map  categoryMap;
    
    public void setCategoryList(List categoryList) {
        this.categoryList = categoryList;
    }
		   
    public List getCategoryList() {
        System.out.println("List Elements :"  + categoryList);
        return categoryList;
    }
		   
    public void setCategorySet(Set categorySet) {
        this.categorySet = categorySet;
    }
		   
    public Set getCategorySet() {
        System.out.println("Set Elements :"  + categorySet);
        return categorySet;
    }
		   
    public void setCategoryMap(Map categoryMap) {
        this.categoryMap = categoryMap;
    }
		   
    public Map getCategoryMap() {
        System.out.println("Map Elements :"  + categoryMap);
        return categoryMap;
    }
		   
}