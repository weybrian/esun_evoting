package com.example.evoting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.evoting.common.entity.Item;
import com.example.evoting.common.model.Vote;
import com.example.evoting.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void insertItem(Item item) {
        itemRepository.insertItem(item.getName());  // 執行存儲過程
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.getAllItem();  // 執行存儲過程
    }

	public void updateItem(Long id, Item item) {
		itemRepository.updateItem(id, item.getName());
	}

	public void deleteItem(Long id) {
		itemRepository.deleteItem(id);
	}

	@Transactional(readOnly = true) //確保方法執行過程中資料庫連線保持開啟
	public List<Vote> getVotes() {
		List<Object[]> rawResults = itemRepository.getVotes();
        List<Vote> votes = new ArrayList<>();

        for (Object[] result : rawResults) {
            String name = (String) result[0];  // 第一列是 name
            int num = (Integer) result[1];     // 第二列是 num
            votes.add(new Vote(name, num));
        }

        return votes;
	}
}
