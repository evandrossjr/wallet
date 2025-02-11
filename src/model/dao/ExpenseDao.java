package model.dao;

import java.util.List;

import model.entities.Category;
import model.entities.Expense;
import model.entities.PaymentMethod;
import model.entities.Tag;

public interface ExpenseDao {
	void insert(Expense obj);
	void update(Expense obj);
	void deleteById(Integer id);
	Expense findById(Integer id);
	List<Expense> findAll();
	List<Expense> findByPaymentMethod(PaymentMethod paymentMethod);
	List<Expense> findByCategory(Category category);
	

}
