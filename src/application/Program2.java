package application;

import java.util.Date;
import java.util.List;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.entities.Category;
import model.entities.Expense;

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
		
		
		
		System.out.println("==== TEST 5: expense insert ====");
		Category newCategory = new Category(null, "Jogos");
		categoryDao.insert(newCategory);
		System.out.println("Inserted New in: " + newCategory.getName_category());
		
		
		System.out.println("==== TEST 6: expense delete ====");
		categoryDao.deleteById(4);
		System.out.println("Deleted!");
	}

}
