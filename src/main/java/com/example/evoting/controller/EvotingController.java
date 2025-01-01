package com.example.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.evoting.common.entity.Item;
import com.example.evoting.service.ItemService;

@RestController
public class EvotingController {
	@Autowired
	ItemService service;

	@GetMapping("/items")
    public List<Item> getAllItems() {
        return service.getAllItems();//要在瀏覽器顯示 json，可 return object 或 list
    }

	@PostMapping("/item")
    public void insertItem() {
		service.insertItem("鍵盤");
    }

	@PutMapping("/item/{id}")
    public void updateItem(@RequestBody Item item, @PathVariable Long id) {
		service.updateItem(id, item);
    }
	
	
}
