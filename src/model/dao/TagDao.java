package model.dao;

import java.util.List;

import model.entities.Expense;

public interface TagDao {
	void insert(Expense obj);
	void update(Expense obj);
	void deleteById(Integer id);
	Expense findById(Integer id);
	List<Expense> findAll();

}
