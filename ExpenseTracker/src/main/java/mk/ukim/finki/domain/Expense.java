package mk.ukim.finki.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="expenses")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long expense_id;
	
	@Column
	private int amount;
	
	@Column
	private String description;
	
	@Column
	private Date date;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="category_id", referencedColumnName="category_id")
	private Category category;

	public Long getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(Long expense_id) {
		this.expense_id = expense_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
