package model.dao;

import java.util.List;


import model.entities.PaymentMethod;

public interface PaymentMethodDao {
	void insert(PaymentMethod paymentMethod);
	void update(PaymentMethod paymentMethod);
	void deleteById(Integer id);
	PaymentMethod findById(Integer id);
	List<PaymentMethod> findAll();


}
