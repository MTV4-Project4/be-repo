package com.walkers.sportslight.itemTransaction.domain.repository;

import com.walkers.sportslight.itemTransaction.domain.aggregate.ItemTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Long> {
}
