/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.valuesortedmap.model;

import java.util.Comparator;

/** @author niwong */
public class ItemComparator implements Comparator<Item> {

	public int compare(Item o1, Item o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
