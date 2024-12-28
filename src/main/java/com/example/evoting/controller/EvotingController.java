package com.example.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.evoting.common.entity.Item;
import com.example.evoting.repository.ItemRepository;

@RestController
public class EvotingController {
	@Autowired
	ItemRepository itemRepository;

	@GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.getAllItem();
    }
}
