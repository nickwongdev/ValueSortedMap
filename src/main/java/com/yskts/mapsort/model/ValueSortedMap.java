/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.mapsort.model;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author niwong
 */
public class ValueSortedMap<K,V> implements Map<K,V> {
    
    private LinkedList<K> keys;
    private LinkedList<V> values;
    private int size;
    private Comparator<V> comparator;
    
    public ValueSortedMap(Comparator<V> comparator) {
        this.keys = new LinkedList<K>();
        this.values = new LinkedList<V>();
        this.size = 0;
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }

    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    public V get(Object key) {
        return values.get(keys.indexOf(key));
    }

    public V put(K key, V value) {
        int insert = 0;
        if(comparator != null) {
            // Simple insertion if it is small
            if(values.size() <= 8) {
                insert = iterativeSearch(value);
            } 
            // Binary search if it is large.
            else {
                insert = binarySearch(value);
            }
            
        } 
        keys.add(insert, key);
        values.add(insert, value);
        this.size += 1;
        return value;
    }

    public V remove(Object key) {
        V value = values.remove(keys.indexOf(key));
        keys.remove(key);
        this.size -= 1;
        return value;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        for(K key : m.keySet()) {
            this.put(key, m.get(key));
        }
    }

    public void clear() {
        keys.clear();
        values.clear();
        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = new LinkedHashSet<K>();
        for(int i = 0; i < keys.size(); i++) {
            keySet.add(keys.get(i));
        }
        return keySet;
    }

    public Collection<V> values() {
        return values;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<Entry<K, V>>();
        
        return entrySet;
    }

    private int iterativeSearch(V value) {
        int i;
        int end = values.size() - 1;
        
        
        
        // Quick check begin or end
        if(comparator.compare(value, values.get(0)) < 0) {
            return 0;
        }
        
        // 
        if(comparator.compare(value, values.get(end)) > 0) {
            return end;
        }
        
        for(i = 1; i < values.size() - 1; i++) {
            V curValue = values.get(i);
            if(comparator.compare(curValue, value) >= 0) {
                break;
            }
        }
        return i;
    }
    
    private int binarySearch(V value) {
        int end = values.size() - 1;
        int begin = 0;
        
        // Quick check begin or end
        if(comparator.compare(value, values.get(0)) < 0) {
            return 0;
        }

        if(comparator.compare(value, values.get(end)) > 0) {
            return end;
        }
        
        int middle = end / 2;

        while(true) {
            int compare = comparator.compare(value, values.get(middle));
            // Check right half
            if(compare > 0) {
                end = middle;
                middle = (begin - end) / 2;
            } 
            // Check left half
            else if (compare < 0) {
                begin = middle;
                middle = (begin - end) / 2;
            } 
            // found exact match
            else {
                return middle;
            }
        }
    }
}
