package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.PaymentMethodDao;
import model.entities.Category;
import model.entities.PaymentMethod;

public class PaymentMethodDaoJDBC implements PaymentMethodDao{
	
	private Connection conn = null;
	
	public PaymentMethodDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(PaymentMethod paymentMethod) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(""
					+ "INSERT INTO payment_method \r\n"
					+ "(name_payment_method) \r\n"
					+ "VALUES \r\n"
					+ "(?)",
					Statement.RETURN_GENERATED_KEYS);
			
			
			st.setString(1, paymentMethod.getName());
		
			
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					paymentMethod.setId(id);
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
	public void update(PaymentMethod paymentMethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentMethod findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		
		try {
			st = conn.prepareStatement(""
					+ "SELECT * FROM payment_method WHERE payment_method.id_payment_method = ?");
			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				PaymentMethod paymentMethod = instantiatePaymentMethod(rs);
				return paymentMethod;
			}
			return null;
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private PaymentMethod instantiatePaymentMethod(ResultSet rs) throws SQLException {

		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setId(rs.getInt("id_payment_method"));
		paymentMethod.setName(rs.getString("name_payment_method"));
		
		return paymentMethod;
	}

	@Override
	public List<PaymentMethod> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT * FROM payment_method ORDER BY id_payment_method");
			
			rs = st.executeQuery();
			
			
			List<PaymentMethod> list = new ArrayList<>();
			
			while(rs.next()) {
				PaymentMethod paymentMethod  = instantiatePaymentMethod(rs);
				list.add(paymentMethod);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	
	}

}
