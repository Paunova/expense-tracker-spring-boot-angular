package mk.ukim.finki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mk.ukim.finki.domain.Expense;

@RepositoryRestResource
public interface ExpenseRepository extends JpaRepository<Expense, Long> {}