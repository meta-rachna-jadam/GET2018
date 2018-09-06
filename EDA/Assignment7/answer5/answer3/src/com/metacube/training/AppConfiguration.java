package com.metacube.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
	
    private CollectionInjectionImplementation collectionInjectionImplementation ;
    
    @Bean
    public CollectionInjectionImplementation collectionInjectionImplementation()
    {
    	collectionInjectionImplementation = new CollectionInjectionImplementation();
    	return collectionInjectionImplementation;
    }
    @Bean
    public CollectionInjectionImplementation getCategoryList() {
        List<String> categoryList = new ArrayList<String>();
        categoryList.add("Home");
        categoryList.add("Beauty");
        categoryList.add("Clothing");
        categoryList.add("Footwear");
        categoryList.add("Accessories");
        categoryList.add("Beauty");
        collectionInjectionImplementation.setCategoryList(categoryList);
        return collectionInjectionImplementation;
    }
    
    @Bean
    public CollectionInjectionImplementation getCategorySet() {
        Set<String> categorySet = new HashSet<String>();
        categorySet.add("Home");
        categorySet.add("Beauty");
        categorySet.add("Clothing");
        categorySet.add("Footwear");
        categorySet.add("Accessories");
        categorySet.add("Beauty");
        collectionInjectionImplementation.setCategorySet(categorySet);
        return collectionInjectionImplementation;
    }
    
    @Bean
    public CollectionInjectionImplementation getCategoryMap() {
        Map<Integer, String> categoryMap = new HashMap<Integer, String>();
        categoryMap.put(1, "Home");
        categoryMap.put(2, "Beauty");
        categoryMap.put(3, "Clothing");
        categoryMap.put(4, "Footwear");
        categoryMap.put(5, "Accessories");
        categoryMap.put(6, "Beauty");
        collectionInjectionImplementation.setCategoryMap(categoryMap);
        return collectionInjectionImplementation;
    }

}
