package com.example.evoting.common.model;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Vote {
	private String name;
	private int num;
	private int item_id;
	public Vote(String name, int num, int item_id) {
		super();
		this.name = name;
		this.num = num;
		this.item_id = item_id;
	}
}
