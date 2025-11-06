package com.example.mm.repositores;

import com.example.mm.entities.ExpenseRecord;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRecordRepository extends CrudRepository<ExpenseRecord, Integer> {
}
