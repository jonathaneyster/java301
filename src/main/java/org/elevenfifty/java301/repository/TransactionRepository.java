package org.elevenfifty.java301.repository;

import org.elevenfifty.java301.beans.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>
{

}
