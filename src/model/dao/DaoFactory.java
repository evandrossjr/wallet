package model.dao;

import db.DB;
import model.dao.impl.CategoryDaoJDBC;
import model.dao.impl.ExpenseDaoJDBC;
import model.dao.impl.PaymentMethodDaoJDBC;

public class DaoFactory {
	public static ExpenseDao createExpenseDao() {
		return new ExpenseDaoJDBC(DB.getConnection());
	}
	
	public static CategoryDao createCategoryDao() {
		return new CategoryDaoJDBC(DB.getConnection());
	}
	
	public static PaymentMethodDao createPaymentMethodDao() {
		return new PaymentMethodDaoJDBC(DB.getConnection());
	}
	
	

}
