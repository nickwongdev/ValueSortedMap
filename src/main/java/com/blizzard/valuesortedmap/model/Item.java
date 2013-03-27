/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blizzard.valuesortedmap.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author niwong
 */
@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Item {
    private String id;
    private String name;
}
