package com.example.evoting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.evoting.common.entity.Item;
import com.example.evoting.service.ItemService;

@Controller
public class EvotingController {
	@Autowired
	ItemService service;
	
	@GetMapping("/evoting")
	public String index() {
		return "index";
	}

	@GetMapping("/items")
    @ResponseBody
    public List<Item> getAllItems() {
        return service.getAllItems();//要在瀏覽器顯示 json，可 return object 或 list
    }

	@PostMapping("/item")
    @ResponseBody
    public void insertItem(@RequestBody Item item) {
		service.insertItem(item);
    }

	@PutMapping("/item/{id}")
    @ResponseBody
    public void updateItem(@RequestBody Item item, @PathVariable Long id) {
		service.updateItem(id, item);
    }
	
	@DeleteMapping("/item/{id}")
    @ResponseBody
	public void deleteItem(@PathVariable Long id) {
		service.deleteItem(id);
	}
}
