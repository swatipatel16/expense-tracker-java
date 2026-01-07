package com.expense.expense_tracker.controller;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    @PostMapping
    public Expense add(@Valid @RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
        Expense result = service.update(id, updatedExpense);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted Successfully";
    }
    
    
}