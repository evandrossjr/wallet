package model.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ExpenseDao;
import model.entities.Category;
import model.entities.Expense;
import model.entities.PaymentMethod;
import model.entities.Tag;

public class ExpenseDaoJDBC implements ExpenseDao{
	private Connection conn;
	
	public ExpenseDaoJDBC(Connection conn) {
		this.conn = conn;
		
		
	}

	@Override
	public void insert(Expense obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Expense obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Expense findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
					"SELECT expense.*, category.name_category as CatName, payment_method.name_payment_method as payName \r\n"
					+ "FROM expense \r\n"
					+ "INNER JOIN category ON expense.id_category = category.id_category\r\n"
					+ "INNER JOIN payment_method ON expense.id_payment_method = payment_method.id_payment_method \r\n"
					+ "WHERE expense.id_expense = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Category category = instantiateCategory(rs);
				PaymentMethod paymentMethod = instantiatePaymentMethod(rs);
				Expense obj = instantiateExpense(rs, paymentMethod, category);
				return obj;
				
				
				
			}
			return null;
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
			
		}	
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Expense instantiateExpense(ResultSet rs, PaymentMethod paymentMethod, Category category) throws SQLException {
		Expense obj = new Expense();
		obj.setId_expense(rs.getInt("id_expense"));
		obj.setName(rs.getString("name_expense"));
		obj.setExpenseDate(rs.getDate("date"));
		obj.setValue_expense(rs.getDouble("value_expense"));
		obj.setParcels(rs.getInt("parcels_expense"));
		obj.setPayment_method(paymentMethod);
		obj.setCategory(category);
		return obj;
		
	}

	private PaymentMethod instantiatePaymentMethod(ResultSet rs) throws SQLException {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setId(rs.getInt("id_payment_method"));
		paymentMethod.setName(rs.getString("payName"));
		return paymentMethod;
	}

	private Category instantiateCategory(ResultSet rs) throws SQLException {
		Category category = new Category();
		category.setId_category(rs.getInt("id_category"));
		category.setName_category(rs.getString("catName"));
		return category;
		
		}

	@Override
	public List<Expense> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findByTag(Tag tag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expense> findByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

}
