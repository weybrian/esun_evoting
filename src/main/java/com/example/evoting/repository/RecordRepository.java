package com.example.evoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.evoting.common.entity.Item;

@Repository
public interface RecordRepository extends JpaRepository<Item, Integer> {
	@Procedure(procedureName = "spPostRecord")
    void insertRecords(@Param("PERSON_NAME") String person_name, @Param("ITEM_ID") int item_id);
}
