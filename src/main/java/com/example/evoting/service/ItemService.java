package com.example.evoting.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.evoting.common.XSSSanitizer;
import com.example.evoting.common.entity.Item;
import com.example.evoting.common.model.Vote;
import com.example.evoting.repository.ItemRepository;
import com.example.evoting.repository.RecordRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private RecordRepository recordRepository;

    @Transactional
    public void insertItem(Item item) {
        itemRepository.insertItem(XSSSanitizer.sanitize(item.getName()));  // 執行存儲過程
    }

    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.findByAllItem();  // 執行存儲過程
    }
    
    @Transactional 
	public void updateItem(Long id, Item item) {
		itemRepository.updateItem(id, XSSSanitizer.sanitize(item.getName()));
	}

    @Transactional 
	public void deleteItem(Long id) {
		itemRepository.deleteByItem(id);
	}

	@Transactional(readOnly = true) //確保方法執行過程中資料庫連線保持開啟
	public List<Vote> getVotes() {
		List<Object[]> rawResults = itemRepository.findByVotes();
        List<Vote> votes = new ArrayList<>();

        for (Object[] result : rawResults) {
            String name = (String) result[0];  // 第一列是 name
            int num = (Integer) result[1];     // 第二列是 num
            int item_id = (Integer) result[2];
            votes.add(new Vote(name, num, item_id));
        }

        return votes;
	}

	@Transactional 
	public void insertRecords(String votePerson, int[] item_ids) {
		for (int item_id : item_ids) {
			recordRepository.insertRecords(votePerson, item_id);
		}
	}
}
