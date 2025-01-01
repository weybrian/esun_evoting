package com.example.evoting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.evoting.common.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    // 用於調用 spGetAllItem 的存儲過程
    @Procedure(procedureName = "spGetAllItem")
    List<Item> getAllItem();

    // 用於調用 spInsertItem 的存儲過程
    @Procedure(procedureName = "spInsertItem")
    void insertItem(@Param("NAME") String name);
}
