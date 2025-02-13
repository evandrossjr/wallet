package application;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.entities.Category;

public class Program2 {

	public static void main(String[] args) {

		CategoryDao categoryDao = DaoFactory.createCategoryDao();
		
		System.out.println("==== TEST 1: expense findById ====");
		Category category = categoryDao.findById(3);
		
		System.out.println(category);
		
		
	}

}
