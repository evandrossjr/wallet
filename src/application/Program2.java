package application;

import java.util.List;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.entities.Category;

public class Program2 {

	public static void main(String[] args) {

		CategoryDao categoryDao = DaoFactory.createCategoryDao();
		
		System.out.println("==== TEST 1: expense findById ====");
		Category category = categoryDao.findById(3);
		
		System.out.println(category);
		
		System.out.println("==== TEST 2: expense findAl() ====");
		
		
		List<Category> list = categoryDao.findAll();
		for (Category category1 : list) {
			System.out.println(category1);
		}
	}

}
