package com.expense.expense_tracker.controller;

import com.expense.expense_tracker.model.Expense;
import com.expense.expense_tracker.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <--- Ye wali line add karni hai
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class ExpenseViewController {

    private final ExpenseService service;

    public ExpenseViewController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/view-expenses")
    public String viewExpenses(Model model) {
        List<Expense> allExpenses = service.getAllExpenses();
        
        // Total Calculate karna
        double total = allExpenses.stream().mapToDouble(Expense::getAmount).sum();
        
        model.addAttribute("expenses", allExpenses);
        model.addAttribute("totalAmount", total);
        return "index";
    }

    @PostMapping("/add-from-ui")
    public String addFromUI(Expense expense) {
        service.saveExpense(expense);
        return "redirect:/view-expenses";
    }

    @GetMapping("/delete-expense/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/view-expenses";
    }
}