/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.mapsort.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author niwong
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SelectedItem<K> {
    private K key;
    private boolean selected;
    
}