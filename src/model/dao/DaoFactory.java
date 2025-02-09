package model.dao;

import db.DB;
import model.dao.impl.ExpenseDaoJDBC;

public class DaoFactory {
	public static ExpenseDao createExpenseDao() {
		return new ExpenseDaoJDBC(DB.getConnection());
	}
	
	

}
