package model.dao;

import db.DB;
import model.dao.impl.CategoryDaoJDBC;
import model.dao.impl.ExpenseDaoJDBC;

public class DaoFactory {
	public static ExpenseDao createExpenseDao() {
		return new ExpenseDaoJDBC(DB.getConnection());
	}
	
	public static CategoryDao createCategoryDao() {
		return new CategoryDaoJDBC(DB.getConnection());
	}
	
	

}
