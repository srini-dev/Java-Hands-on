package com.srini.service;

import com.srini.model.MItem;

import java.util.List;


public interface ItemService {

    List<MItem> getItemList();

    MItem getItemById(int id);

    void addItem(MItem item);

    void editItem(MItem item);

    void deleteItem(MItem item);
}
