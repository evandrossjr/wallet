package application;

import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

import model.dao.DaoFactory;
import model.dao.ExpenseDao;
import model.entities.Expense;
import model.entities.PaymentMethod;

public class Program {

	public static void main(String[] args) {

		ExpenseDao expenseDao = DaoFactory.createExpenseDao();
		
		System.out.println("==== TEST 1: expense findById ====");
		Expense expense = expenseDao.findById(2);
		System.out.println(expense);
		
		
		
		System.out.println("==== TEST 2: expense findAl() ====");
		List<Expense> list = expenseDao.findAll();
		for (Expense obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 3: expense findByCategory ====");
		model.entities.Category category = new model.entities.Category(3, null);
		list = expenseDao.findByCategory(category);
		for (Expense obj : list) {
			System.out.println(obj);
		}
		
		
		
		
		
		System.out.println("==== TEST 4: expense findByPaymentMethod ====");
		PaymentMethod paymentoMethod = new PaymentMethod(2, null);
		list = expenseDao.findByPaymentMethod(paymentoMethod);
		for (Expense obj : list) {
			System.out.println(obj);
		}
		
		
		System.out.println("==== TEST 5: expense insert ====");
		Expense newExpense = new Expense(null, "Café de rico", new Date(), 219.0, 2, paymentoMethod, category);
		//expenseDao.insert(newExpense);
		System.out.println("Inserted New in: " + newExpense.getName());
		
		
		System.out.println("==== TEST 6: expense delete ====");
		expenseDao.deleteById(5);
		
		System.out.println("Deleted!");
		
		
		System.out.println("==== TEST 6: expense update ====");
		expense = expenseDao.findById(5);
		//expense.setName("café alterado");
		//expenseDao.update(expense);
		System.out.println("Update completed");
	}

}
