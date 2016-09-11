package mk.ukim.finki;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import mk.ukim.finki.domain.Category;
import mk.ukim.finki.domain.Expense;
import mk.ukim.finki.repository.CategoryRepository;
import mk.ukim.finki.repository.ExpenseRepository;

@Component
public class DataInitializer implements CommandLineRunner{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		Category food = new Category();
		food.setName("Food");
		
		Category groceries = new Category();
		groceries.setName("Groceries");
		
		Category books = new Category();
		books.setName("Books");
		
		System.out.println("Command line runner --- inserting categories");
		categoryRepository.save(food);
		categoryRepository.save(groceries);
		categoryRepository.save(books);
		
		Expense pudding = new Expense();
		pudding.setAmount(20);
		pudding.setDescription("Pudding from KAM");
		pudding.setCategory(food);
		pudding.setDate(new Date());
		
		System.out.println("Command line runner --- inserting expense");
		expenseRepository.save(pudding);		
	}

}
