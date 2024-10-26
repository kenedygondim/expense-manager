package com.kenedygondim.expense_manager.repository;

import com.kenedygondim.expense_manager.model.ExpenseRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseManagerRepository extends JpaRepository<ExpenseRegister, Integer> {
}
