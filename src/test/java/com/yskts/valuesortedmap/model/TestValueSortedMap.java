/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yskts.valuesortedmap.model;

import com.yskts.valuesortedmap.ValueSortedMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author niwong
 */
public class TestValueSortedMap {
	private static String[] alphabet = new String[26];

	@BeforeClass
	public static void beforeClass() {
		alphabet[0] = "a";
		alphabet[1] = "b";
		alphabet[2] = "c";
		alphabet[3] = "d";
		alphabet[4] = "e";
		alphabet[5] = "f";
		alphabet[6] = "g";
		alphabet[7] = "h";
		alphabet[8] = "i";
		alphabet[9] = "j";
		alphabet[10] = "k";
		alphabet[11] = "l";
		alphabet[12] = "m";
		alphabet[13] = "n";
		alphabet[14] = "o";
		alphabet[15] = "p";
		alphabet[16] = "q";
		alphabet[17] = "r";
		alphabet[18] = "s";
		alphabet[19] = "t";
		alphabet[20] = "u";
		alphabet[21] = "v";
		alphabet[22] = "w";
		alphabet[23] = "x";
		alphabet[24] = "y";
		alphabet[25] = "z";
	}

    @Before
    public void beforeTest() {
    }

	@Test
    public void testValueSortedMap() {
		ValueSortedMap<String, Item> itemMap = new ValueSortedMap<String, Item>(new ItemComparator());
		Random random = new Random();

		Boolean randArray[] = new Boolean[26];
		for(int j = 0; j < 26; j++) {
			randArray[j] = false;
		}

		int randIndex = 0;
		for(int i = 0; i < 26 * 2; i++) {
			String uuid = UUID.randomUUID().toString();

			while(true) {
				randIndex = Math.abs(random.nextInt() % 26);
				if(randArray[randIndex] == false) {
					randArray[randIndex] = true;
					break;
				}
			}
			itemMap.put(uuid, new Item(String.valueOf(i), alphabet[randIndex]));

			if(i == 25) {
				for(int j = 0; j < 26; j++) {
					randArray[j] = false;
				}
			}
		}

		int count = 0;
		for(String key : itemMap.keySet()) {
			int index = count / 2;
			System.out.println("Index: " + index + " Key: " + key + " = " + itemMap.get(key));
			Assert.assertEquals(itemMap.get(key).getName(), alphabet[index]);
			count++;
		}

		String previousKey = null;
		List<String> keysToRemove = new ArrayList<String>();

		for(String key : itemMap.keySet()) {

			if(previousKey == null) {
				previousKey = key;
				continue;
			}

			if(itemMap.get(previousKey).getName().equals(itemMap.get(key).getName())) {
				keysToRemove.add(previousKey);
			}

			previousKey = key;
		}

		for(String key : keysToRemove) {
			itemMap.remove(key);
		}

		count = 0;
		for(String key : itemMap.keySet()) {
			int index = count;
			System.out.println("Index: " + index + " Key: " + key + " = " + itemMap.get(key));
			Assert.assertEquals(itemMap.get(key).getName(), alphabet[index]);
			count++;
		}
    }

	@Test
	public void testGetEntrySet() {
		Random random = new Random();
		int randIndex = 0;
		Boolean randArray[] = new Boolean[26];
		ValueSortedMap<String, Item> itemMap = new ValueSortedMap<String, Item>(new ItemComparator());

		for(int j = 0; j < 26; j++) {
			randArray[j] = false;
		}

		for(int i = 0; i < 26; i++) {
			String uuid = UUID.randomUUID().toString();

			while(true) {
				randIndex = Math.abs(random.nextInt() % 26);
				if(randArray[randIndex] == false) {
					randArray[randIndex] = true;
					break;
				}
			}
			itemMap.put(uuid, new Item(String.valueOf(i), alphabet[randIndex]));
		}

		Set<Map.Entry<String, Item>> entrySet = itemMap.entrySet();
		int i = 0;
		for(Map.Entry<String, Item> entry : entrySet) {
			Assert.assertEquals(alphabet[i], entry.getValue().getName());
			i++;
		}
	}
}
