package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.CategoryDao;
import model.dao.DaoFactory;
import model.dao.ExpenseDao;
import model.dao.PaymentMethodDao;
import model.entities.Category;
import model.entities.Expense;
import model.entities.PaymentMethod;

public class App {

	public static void main(String[] args) {
		
		ExpenseDao expenseDao = DaoFactory.createExpenseDao();
		CategoryDao categoryDao = DaoFactory.createCategoryDao();
		PaymentMethodDao paymentMethodDao = DaoFactory.createPaymentMethodDao();
		
		Category category = null;
		PaymentMethod paymentoMethod = null;
		
		Scanner scanner = new Scanner(System.in);
		int opcao;
			
		
		while(true) {
			System.out.println("==================================");
			System.out.println("============= WALLET =============");
			System.out.println("==================================");
	
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar nova despesa");
			System.out.println("2 - Listar todas as despesas");
			System.out.println("3 - Listar todas as despesas");
			
			
			
			if (scanner.hasNextInt()) {
				opcao = scanner.nextInt();

				
				switch (opcao) {
					case 1:
						System.out.println("Cadastro de Despesa");
						
						
						scanner.nextLine(); 
						System.out.println("Digite o nome da Despesa:");
						String name = scanner.nextLine();
						
						System.out.println("Digite o valor:");
						Double value = scanner.nextDouble();
						scanner.nextLine(); 
						
						System.out.println("Digite o numero de parcelas");
						Integer parcels = scanner.nextInt();
						scanner.nextLine(); 
						
						System.out.println("Digite o método de pagamento - ex: ('Cartão', 'Pix'): ");
						String paymentMethodInput = scanner.nextLine();
						PaymentMethod paymentMethod = paymentMethodDao.findByName(paymentMethodInput);
						if(paymentMethod == null) {
							paymentMethod = new PaymentMethod(null, paymentMethodInput);
							paymentMethodDao.insert(paymentMethod);
							
							paymentMethod = paymentMethodDao.findByName(paymentMethodInput);
							
							System.out.println("Novo Método de Pagamento adicionado " + paymentMethod.getName());
						}
						
						
						
						System.out.println("Digite a categoria:");
						String categoryInput = scanner.nextLine();
						Category category1 = categoryDao.findByName(categoryInput);
						if(category1 == null) {
							category1 = new Category(null, categoryInput);
							categoryDao.insert(category1);
							
							category1 = categoryDao.findByName(categoryInput);
							System.out.println("Nova categoria adicionada " + category1.getName_category());
						}
							
						Expense newExpense = new Expense(null, name, new Date(), value, parcels, paymentoMethod, category1);
						expenseDao.insert(newExpense);
						System.out.println("Inserted New in: " + newExpense.getName());
						break;
					case 2: 
						System.out.println("Lista de Despesas");
						
						List<Expense> list = expenseDao.findAll();
						for (Expense obj : list) {
							System.out.println(obj);
						}
						break;
					case 3:
						System.out.println("Encerrando o programa");
						scanner.close();
						return;
					default:
						System.out.println("Opção Inválida! Tente novamente");
				} 
					
				
			} else {
				System.out.println("Entrada inválida, escolha apenas os números 1, 2, 3");
			}
		
		}
		
		
	}

}
