package model.dao;

import java.util.List;

import model.entities.Category;

public interface CategoryDao {
	void insert(Category category);
	void update(Category category);
	void deleteById(Integer id);
	Category findById(Integer id);
	Category findByName(String name);
	List<Category> findAll();

}
