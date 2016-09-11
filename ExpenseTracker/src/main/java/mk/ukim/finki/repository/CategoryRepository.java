package mk.ukim.finki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{ }
