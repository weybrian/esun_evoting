package com.example.evoting.common.model;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Vote {
	private String name;
	private int num;
	public Vote(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
}
