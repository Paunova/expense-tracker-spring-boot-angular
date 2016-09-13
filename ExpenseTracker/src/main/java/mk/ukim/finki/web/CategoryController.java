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

import mk.ukim.finki.domain.Category;
import mk.ukim.finki.repository.CategoryRepository;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins="http://localhost:9000")
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping("")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	
	@RequestMapping(value="/{id}")
	public Category getOne(@PathVariable Long id) {
		return categoryRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody Category category) {
		categoryRepository.save(category);
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public void remove(@RequestParam Long category_id) {
		categoryRepository.delete(category_id);
	}
}