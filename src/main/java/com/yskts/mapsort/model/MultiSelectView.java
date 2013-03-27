/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.mapsort.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author niwong
 */
public class MultiSelectView<K,V> {
    private final Map<K,Boolean> selectedItems;
    private final LinkedList<MultiSelectOption<K,V>> availableOptions;
    
    
    public MultiSelectView(Comparator<V> comparator) {
        selectedItems = new HashMap<K,Boolean>();
        availableOptions = new LinkedList<MultiSelectOption<K,V>>();
    }
    
    public void setSelected(K selected) {
        selectedItems.put(selected, Boolean.TRUE);
    }
    
    public void addOption(K key, V value) {
        selectedItems.put(key, Boolean.FALSE);
        availableOptions.add(new MultiSelectOption<K,V>(key, value));
    }
    
    public List<MultiSelectOption<K,V>> getAvailableOptions() {
        return availableOptions;
    }
    
    public void sort(final Comparator<MultiSelectOption<K,V>> comparator) {
        Collections.sort(availableOptions, comparator);
    }
}
