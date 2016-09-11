package mk.ukim.finki.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mk.ukim.finki.domain.Expense;
import mk.ukim.finki.repository.ExpenseRepository;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins="http://localhost:9000")
public class ExpenseController {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@RequestMapping("")
	public List<Expense> getAll() {
		return expenseRepository.findAll();
	}
	
	@RequestMapping(value="/{id}")
	public Expense getOne(@PathVariable Long id) {
		return expenseRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody Expense expense) {
		expenseRepository.save(expense);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void remove(@RequestParam Long expense_id) {
		expenseRepository.delete(expense_id);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public void update(@RequestBody Expense expense) {
		expenseRepository.save(expense);
	}
}
