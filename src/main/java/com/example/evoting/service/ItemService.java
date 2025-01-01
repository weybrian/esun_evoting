package com.example.evoting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.evoting.common.entity.Item;
import com.example.evoting.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void insertItem(String name) {
        itemRepository.insertItem(name);  // 執行存儲過程
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.getAllItem();  // 執行存儲過程
    }

	public void updateItem(Long id, Item item) {
		itemRepository.updateItem(id, item.getName());
	}
}
