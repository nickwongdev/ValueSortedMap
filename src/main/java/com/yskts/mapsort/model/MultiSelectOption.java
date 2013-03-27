/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.mapsort.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author niwong
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class MultiSelectOption<K,V> {
    private K key;
    private V value;
}
