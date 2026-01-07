package com.expense.expense_tracker.service;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    // Fixed: Changed 'repo' to 'repository' to match the variable name above
    public Expense update(Long id, Expense newExpense) {
        return repository.findById(id).map(expense -> {
            expense.setTitle(newExpense.getTitle());
            expense.setAmount(newExpense.getAmount());
            return repository.save(expense);
        }).orElseThrow(() -> new RuntimeException("Expense not found with id: " + id));
    }

    // Fixed: Changed 'repo' to 'repository'
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }
    
    // Added: This helps the controller find a single expense
    public Expense getExpenseById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }
}