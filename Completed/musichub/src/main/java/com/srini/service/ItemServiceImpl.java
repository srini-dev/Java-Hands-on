package com.srini.service;

import com.srini.dao.ItemDao;
import com.srini.model.MItem;
import com.srini.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    public MItem getItemById (int itemId) {
        return itemDao.getItemById(itemId);
    }

    public List<MItem> getItemList () {
        return itemDao.getItemList();
    }

    public void addItem(MItem item) {
    	itemDao.addItem(item);
    }

    public void editItem(MItem item) {
    	itemDao.editItem(item);
    }

    public void deleteItem(MItem item) {
    	itemDao.deleteItem(item);
    }
}
