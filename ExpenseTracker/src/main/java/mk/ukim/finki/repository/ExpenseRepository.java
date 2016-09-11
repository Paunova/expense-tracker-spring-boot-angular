package mk.ukim.finki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.domain.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
}