package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Expense implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_expense;
	private String name;
	private Date expenseDate;
	private Double value_expense;
	private Integer parcels;
	private PaymentMethod payment_method;
	private Category category;
	
	
	
	public Expense() {
		
	}


	public Expense(Integer id_expense, String name, Date expenseDate, Double value_expense, Integer parcels,
			PaymentMethod payment_method, Category category) {
		super();
		this.id_expense = id_expense;
		this.name = name;
		this.expenseDate = expenseDate;
		this.value_expense = value_expense;
		this.parcels = parcels;
		this.payment_method = payment_method;
		this.category = category;
		
	}


	public Integer getId_expense() {
		return id_expense;
	}


	public void setId_expense(Integer id_expense) {
		this.id_expense = id_expense;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getExpenseDate() {
		return expenseDate;
	}


	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}


	public Double getValue_expense() {
		return value_expense;
	}


	public void setValue_expense(Double value_expense) {
		this.value_expense = value_expense;
	}


	public Integer getParcels() {
		return parcels;
	}


	public void setParcels(Integer parcels) {
		this.parcels = parcels;
	}


	public PaymentMethod getPayment_method() {
		return payment_method;
	}


	public void setPayment_method(PaymentMethod payment_method) {
		this.payment_method = payment_method;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id_expense);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return Objects.equals(id_expense, other.id_expense);
	}


	@Override
	public String toString() {
		return "Expense [id_expense=" + id_expense + ", name=" + name + ", expenseDate=" + expenseDate
				+ ", value_expense=" + value_expense + ", parcels=" + parcels + ", payment_method=" + payment_method
				+ ", category=" + category + "]";
	}

	
	
	
	
	
}
