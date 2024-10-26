package com.kenedygondim.expense_manager.service;

import com.kenedygondim.expense_manager.model.ExpenseRegister;
import com.kenedygondim.expense_manager.repository.ExpenseManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseManagerService {
    private final ExpenseManagerRepository expenseManagerRepository;

    @Autowired
    public ExpenseManagerService(ExpenseManagerRepository expenseManagerRepository) {
        this.expenseManagerRepository = expenseManagerRepository;
    }
    public List<ExpenseRegister> getAllRegisters() {
        return expenseManagerRepository.findAll();
    }
}
