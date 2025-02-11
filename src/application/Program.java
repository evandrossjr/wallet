package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.ExpenseDao;
import model.entities.Expense;

public class Program {

	public static void main(String[] args) {

		ExpenseDao expenseDao = DaoFactory.createExpenseDao();
		
		System.out.println("===TEST 1: expense findById ====");
		Expense expense = expenseDao.findById(2);
		System.out.println(expense);
		
		
		
		System.out.println("TEST 2: expense findAl()");
		List<Expense> list = expenseDao.findAll();
		for (Expense obj : list) {
			System.out.println(obj);
		}
	}

}
