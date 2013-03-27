/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.mapsort;

import com.yskts.mapsort.model.Item;
import com.yskts.mapsort.model.ItemComparator;
import com.yskts.mapsort.model.MultiSelectView;
import com.yskts.mapsort.model.ValueSortedMap;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author niwong
 */
public class AppService {
    public void generateMultiSelectView() {
        ValueSortedMap<String, Item> itemMap = new ValueSortedMap<String, Item>(new ItemComparator());
        
        itemMap.put("1", new Item("1", "z"));
        for(String key : itemMap.keySet()) {
            System.out.println(key + " = " + itemMap.get(key));
        }
        System.out.println("-------------------");
        itemMap.put("2", new Item("2", "a"));
        for(String key : itemMap.keySet()) {
            System.out.println(key + " = " + itemMap.get(key));
        }
        System.out.println("-------------------");
        itemMap.put("3", new Item("3", "c"));
        for(String key : itemMap.keySet()) {
            System.out.println(key + " = " + itemMap.get(key));
        }
        System.out.println("-------------------");
        itemMap.put("4", new Item("4", "b"));
        for(String key : itemMap.keySet()) {
            System.out.println(key + " = " + itemMap.get(key));
        }
        System.out.println("-------------------");
        
    }
}
