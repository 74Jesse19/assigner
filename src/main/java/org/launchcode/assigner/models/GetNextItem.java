package org.launchcode.assigner.models;

import java.util.List;

public class GetNextItem {

    private int itemIndex;

    private List<String> itemList;

    // Constructor with itemList
    public GetNextItem(List<String> itemList) {
        this.itemList = itemList;
        itemIndex = 0; // start at the first item.
    }

    /**
     * Get the current Item from the itemList
     * return the current item from the itemList or NULL if all the items are processed.
     */
    public String getItem() {
        if (itemIndex >= itemList.size()) {
            return null;    // end of list
        }
        return itemList.get(itemIndex);
    }

    /**
     * Get the next Item from the itemList
     * @return the next item from the itemList or NULL if all the items are processed.
     */
    public String getNextItem() {
        itemIndex ++;
        return getItem();
    }
}