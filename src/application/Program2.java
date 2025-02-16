package application;

import java.util.List;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.dao.PaymentMethodDao;
import model.entities.Category;
import model.entities.PaymentMethod;

public class Program2 {

	public static void main(String[] args) {

		CategoryDao categoryDao = DaoFactory.createCategoryDao();
		PaymentMethodDao paymentMethodDao = DaoFactory.createPaymentMethodDao();
		
		System.out.println("==== TEST 1: findById ====");
		System.out.println("category");
		Category category = categoryDao.findById(3);
		System.out.println(category);
		
		System.out.println("payment method");
		PaymentMethod paymentMethod = paymentMethodDao.findById(1);
		System.out.println(paymentMethod);
		
		System.out.println("==== TEST 1.1: findByName ====");
		Category category2 = categoryDao.findByName("Lazer");
		System.out.println(category2);
		
		
		System.out.println("==== TEST 2: findAl() ====");
		System.out.println("category");
		List<Category> list = categoryDao.findAll();
		for (Category category1 : list) {
			System.out.println(category1);
		}
		
		System.out.println("payment method");
		List<PaymentMethod> list2 = paymentMethodDao.findAll();
		for (PaymentMethod paymentMethod1 : list2) {
			System.out.println(paymentMethod1);
		}
		
		
		System.out.println("==== TEST 3: insert ====");
		System.out.println("category");
		Category newCategory = new Category(null, "Pet");
		//categoryDao.insert(newCategory);
		System.out.println("Inserted New in: " + newCategory.getName_category());
		
		System.out.println("payment method");
		PaymentMethod newPaymentMethod = new PaymentMethod(null, "Financiamento"); 
		//paymentMethodDao.insert(newPaymentMethod);
		System.out.println("Inserted New in: " + newPaymentMethod.getName());

		
		System.out.println("==== TEST 4: delete ====");
		System.out.println("category");
		categoryDao.deleteById(7);
		categoryDao.deleteById(8);
		categoryDao.deleteById(9);
		categoryDao.deleteById(10);
		categoryDao.deleteById(11);
		System.out.println("Deleted!");
		
		System.out.println("payment method");
		paymentMethodDao.deleteById(6);
		paymentMethodDao.deleteById(7);
		paymentMethodDao.deleteById(8);


		System.out.println("Deleted!");
		
		System.out.println("==== TEST 5: update ====");
		System.out.println("category");
		category = categoryDao.findById(5);
		category.setName_category("Home office");
		//categoryDao.update(category);
		System.out.println("Update completed");
		
		System.out.println("payment method");
		paymentMethod = paymentMethodDao.findById(5);
		paymentMethod.setName("pix à vista");
		//paymentMethodDao.update(paymentMethod);
		System.out.println("Update Completed");
	}

}
