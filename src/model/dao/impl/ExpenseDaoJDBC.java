package model.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(""
					+ "INSERT INTO expense \r\n"
					+ "(name_expense, date, value_expense, parcels_expense, id_category, id_payment_method) \r\n"
					+ "VALUES \r\n"
					+ "(?, ? , ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			
			st.setString(1, obj.getName());
			st.setDate(2, new java.sql.Date(obj.getExpenseDate().getTime()));
			st.setDouble(3, obj.getValue_expense());
			st.setInt(4, obj.getParcels());
			st.setInt(5, obj.getCategory().getId_category());
			st.setInt(6, obj.getPayment_method().getId());
			
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId_expense(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Unexpected Error! No rows affected");
			}
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
			
		}	
		finally {
			DB.closeStatement(st);
		}
			
		
		
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

		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(
					"SELECT expense.*, category.name_category as CatName, payment_method.name_payment_method as payName \r\n"
					+ "FROM expense \r\n"
					+ "INNER JOIN category ON expense.id_category = category.id_category\r\n"
					+ "INNER JOIN payment_method ON expense.id_payment_method = payment_method.id_payment_method \r\n"
					+ "ORDER BY date");
			
			
			rs = st.executeQuery();
			
			List<Expense> list = new ArrayList<>();
			Map<Integer, Category> map = new HashMap<>();
			Map<Integer, PaymentMethod> map2 = new HashMap<>();
			
			
			while (rs.next()) {
				
				Category category = map.get(rs.getInt("id_category"));
				
				if(category == null) {
					category = instantiateCategory(rs);
					map.put(rs.getInt("id_category"), category);
					
				}
				
				
				PaymentMethod paymentMethod = map2.get(rs.getInt("id_payment_method"));
				
				if(paymentMethod == null) {
					paymentMethod = instantiatePaymentMethod(rs);
					map2.put(rs.getInt("id_payment_method"), paymentMethod);
					
				}
				
				Expense obj = instantiateExpense(rs, paymentMethod, category);
				list.add(obj);
				
				
				
			}
			return list;
		}
		catch (SQLException e){
			throw new DbException(e.getMessage());
			
		}	
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
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
