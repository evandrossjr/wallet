package entities;

import java.io.Serializable;
import java.util.Objects;

public class PaymentMethod implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id_payment_method;
	private String name_payment_method;
	
	public PaymentMethod () {
		
	}

	public PaymentMethod(Integer id_payment_method, String name_payment_method) {
		super();
		this.id_payment_method = id_payment_method;
		this.name_payment_method = name_payment_method;
	}

	public Integer getId() {
		return id_payment_method;
	}

	public void setId(Integer id_payment_method) {
		this.id_payment_method = id_payment_method;
	}

	public String getName_tag() {
		return name_payment_method;
	}

	public void setName_tag(String name_payment_method) {
		this.name_payment_method = name_payment_method;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_payment_method, name_payment_method);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethod other = (PaymentMethod) obj;
		return Objects.equals(id_payment_method, other.id_payment_method)
				&& Objects.equals(name_payment_method, other.name_payment_method);
	}

	@Override
	public String toString() {
		return "payment_method [id_payment_method=" + id_payment_method + ", name_payment_method=" + name_payment_method
				+ "]";
	}

	

}
