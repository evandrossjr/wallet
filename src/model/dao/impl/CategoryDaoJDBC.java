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
import model.dao.CategoryDao;
import model.entities.Category;

public class CategoryDaoJDBC implements CategoryDao{
	private Connection conn;
	
	public CategoryDaoJDBC(Connection conn) {
		this.conn = conn;
		
	}
		

		@Override
		public void insert(Category obj) {
			PreparedStatement st = null;
			
			try {
				st = conn.prepareStatement(""
						+ "INSERT INTO category \r\n"
						+ "(name_category) \r\n"
						+ "VALUES \r\n"
						+ "(?)",
						Statement.RETURN_GENERATED_KEYS);
				
				
				st.setString(1, obj.getName_category());
			
				
				
				int rowsAffected = st.executeUpdate();
				
				if(rowsAffected > 0) {
					ResultSet rs = st.getGeneratedKeys();
					if(rs.next()) {
						int id = rs.getInt(1);
						obj.setId_category(id);
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
		public void update(Category obj) {
			PreparedStatement st = null;

			try {
				st = conn.prepareStatement(
						"UPDATE category "
						+ "SET name_category = ? "
						+ "WHERE  id_category = ? ",
						Statement.RETURN_GENERATED_KEYS);
				
				
				st.setString(1, obj.getName_category());
				st.setInt(2, obj.getId_category());
				
				st.executeUpdate();
				
			} 
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
			
			
		}


		@Override
		public void deleteById(Integer id) {
			PreparedStatement st = null;
			
			try {
				st = conn.prepareStatement("DELETE FROM category WHERE id_category = ?");
				
				st.setInt(1, id);
				
				st.executeUpdate();		
				
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closeStatement(st);
			}
			
		}


		@Override
		public Category findById(Integer id) {
			PreparedStatement st = null;
			ResultSet rs = null;
			
			
			try {
				st = conn.prepareStatement(""
						+ "SELECT * FROM category WHERE category.id_category = ?");
				
				st.setInt(1, id);
				
				rs = st.executeQuery();
				
				if(rs.next()) {
					Category category = instantiateCategory(rs);
					return category;
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


		private Category instantiateCategory(ResultSet rs) throws SQLException {
			Category category = new Category();
			category.setId_category(rs.getInt("id_category"));
			category.setName_category(rs.getString("name_category"));
			return category;
		}


		@Override
		public List<Category> findAll() {
			PreparedStatement st = null;
			ResultSet rs = null;
			
			try {
				st = conn.prepareStatement("SELECT * FROM category ORDER BY id_category");
				
				rs = st.executeQuery();
				
				
				List<Category> list = new ArrayList<>();
				
				while(rs.next()) {
					Category category = instantiateCategory(rs);
					list.add(category);
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
	

	
