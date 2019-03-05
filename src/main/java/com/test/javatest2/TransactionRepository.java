package com.test.javatest2;

import org.springframework.data.repository.CrudRepository;
import com.test.javatest2.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Integer>{

}
