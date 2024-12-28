package com.example.evoting.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ITEM_ID;

    @Column
    private String name;
}
