package application;

import model.dao.DaoFactory;
import model.dao.ExpenseDao;
import model.entities.Expense;

public class Program {

	public static void main(String[] args) {

		ExpenseDao expenseDao = DaoFactory.createExpenseDao();
		
		System.out.println("===TEST 1: expense findById ====");
		Expense expense = expenseDao.findById(2);
		System.out.println(expense);
	}

}
